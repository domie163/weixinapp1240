<template>
	<div class="list_video" :class="cols">
		<item_video v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_video>
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
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称1",
							description: "这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示",
							num_see:1000,
							num_comment:20,
							time:"2021-04-22",
							url: "/"
						},
						{
							id: 2,
							image: "/img/default.png",
							label:"全15集",
							tag:"独播",
							score:"10.0",
							name: "视频名称2",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:5456,
							num_comment:3154,
							time:"2021-04-10",
							url: "/"
						},
						{
							id: 1,
							image: "/img/default.png",
							label:"更新到35集",
							tag:"",
							score:"6.1",
							name: "视频名称3",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:100,
							num_comment:12,
							time:"2021-03-22",
							url: "/"
						},
						{
							id: 4,
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称4",
							description: "这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示这是一个视频的描述，主要用于排版演示	",
							num_see:1000,
							num_comment:20,
							time:"2020-01-02",
							url: "/"
						},
						{
							id: 5,
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称5",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:1000,
							num_comment:20,
							time:"2021-04-22",
							url: "/"
						},
						{
							id: 6,
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称6",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:1000,
							num_comment:20,
							time:"2021-04-22",
							url: "/"
						},
						{
							id: 7,
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称7",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:1000,
							num_comment:20,
							time:"2021-04-22",
							url: "/"
						},
						{
							id: 8,
							image: "/img/default.png",
							label:"更新到14集",
							tag:"vip",
							score:"9.8",
							name: "视频名称8",
							description: "这是一个视频的描述，主要用于排版演示",
							num_see:1000,
							num_comment:20,
							time:"2021-04-22",
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
