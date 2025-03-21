<template>
	<!-- 号码 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_number" :class="css">
			<div class="doc">
				<span class="phone" v-if="obj[vm.phone]"><span>{{obj[vm.phone]}}</span></span>
				<span class="type" v-if="obj[vm.type]"><span>{{obj[vm.type]}}</span></span>
				<div class="content">
					<span class="date" v-if="obj[vm.date]"><span>{{obj[vm.date]}}</span></span>
					<span class="time" v-if="obj[vm.time]"><span>{{obj[vm.time]}}</span></span>
					<span class="address" v-if="obj[vm.address]"><span>{{obj[vm.address]}}</span></span>
					<span class="business" v-if="obj[vm.business]"><span>{{obj[vm.business]}}</span></span>
				</div>
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
