<template>
	<!-- 媒体 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_media" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="title" v-html="obj[vm.title]"></div>
				<div class="content" v-html="obj[vm.description]" v-if="obj[vm.description]"></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin],
		data() { return {};}
	}
</script>

<style>
</style>
