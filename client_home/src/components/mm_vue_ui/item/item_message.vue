<template>
	<!-- 消息 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_message" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.avatar]" :desc="obj[vm.tip]"></mm_icon>
				<div class="num_message" :class="{'point':obj[vm.type] !== 1}" v-if="obj[vm.num_message]"><span class="text">{{obj[vm.num_message]}}</span></div>
			</div>
			<div class="doc">
				<div class="name" v-if="obj[vm.name]"><span>{{obj[vm.name]}}</span></div>
				<div class="content" v-if="obj[vm.content]"><span>{{obj[vm.content]}}</span></div>
				<div class="time" v-if="obj[vm.create_time]"><span>{{ $to_time(obj[vm.create_time]) }}</span></div>
				<div class="mute" v-if="obj[vm.mute]"><span>{{obj[vm.mute]}}</span></div>
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
