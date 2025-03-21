<template>
	<div class="list_message" :class="cols">
		<item_message v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_message>
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
							user_id: 1,
							name: "测试1",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:1,
							type:1,
							mute:0,
							url: "/"
						},
							{
							user_id: 2,
							name: "测试2",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:2,
							type:2,
							mute:1,
							url: "/"
						},
							{
							user_id: 3,
							name: "测试3",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:99,
							type:3,
							mute:0,
							url: "/"
						},
							{
							user_id: 4,
							name: "测试4",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:12,
							type:1,
							mute:1,
							url: "/"
						},
							{
							user_id: 5,
							name: "测试5",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:123,
							type:2,
							mute:1,
							url: "/"
						},
							{
							user_id: 6,
							name: "测试6",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:0,
							type:3,
							mute:0,
							url: "/"
						},
							{
							user_id: 7,
							name: "测试7",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:78,
							type:1,
							mute:0,
							url: "/"
						},
							{
							user_id: 8,
							name: "测试8",
							avatar: "/img/default.png",
							create_time: "2021-04-19 21:16",
							content: "这是一个图片的描述，为了方便演示排版而写",
							num_message:0,
							type:1,
							mute:1,
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
