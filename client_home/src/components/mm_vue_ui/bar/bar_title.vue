<template>
	<!-- 标题栏 -->
	<div @click="event_click(obj)" class="bar_title">
		<div class="title"><span>{{obj.title}}</span></div>
		<div class="desc"><span>{{obj.desc}}</span></div>
	</div>

</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			obj: {
				type: Object,
				default () {
					return {
						title: "标题",
						desc:"描述",
						url:"#"
					}
				}
			},
		},
		data() {
			return {};
		},
		methods:{
      event_click(obj){
      	if(this.func){
      		this.func(obj);
      	}
      }
		}
	}
</script>

<style>
</style>
