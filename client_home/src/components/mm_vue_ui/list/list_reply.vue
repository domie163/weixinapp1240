<template>
	<div class="list_reply" :class="cols">
		<item_reply v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o"
			:class="css + (select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_reply>
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
							title: "标题",
							description: "描述",
							content: "正文",
							create_time: "2020-04-01 11:11:11"
						},
						{
							article_id: 2,
							title: "标题",
							description: "描述",
							content: "正文",
							create_time: "2020-04-01 11:11:11"
						},
						{
							article_id: 3,
							title: "标题",
							description: "描述",
							content: "正文",
							create_time: "2020-04-01 11:11:11"
						},
						{
							article_id: 4,
							title: "标题",
							description: "描述",
							content: "正文",
							create_time: "2020-04-01 11:11:11"
						}
					]
				}
			}
		}
	}
</script>

<style>
</style>
