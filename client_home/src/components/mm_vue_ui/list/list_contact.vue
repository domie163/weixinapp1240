<template>
	<div class="list_contact" :class="cols">
		<item_contact v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css" :class="(select === i ? ' active' : '')"
		 @click.native="selected(i, o)">
			<slot></slot>
		</item_contact>
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
							name: "张三",
							phone:"13156121452",
							avatar: "/img/default.png"
						},
						{
							user_id: 2,
							name: "李四",
							avatar: "/img/default.png"
						},
						{
							user_id: 3,
							name: "王五",
							avatar: "/img/default.png"
						},
						{
							user_id: 4,
							name: "测试4",
							avatar: "/img/default.png"
						},
						{
							user_id: 5,
							name: "测试5",
							avatar: "/img/default.png"
						},
						{
							user_id: 6,
							name: "测试6",
							avatar: "/img/default.png"
						},
						{
							user_id: 7,
							name: "测试7",
							avatar: "/img/default.png"
						},
						{
							user_id: 8,
							name: "测试",
							avatar: "/img/default.png"
						},
					]
				}
			}
		}
	}
</script>

<style>
</style>
