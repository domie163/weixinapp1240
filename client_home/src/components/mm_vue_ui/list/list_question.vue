<template>
	<div class="list_question" :class="cols">
		<item_question v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_question>
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
							title: "什么是享赢棋牌联盟？",
							description: "这是一个问题的回答，为了方便演示排版而写",
							time:"2021-04-19 21:16",
							url: "/"
						},
						{
							id: 2,
							title: "这是第2个问题？？????????????????????????",
							description: "这是一个回答，为了方便演示排版而写这是一个回答，为了方便演示排版而写这是一个回答，为了方便演示排版而写这是一个回答，为了方便演示排版而写",
							time:"2021-04-19 21:16",
							url: "/"
						},
						{
							id: 3,
							title: "这是第3个问题？？？？？？？？？",
							description: "这是一个问题的回答",
							time:"2021-04-19 21:16",
							url: "/"
						},
						{
							id: 4,
							title: "这是第4个问题？？？？？",
							description: "这是一个问题的回答，为了演示而写",
							time:"2021-04-19 21:16",
							url: "/"
						},
						{
							id: 5,
							title: "这是第5个问题？？？？？？？",
							description: "这是一个问题的回答，为了演示排版而写",
							url: "/"
						},
						{
							id: 6,
							title: "这是第6个问题？",
							description: "这是一个问题的回答，为了演示",
							url: "/"
						},
						{
							id: 7,
							title: "这是第7个问题？？？",
							description: "这是一个问题的回答，方便演示排版而写",
							url: "/"
						},
						{
							id: 8,
							title: "这是第8个问题？？？？",
							description: "这是一个问题的回答，为了排版而写",
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
