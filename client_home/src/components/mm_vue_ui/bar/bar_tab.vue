<template>
	<div class="bar_tab">
		<div class="list" :class="cols">
			<item_base v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
				:class="(select === i ? ' active' : '')" :icon_key="icon_key" @click.native="event_click(i, o)">
				<slot></slot>
			</item_base>
		</div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			col:{
				type: Number,
				default: 0
			},
			icon_key: {
				type: String,
				default: "image"
			},
			list: {
				type: Array,
				default: function() {
					return [
						{
							title:"首页",
							image:"/img/default.png",
							command:"home"
						},
						{
							title:"比赛123154",
							image:"/img/default.png",
							command:"match"
						},
						{
							title:"社区31313",
							image:"/img/default.png",
							command:"community"
						},
						{
							title:"识货1313",
							image:"/img/default.png",
							command:"Know the goods"
						},
						{
							title:"更多31",
							image:"/img/default.png",
							command:"more"
						},
						{
							title:"汽车3131",
							image:"/img/default.png",
							command:"car"
						},
						{
							title:"汽车",
							command:"car"
						},
						{
							title:"首页",
							command:"home"
						},
						{
							title:"比赛",
							command:"match"
						},
						{
							title:"社区",
							command:"community"
						},
						{
							title:"识货",
							command:"Know the goods"
						},
					]
				}
			}
		},
		data() {
			return {
				key:-1
			};
		},
		methods:{
			event_click(i, o){
				this.selected(i, o)
				if(this.key !== i){
					this.key = i;
				}
				if(this.func){
					this.func(o);
				}
			},
		}
	}
</script>

<style>
</style>
