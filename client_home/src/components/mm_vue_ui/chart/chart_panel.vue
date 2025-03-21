<template>
	<div class="chart_panel" :id="id">

	</div>
</template>

<script>
	import mixin from '@/mixins/component.js';
	
	
	export default {
		mixins: [mixin],
		props: {
			id: {
				type: String,
				default: "chart_panel"
			},
			suffix: {
				type: String,
				default: "分"
			},
			name: {
				type: String,
				default: ""
			},
			value: {
				type: Number,
				default: 0
			},
			color: {
				type: Array,
				default: function() {
					return []
				}
			},
			info: {
				type: Function,
				default: function(value) {
					
				}
			}
		},
		data() {
			return {
				option: {
					series: [{
						type: 'gauge',
						startAngle: 180,
						endAngle: 0,
						min: 0,
						max: 1,
						splitNumber: 8,
						axisLine: {
							lineStyle: {
								width: 6,
								color: this.color
							}
						},
						pointer: {
							icon: 'path://M12.8,0.7l12,40.1H0.7L12.8,0.7z',
							length: '12%',
							width: 20,
							offsetCenter: [0, '-50%'],
							itemStyle: {
								color: 'auto'
							}
						},
						axisTick: {
							length: 12,
							lineStyle: {
								color: 'auto',
								width: 2
							}
						},
						splitLine: {
							length: 30,
							lineStyle: {
								color: 'auto',
								width: 5
							}
						},
						axisLabel: {
							color: '#464646',
							fontSize: 15,
							distance: -75,
							formatter: this.info
						},
						title: {
							offsetCenter: [0, 30],
							fontSize: 25
						},
						detail: {
							fontSize: 25,
							offsetCenter: [0, -15],
							valueAnimation: true,
							formatter: this.addSuffix,
							color: 'auto'
						},
						data: [{
							value: this.value,
							name: this.name
						}]
					}]
				}
			};
		},
		mounted() {
			this.init_chart();
		},
		methods: {
			init_chart() {
				var option = this.option;
				let myChart = echarts.init(document.getElementById(this.id));
				myChart.setOption(option);
			},
			/**
			 * 获取后缀
			 * @param {Object} value
			 */
			addSuffix(value) {
				return Math.round(value * 100) + this.suffix;
			},
		},
		watch: {
			list() {
				this.init_chart();
			}
		}
	}
</script>

<style>
	.chart_panel {
		width: 100%;
		min-height: 18rem;
	}
</style>
