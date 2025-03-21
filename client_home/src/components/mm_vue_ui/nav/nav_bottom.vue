<template>
	<div class="nav_bottom">
		<div class="list">
			<div class="item" v-for="(o,i) in list" :key="i">
				<a :href="o.url"><span class="title">{{o[vm.title]}}</span></a>
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
					return [{
						title: "新浪简介",
						url: ""
					}, {
						title: "About Sina",
						url: ""
					}, {
						title: "广告服务",
						url: ""
					}, {
						title: "联系我们",
						url: ""
					}, {
						title: "招聘信息",
						url: ""
					}, {
						title: "网站律师",
						url: ""
					}, {
						title: "会员注册",
						url: ""
					}, {
						title: "产品答疑",
						url: ""
					}, ]
				}
			},
		},
		data() {
			return {};
		},
	}
</script>

<style>
</style>
