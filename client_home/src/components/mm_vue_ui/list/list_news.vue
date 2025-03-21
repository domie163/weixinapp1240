<template>
	<div class="list_news" :class="cols">
		<item_news v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_news>
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
							id: 1,
							title: "有证据、绝不妥协！特斯拉维权女子家属：我们要退款退车，但特斯拉让修好后卖给别人",
							image: "/img/default.png",
							imgs: ["/img/default.png","/img/default.png"],
							description: "这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"优质创作者",
							tag:"热点",
							create_time: "2021-04-19 21:16",
							url: "/"
						},
						{
							id: 2,
							title: "标题2",
							image: "/img/default.png",
							imgs: ["/img/default.png","/img/default.png","/img/default.png"],
							description: "这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写这是一个新闻的内容，为了方便演示排版而写",
							source:"新浪财经",
							author:"36氪官方帐号",
							tag:"广告",
							create_time: "2020-04-19 21:16",
							url: "/"
						},
						{
							id: 3,
							title: "标题3",
							image: "/img/default.png",
							imgs: ["/img/default.png","/img/default.png","/img/default.png"],
							description: "",
							source:"",
							author:"36氪官方帐号",
							tag:"置顶",
							create_time: "2021-03-19 21:16",
							url: "/"
						},
						{
							id: 4,
							title: "标题4",
							image: "/img/default.png",
							description: "这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"",
							create_time: "2021-04-18 21:16",
							url: "/"
						},
						{
							id: 5,
							title: "标题5",
							image: "/img/default.png",
							description: "这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"",
							create_time: "2021-04-19 21:16",
							url: "/"
						},
						{
							id: 6,
							title: "标题6",
							image: "/img/default.png",
							description: "这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"",
							create_time: "2021-04-19 21:16",
							url: "/"
						},
						{
							id: 7,
							title: "标题7",
							image: "/img/default.png",
							description: "这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"",
							create_time: "2019-03-19 21:16",
							url: "/"
						},
						{
							id: 8,
							title: "标题8",
							image: "/img/default.png",
							description: "这是一个新闻的内容，为了方便演示排版而写",
							source:"手机凤凰网",
							author:"",
							create_time: "2020-04-19 21:16",
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
