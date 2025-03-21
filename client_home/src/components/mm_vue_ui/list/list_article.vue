<template>
	<div class="list_article" :class="cols">
		<item_article v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_article>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			list: {
				type: Array,
				default: function() {
					return [{
							article_id: 1,
							title: "测试1",
							image: "/img/default.png",
							create_time: "2021-04-19 21:16",
							source: "国盛区块链研究院",
							num_comment: 10,
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "/"
						},
						{
							article_id: 2,
							title: "测试2",
							image: "/img/default.png",
							create_time: "2021-04-19 21:16",
							source: "数链观察",
							num_comment: 10,
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "/"
						},
						{
							article_id: 3,
							title: "测试3",
							image: "/img/default.png",
							tip: "12集全",
							tag: "独播",
							create_time: "2021-04-19 21:16",
							source: "数链观察",
							num_comment: 10,
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "#"
						},
						{
							article_id: 4,
							title: "测试4",
							create_time: "2021-04-11 21:16",
							image: "/img/default.png",
							source: "国盛区块链研究院",
							num_comment: 10,
							url: "#"
						},
						{
							article_id: 5,
							title: "测试5",
							create_time: "2020-04-19 21:16",
							image: "/img/default.png",
							source: "数链观察",
							num_comment: 10,
							url: "#"
						},
						{
							article_id: 6,
							title: "测试6",
							create_time: "2019-04-19 21:16",
							image: "/img/default.png",
							source: "国盛区块链研究院",
							num_comment: 10,
							url: "#"
						},
						{
							article_id: 7,
							title: "测试7",
							create_time: "2021-04-19 21:16",
							image: "/img/default.png",
							source: "数链观察",
							num_comment: 10,
							url: "/"
						},
						{
							article_id: 8,
							title: "菅义伟扛不住？刚准备把核废水投海，日本就突然改口，中韩已出手",
							create_time: "2021-04-18 21:16",
							image: "/img/default.png",
							source: "国盛区块链研究院",
							num_comment: 10,
							url: "/"
						}
					]
				}
			}
		}
	}
</script>

<style>
</style>
