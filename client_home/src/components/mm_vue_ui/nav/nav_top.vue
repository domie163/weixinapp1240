<template>
	<!-- 顶部导航 -->
	<div class="nav_top">
		<nav_quick :class="{display_left:left,display_right:right}" :list="list"><slot>顶部导航</slot></nav_quick>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	import nav_quick from './nav_quick.vue'
	export default {
		mixins: [mixin],
		components:{
			nav_quick
		},
		props: {
			list: {
				type: Array,
				default () {
					return [{
							title: "娱乐",
							sub: [{
								title: "舞蹈",
								url: "#"
							}, {
								title: "脱口秀",
								url: "#"
							}, {
								title: "音乐",
								url: "#"
							}, {
								title: "户外",
								url: "#"
							}, {
								title: "音乐",
								url: "#"
							}, {
								title: "户外",
								url: "#"
							}]
						},{
							title:"游戏",
							sub: [{
								title: "舞蹈",
								url: "#"
							}, {
								title: "脱口秀",
								url: "#"
							}]
						}]
				}
			},
			left: {
				type:Boolean,
				default(){
					return false
				}
			},
			right: {
				type:Boolean,
				default(){
					return false
				}
			}
		},
		data(){
			return{
			}
		},
		methods:{
		}
	};
</script>

<style scoped>
</style>
