<template>
	<!-- 用户 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_user" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.avatar]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="name" v-if="obj[vm.name]"><span>{{obj[vm.name]}}</span></div>
				<div class="qrcode" v-if="obj[vm.qrcode]"></div>
				<div class="info">
					<span class="level" v-if="obj[vm.level]"><span>{{obj[vm.level]}}</span></span>
					<span class="state" v-if="obj[vm.state]"><span>{{obj[vm.state]}}</span></span>
					<span class="tag" v-if="(obj[vm.tag] && obj[vm.tag] > 0)"><span>{{obj[vm.tag]}}</span></span>
				</div>
				<div class="content" v-if="obj[vm.description]"><span>{{obj[vm.description]}}</span></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
	import mixin from '@/mixins/item.js'

	export default {
		mixins: [mixin],
		data() {
			return {};
		}
	}
</script>

<style>
</style>
