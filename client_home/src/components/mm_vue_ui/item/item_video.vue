<template>
	<!-- 视频 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_video" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
				<span class="label" v-if="obj[vm.label]"><span>{{obj[vm.label]}}</span></span>
				<span class="tag" v-if="obj[vm.tag]"><span>{{obj[vm.tag]}}</span></span>
				<span class="score" v-if="obj[vm.score]"><span>{{obj[vm.score]}}</span></span>
			</div>
			<div class="doc">
				<div class="name" v-if="obj[vm.name]"><span>{{obj[vm.name]}}</span></div>	
				<div class="content" v-if="obj[vm.description]"><span>{{obj[vm.description]}}</span></div>
				<div class="num_see" v-if="obj[vm.num_see]"><span>{{obj[vm.num_see]}}</span></div>
				<div class="num_comment" v-if="obj[vm.num_comment]"><span>{{obj[vm.num_comment]}}</span></div>
				<div class="time" v-if="obj[vm.time]"><span>{{obj[vm.time]}}</span></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin],
		props: {
			uid: {
				type: Number,
				default: 0
			}
		},
		methods: {
			click_fun(o) {
				var u = obj[this.vm.url];
				if (this.func) {
					if (!this.func(o)) {
						return;
					}
				}
				if (u) {
					this.$nav(u);
				}
			},
			has_collect(arr) {
				if (arr) {
					if (this.uid && arr) {
						return arr.has(this.field, this.uid);
					}
				}
				return false;
			}
		}
	}
</script>

<style>
</style>
