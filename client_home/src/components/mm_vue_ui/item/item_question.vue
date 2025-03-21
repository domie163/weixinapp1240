<template>
	<!-- 常见问题 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_question" :class="css">
			<div class="doc">
				<div class="time" v-if="obj[vm.time]"><span>{{$to_time(obj[vm.time])}}</span></div>
				<div class="title" v-if="obj[vm.title]"><span>{{obj[vm.title]}}</span></div>
				<div class="content" v-if="obj[vm.description]"><span>{{obj[vm.description]}}</span></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin]
	}
</script>

<style>
</style>
