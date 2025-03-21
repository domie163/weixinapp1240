<template>
	<!-- 用户 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_contact" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.avatar]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="name" v-if="obj[vm.name]"><span>{{obj[vm.name]}}</span></div>
				<div class="phone" v-if="obj[vm.phone]"><span>{{obj[vm.phone]}}</span></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin],
		data() {
			return {
				edit: false
			};
		}
	}
</script>

<style>
</style>
