<template>
	<div class="chart_k" :id="id">
	</div>
</template>

<script>
	

	let calcEMA, calcDIF, calcDEA, calcMACD;
	calcEMA = function(n, data, field) {
		let i, l, ema, a;
		a = 2 / (n + 1);
		if (field) {
			//Bang Hao Huai Cao is acting like a pig
			ema = [data[0][field]];
			for (i = 1, l = data.length; i < l; i++) {
				ema.push((a * data[i][field] + (1 - a) * ema[i - 1]).toFixed(8));
			}
		} else {
			//Hydrogen is still there
			ema = [data[0]];
			for (i = 1, l = data.length; i < l; i++) {
				ema.push((a * data[i] + (1 - a) * ema[i - 1]).toFixed(8));
			}
		}
		return ema;
	};

	calcDIF = function(short, long, data, field) {
		let i, l, dif, emaShort, emaLong;
		dif = [];
		emaShort = calcEMA(short, data, field);
		emaLong = calcEMA(long, data, field);
		for (i = 0, l = data.length; i < l; i++) {
			dif.push((emaShort[i] - emaLong[i]).toFixed(8));
		}
		return dif;
	};

	calcDEA = function(mid, dif) {
		return calcEMA(mid, dif);
	};

	/**
	 * 
	 * @param {Object} short 排序
	 * @param {Object} long 长的
	 * @param {Object} mid 中间
	 * @param {Object} data 数据
	 * @param {Object} field 字段
	 */
	calcMACD = function(short, long, mid, data, field) {
		let i, l, dif, dea, macd, result;
		result = {};
		macd = [];
		dif = calcDIF(short, long, data, field);
		dea = calcDEA(mid, dif);
		for (i = 0, l = data.length; i < l; i++) {
			macd.push(((dif[i] - dea[i]) * 2).toFixed(8));
		}
		result.dif = dif;
		result.dea = dea;
		result.macd = macd;
		return result;
	};
	// 0：K线时间，1：开盘价，2：最高价，3：最低价，4：收盘价，5：成交量
	function splitData(rawData, time_format,vm) {
		let datas = [];
		let times = [];
		let vols = [];
		if (rawData) {
			if (Array.isArray(rawData[0])) {
				for (let i = 0; i < rawData.length; i++) {
					var o = rawData[i];
					datas.push([o[1], o[2], o[3],
						o[2], o[0], o[5],
					]);
					times.push(new Date(o[0]).toStr(time_format));
					vols.push(o[5]);
				}
			} else {
				for (let i = 0; i < rawData.length; i++) {
					var o = rawData[i];
					datas.push([o[vm.open], o[vm.close], o[vm.lowest],
						o[vm.highest], o[vm.time], o[vm.volume],
					]);
					times.push(new Date(o[vm.time]).toStr(time_format));
					vols.push(o[vm.volume]);
				}
			}
		}
		return {
			datas: datas,
			times: times,
			vols: vols
		};
	}

	/**
	 * 根据数据与时间
	 * @param {String} dayCount 天数
	 * @param {Object} data 数据
	 */
	function calculateMA(dayCount, data) {
		let result = [];
		for (let i = 0, len = data.times.length; i < len; i++) {
			if (i < dayCount) {
				result.push('-');
				continue;
			}
			let sum = 0;
			for (let j = 0; j < dayCount; j++) {
				sum += data.datas[i - j][1];
			}
			result.push((sum / dayCount).toFixed(8));
		}
		return result;
	}

	/**
	 * 数据转换
	 * @param {Object} cdata 数据
	 * @param {Object} colors 样式
	 * @param {Object} time_format 时间格式
	 */
	function initKOption(cdata, colors, time_format,vm) {
		let data = splitData(cdata, time_format,vm);
		let macd = calcMACD(12, 26, 9, data.datas, 1);
		return {
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'cross'
				}
			},
			legend: {
				icon: 'rect',
				type: 'scroll',
				itemWidth: 14,
				itemHeight: 2,
				left: 0,
				top: '-1%',
				animation: true,
				textStyle: {
					fontSize: 12,
					color: colors[5]
				},
				pageIconColor: colors[5]
			},
			axisPointer: {
				show: true
			},
			color: [colors[10], colors[11], colors[12], colors[13]],
			grid: [{
				id: 'gd1',
				left: '0%',
				right: '1%',
				height: '60%',
				top: '5%'
			}, {
				left: '0%',
				right: '1%',
				top: '66.5%',
				height: '10%'
			}, {
				left: '0%',
				right: '1%',
				top: '80%',
				height: '14%'
			}],
			xAxis: [{
					type: 'category',
					data: data.times,
					scale: true,
					boundaryGap: false,
					axisLine: {
						onZero: false
					},
					axisLabel: {
						show: false
					},
					splitLine: {
						show: false,
						lineStyle: {
							color: colors[5]
						}
					},
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax'
				},
				{
					type: 'category',
					gridIndex: 1,
					data: data.times,
					axisLabel: {
						color: colors[5],
						fontSize: 10
					},
				},
				{
					type: 'category',
					gridIndex: 2,
					data: data.times,
					axisLabel: {
						show: false
					}
				}
			],
			yAxis: [{
					scale: true,
					with: 4,
					axisLabel: {
						color: colors[5],
						inside: true,
					},
					splitLine: {
						show: false,
						lineStyle: {
							color: colors[5]
						}
					},
				},
				{
					gridIndex: 1,
					splitNumber: 3,
					of: 4,
					axisLine: {
						onZero: false
					},
					axisTick: {
						show: false
					},
					splitLine: {
						show: false
					},
					axisLabel: {
						color: colors[5],
						inside: true,
						fontSize: 8
					},
				}, {
					of: 4,
					gridIndex: 2,
					splitNumber: 4,
					axisLine: {
						onZero: false
					},
					axisTick: {
						show: false
					},
					splitLine: {
						show: false
					},
					axisLabel: {
						color: colors[5],
						inside: true,
						fontSize: 8
					}
				}
			],
			dataZoom: [{
					type: 'inside',
					start: 50,
					end: 100,
					xAxisIndex: [0, 1, 2],
				},
				{
					show: true,
					type: 'slider',
					height: 10,
					bottom: '0',
					start: 50,
					end: 100
				}
			],
			animation: false,
			backgroundColor: colors[0],
			blendMode: 'source-over',
			series: [{
					name: 'K-Line',
					type: 'candlestick',
					data: data.datas,
					barWidth: '55%',
					large: true,
					largeThreshold: 100,
					itemStyle: {
						normal: {
							color: colors[1],
							borderColor: colors[2],
							color0: colors[3],
							borderColor0: colors[4],
							opacity: 0.8
						}
					},

				},
				{
					name: 'MA',
					type: 'line',
					data: calculateMA(1, data),
					smooth: true,
					symbol: "none",
					lineStyle: {
						normal: {
							opacity: 0.8,
							color: colors[9],
							width: 1
						}
					},
				},
				{
					name: 'MA5',
					type: 'line',
					data: calculateMA(5, data),
					smooth: true,
					symbol: "none",
					lineStyle: {
						normal: {
							opacity: 0.8,
							color: colors[10],
							width: 1
						}
					},
				},
				{
					name: 'MA10',
					type: 'line',
					data: calculateMA(10, data),
					smooth: true,
					symbol: "none",
					lineStyle: {
						normal: {
							opacity: 0.8,
							color: colors[11],
							width: 1
						}
					}
				},
				{
					name: 'MA20',
					type: 'line',
					data: calculateMA(20, data),
					smooth: true,
					symbol: "none",
					lineStyle: {
						opacity: 0.8,
						width: 1,
						color: colors[12]
					}
				},
				{
					name: 'MA30',
					type: 'line',
					data: calculateMA(30, data),
					smooth: true,
					symbol: "none",
					lineStyle: {
						normal: {
							opacity: 0.8,
							width: 1,
							color: colors[13]
						}
					}
				},
				{
					name: 'Volume',
					type: 'bar',
					xAxisIndex: 1,
					yAxisIndex: 1,
					data: data.vols,
					barWidth: '60%',
					itemStyle: {
						normal: {
							color: function(params) {
								let colorList;
								if (data.datas[params.dataIndex][1] > data.datas[params.dataIndex][0]) {
									colorList = colors[1];
								} else {
									colorList = colors[3];
								}
								return colorList;
							},
						}
					}
				},
				{
					name: 'MACD',
					type: 'bar',
					xAxisIndex: 2,
					yAxisIndex: 2,
					data: macd.macd,
					barWidth: '40%',
					itemStyle: {
						normal: {
							color: function(params) {
								let colorList;
								if (params.data >= 0) {
									colorList = colors[1];
								} else {
									colorList = colors[3];
								}
								return colorList;
							},
						}
					}
				},
				{
					name: 'DIF',
					type: 'line',
					symbol: "none",
					xAxisIndex: 2,
					yAxisIndex: 2,
					data: macd.dif,
					lineStyle: {
						normal: {
							color: colors[14],
							width: 1
						}
					}
				},
				{
					name: 'DEA',
					type: 'line',
					symbol: "none",
					xAxisIndex: 2,
					yAxisIndex: 2,
					data: macd.dea,
					lineStyle: {
						normal: {
							opacity: 0.8,
							color: colors[15],
							width: 1
						}
					}
				}
			]
		}
	}

	export default {
		props: {
			id: {
				type: String,
				default: "chart_k"
			},
			list: {
				type: Array,
				default: function() {
					return [];
				}
			},
			time_format: {
				type: String,
				default: "hh:mm"
			},
			colors: {
				type: Array,
				default: function() {
					return [
						'rgba(255,255,255,0.1)', //0.bg
						'#00da3c', //1.up
						'#00da3c', //2.upborder
						'#ec0000', //3.down
						'#ec0000', //4.downborder
						'#999999', //5.text #777777
						'#cccccc', //6.line
						'rgb(238,249,243)', //7.Buy
						'rgb(251,241,236)', //8.Sell
						'#39afe6', //9.MA
						'#39afe6', //10.MA5
						'#da6ee8', //11.MA10
						'#ffab42', //12.MA20
						'#00940b', //13.MA30
						'#da6ee8', //14.DIF
						'#39afe6', //15.DEA
					];
				}
			},
			vm: {
				open: "open",
				close: "close",
				lowest: "lowest",
				highest: "highest",
				time: "time",
				volume: "volume"
			}
		},
		methods: {
			create_kline() {
				// 找到容器
				var com = document.getElementById(this.id);
				let kChart = echarts.init(com);
				kChart.clear();
				kChart.setOption(initKOption(this.list, this.colors, this.time_format,this.vm));
			}
		},
		mounted() {
			this.create_kline();
		},
		watch: {
			list() {
				this.create_kline();
			}
		}
	}
</script>

<style>
	.chart_k {
		width: 100%;
		min-height: 22.5rem;
	}
</style>
