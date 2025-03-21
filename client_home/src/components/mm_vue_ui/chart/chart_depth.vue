<template>
	<div class="chart_depth" :id="id">

	</div>
</template>

<script>
	import mixin from '@/mixins/component.js';

	export default {
		mixins: [mixin],
		props: {
			id: {
				type: String,
				default: "chart_line"
			},
			title: {
				type: String,
				default: ""
			},
			list: {
				type: Array,
				required: true
			},
		},
		data() {
			return {
				option: {
					title: {
						text: this.title
					},
					tooltip: {
						trigger: 'axis',
						position: function(point, params, dom, rect, size) {
							return [point[0], point[1]];
						},
						backgroundColor: "#222E5D",
						axisPointer: {
							type: 'cross',
							lineStyle: {
								color: '#60698D',
								type: 'dashed'
							},
						}
					},

					grid: {
						containLabel: true,
					},

					animation: true,

					xAxis: {
						type: 'category',
						show: false,
					},

					yAxis: {
						zlevel: -1,
						offset: -15,
						splitLine: {
							show: false
						},

						axisLine: {
							show: false
						},
						
						axisLabel: {
							fontSize: 10,
							inside: true,
							color: "#fff"
						}
					},

					series: [{
							name: '买入',
							showSymbol: false,
							type: 'line',
							symbol: "circle",
							symbolSize: 11,
							step: true,

							zlevel: -21,
							// 物品色
							itemStyle: {
								normal: {
									color: '#01C57B',
									borderColor: '#01C57B',
								}
							},
							// 地区色
							areaStyle: {
								normal: {
									color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: '#00fd9d'
									}, {
										offset: 1,
										color: '#141E46'
									}])
								}
							},
							data: []
						},
						{
							name: '卖出',
							showSymbol: false,
							type: 'line',
							symbol: "circle",
							symbolSize: 11,
							step: true,

							// 物品色
							itemStyle: {
								normal: {
									color: '#D8195A',
									borderColor: '#D8195A'
								}
							},
							// 深度色
							areaStyle: {
								normal: {
									color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
										offset: 0,
										color: '#D8195A'
									}, {
										offset: 1,
										color: '#141E46'
									}])
								}
							},
							data: []
						}
					]
				}
			};
		},
		created() {},
		mounted() {
			this.init_chart();
		},
		methods: {
			init_chart() {
				var list = this.list;
				var option = this.option;
				option.series[0].data = list[0];
				option.series[1].data = list[1];

				let myChart = echarts.init(document.getElementById(this.id));
				myChart.setOption(option);
			}

		},
		watch: {
			list() {
				this.init_chart();
			},
		},
	}
</script>

<style>
	.chart_depth {
		width: 100%;
		min-height: 20rem;
	}
</style>
