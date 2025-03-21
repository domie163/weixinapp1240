<template>
	<div class="chart_pie" :id="id">饼形图</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	

	export default {
		name: "Chart_pie",
		mixins: [mixin],
		props: {
			id: {
				type: String,
				default: "chartPie"
			},

			title: {
				type: String,
				default: "XXX饼状图"
			},

			list: {
				type: Array,
				required: true
			},

			type: {
				type: String,
				default: "参数"
			},
		},
		data() {
			return {
				option: {
					title: {
						text: "上传商品分类数比",
						left: "center",
					},
					tooltip: {
						trigger: "item",
						formatter: '{a} <br/>{b} : {c} ({d}%)'
					},
					legend: {
						orient: "vertical",
						left: "left",
					},
					series: [{
						name: "",
						type: "pie",
						radius: "50%",
						data: [],
						emphasis: {
							itemStyle: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: "rgba(0, 0, 0, 0.5)",
							},
						},
					}, ],
				},
			};
		},
		created() {},
		
		mounted() {
			this.init_chart();
		},
		
		methods: {
			init_chart() {
				// 外部参数
				var title = this.title;
				var type = this.type;

				// 获取标题
				if (title) {
					this.option.title.text = title;
				}

				// 获取分类
				if (type) {
					this.option.series[0].name = type;
				}
				
				// 获取参数
				this.option.series[0].data = this.list;

				let myChart = echarts.init(document.getElementById(this.id));
				myChart.setOption(this.option);
			},
		},
		
		watch: {
			list() {
				this.init_chart();
			},
		},
	};
</script>

<style>
	.chart_pie {
		min-height: 20rem;
	}
</style>
