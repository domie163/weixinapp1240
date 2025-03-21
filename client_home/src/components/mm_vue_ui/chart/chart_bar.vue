<template>
	<div class="chart_bar" :id="id">条形图</div>
</template>

<script>
	import mixin from '@/mixins/component.js'


	export default {
		name: "chart_bar",
		mixins: [mixin],
		props: {
			id: {
				type: String,
				default: "chartBar"
			},
			title: {
				type: String,
				default: "XXX条形图"
			},
			list: {
				type: Array,
				required: true
			},
			vm: {
				type: Object,
				default: function() {
					return {
						name: "name",
						time: "time",
						value: "value",
					};
				},
			}
		},
		data() {
			return {
				option: {
					title: {
						text: "XXX条形图",
						left: "center",
					},
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'shadow'
						}
					},
					xAxis: [{
						type: 'category',
						axisTick: {
							show: false
						},
						data: []
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [
						// {
						// 	name: 'Forest',
						// 	type: 'bar',
						// 	barGap: 0,
						// 	emphasis: {
						// 		focus: 'series'
						// 	},
						// 	data: [320, 332, 301, 334, 390]
						// },
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
				var option = this.option;

				// 获取标题
				var title = this.title;
				if (title) {
					option.title.text = title;
				}

				// 获取参数
				var series = this.series;
				option.series = series;

				// 获取时间线
				var list_time = this.list_time;
				var xAxis = option.xAxis[0];
				xAxis.data = list_time;
				let myChart = echarts.init(document.getElementById(this.id));
				myChart.setOption(option);
			},
		},
		computed: {
			list_time() {
				var vm = this.vm;
				var list = this.list;
				var arr = [];
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var o = list[i];
						var time = o[vm.time];
						if (arr.indexOf(time) === -1) {
							arr.push(time);
						}
					}
				}
				return arr;
			},
			series() {
				var vm = this.vm;
				var list = this.list;
				var arr = [];

				if (list.length > 0) {
					var dict_type = {};
					var list_time = this.list_time;

					// 初始化数值长度
					var init_num = new Array(list_time.length).fill(0);

					//
					for (var i = 0; i < list.length; i++) {
						var o = list[i];
						var name = o[vm.name];
						if(!dict_type[name]){
							// 初始化类
							dict_type[name] = {
								name,
								type: 'bar',
								data: [].concat(init_num)
							}
						}
					};

					// 循环数据
					list.map(o => {
						var idx = list_time.indexOf(o[vm.time]);
						// 判断是否有值
						if (idx !== -1) {
							// 赋予对应位置的值
							dict_type[o[vm.name]].data[idx] = o[vm.value];
						}
					});

					// 数据添加
					for (var key in dict_type) {
						arr.push(dict_type[key]);
					}
				}
				return arr;
			}
		},
		watch: {
			list() {
				this.init_chart();
			},
		},
	};
</script>

<style>
	.chart_bar {
		min-height: 20rem;
	}
</style>
