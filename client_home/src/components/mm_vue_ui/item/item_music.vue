<template>
	<!-- 音乐 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_music" :class="css">
			<div class="media" v-if="display == 2">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="collect"><span>{{obj[vm.collect]}}</span></div>
				<div class="name" v-if="obj[vm.name]"><span>{{obj[vm.name]}}</span></div>
				<div class="label" v-if="obj[vm.label]"><span>{{obj[vm.label]}}</span></div>
				<div class="tag" v-if="obj[vm.tag]"><span>{{obj[vm.tag]}}</span></div>
				<div class="time" v-if="obj[vm.time]"><span>{{obj[vm.time]}}</span></div>
				<div class="author" v-if="obj[vm.author]"><span>{{obj[vm.author]}}</span></div>
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
