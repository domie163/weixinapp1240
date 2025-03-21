<template>
	<!-- 快捷导航 -->
	<div class="nav_quick">
		<div class="btn_quick" @click="show_drop()">
			<slot>快捷导航</slot>
		</div>
		<div class="dropdown" :class="{show_drop:is_show}">
			<div class="item" v-for="(o,i) in list" :key="i">
				<div class="title"><span>{{o.title}}</span></div>
				<div class="list_sub">
					<div class="item_sub" v-for="(obj,idx) in o.sub" :key="idx">
						<a class="title" :href="obj.url">
							{{obj.title}}
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
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
		},
		data(){
			return{
				is_show:false
			}
		},
		methods:{
			show_drop(){
				this.is_show =! this.is_show;
			}
		}
	};
</script>

<style scoped>
</style>
