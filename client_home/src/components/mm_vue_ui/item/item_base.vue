<template>
	<!-- 基础 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_base" :class="css">
			<div class="media" v-if="icon_key">
				<mm_icon class="img" :src="obj[vm[icon_key]]" :src_default="src_default"></mm_icon>
			</div>
			<div class="doc">
				<div class="title" v-html="obj[vm.title]"></div>
				<div class="content" v-html="obj[vm.content]" v-if="obj[vm.content]"></div>
			</div>
			<slot></slot>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin],
		props: {
			icon_key: {
				type: String,
				default: ""
			}
		},
		data() {
			return {};
		}
	}
</script>

<style>
</style>
