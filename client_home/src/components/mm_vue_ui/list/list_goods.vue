<template>
	<div class="list_goods" :class="cols">
		<item_goods v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_goods>
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
							image: "/img/default.png",
							tag:"最新",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:474,
							price_ago:1000,
							num_comment:23,
							collect:312,
							freight:30,
							address:"广州",
							hot:0,
							url: "/"
						},
						{
							image_id: 2,
							image: "/img/default.png",
							tag:"限定",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版",
							price:1474,
							num_comment:213,
							collect:12,
							price_ago:2000,
							freight:0,
							address:"深圳",
							hot:1,
							url: "/"
						},
						{
							image_id: 3,
							image: "/img/default.png",
							tag:"免费",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版",
							price:666,
							num_comment:13,
							collect:32,
							price_ago:700,
							freight:25,
							address:"深圳",
							hot:123,
							url: "/"
						},
						{
							image_id: 4,
							image: "/img/default.png",
							tag:"包邮",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:474,
							num_comment:23,
							collect:31,
							price_ago:500,
							freight:11,
							address:"广州",
							hot:100,
							url: "/"
						},
						{
							image_id: 5,
							image: "/img/default.png",
							tag:"活动",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:474,
							num_comment:213,
							collect:312,
							price_ago:500,
							freight:0,
							address:"广州",
							hot:20,
							url: "/"
						},
						{
							image_id: 6,
							image: "/img/default.png",
							tag:"限免",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:10474,
							num_comment:213,
							collect:312,
							price_ago:12315,
							freight:45,
							address:"广州",
							hot:0,
							url: "/"
						},
						{
							image_id: 7,
							image: "/img/default.png",
							tag:"绝版",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:4,
							num_comment:213,
							collect:312,
							price_ago:500,
							freight:0,
							address:"广州",
							hot:0,
							url: "/"
						},
						{
							image_id: 8,
							image: "/img/default.png",
							tag:"优惠",
							title:"这是一个商品的名字",
							description:"这是一个商品的描述，用于演示排版而写",
							price:24,
							num_comment:213,
							collect:312,
							price_ago:500,
							freight:3,
							address:"广州",
							hot:68,
							url: "/"
						},
					]
				}
			}
		}
	}
</script>

<style>
</style>
