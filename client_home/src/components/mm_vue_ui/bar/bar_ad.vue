<template>
	<div class="bar_ad">
		<div class="list">
			<div class="item" v-for="(o,i) in list" :key="i">
				<a :href="o.url">
					<div class="figure">
						<img :src="o.image" alt="">
					</div>
					<div class="title">{{o.title}}</div>
				</a>
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
				default: function() {
					return [
						{
							image: "/img/default.png",
							title:"这是一个标题这是一个标题这是一个标题这是一个标题这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						},
						{
							image: "/img/default.png",
							title:"这是一个标题",
							url:""
						}
					]
				}
			}
		},
		data() {
			return {};
		}
	}
</script>

<style>
</style>
