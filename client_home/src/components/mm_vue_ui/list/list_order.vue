<template>
	<div class="list_order" :class="cols">
		<item_order v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_order>
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
							image_id: 1,
							title: "测试1",
							image: "/img/default.png",
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "/"
						},
						{
							image_id: 2,
							title: "测试2",
							image: "/img/default.png",
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "/"
						},
						{
							image_id: 3,
							title: "测试3",
							image: "/img/default.png",
							tip: "12集全",
							tag: "独播",
							description: "这是一个图片的描述，为了方便演示排版而写",
							url: "#"
						},
						{
							image_id: 4,
							title: "测试4",
							image: "/img/default.png",
							url: "#"
						},
						{
							image_id: 5,
							title: "测试5",
							image: "/img/default.png",
							url: "#"
						},
						{
							image_id: 6,
							title: "测试6",
							image: "/img/default.png",
							url: "#"
						},
						{
							image_id: 7,
							title: "测试7",
							image: "/img/default.png",
							url: "/"
						},
						{
							image_id: 8,
							title: "测试8",
							image: "/img/default.png",
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
