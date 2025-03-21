<template>
	<!-- 新闻 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_news" :class="css">
			<div class="media" v-if="!obj[vm.imgs] || !(obj[vm.imgs].length>1)">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="title" v-if="obj[vm.title]"><span>{{obj[vm.title]}}</span></div>
				<div class="content" v-if="obj[vm.description]"><span>{{obj[vm.description]}}</span></div>
				<div class="imgs" v-if="obj[vm.imgs] && obj[vm.imgs].length>1">
					<div v-for="(o,i) in obj[vm.imgs]" :key="i">
						<img class="img" :src="o" alt="">
					</div>
				</div>
				<div class="info">
					<div class="source" v-if="obj[vm.source]"><span>{{obj[vm.source]}}</span></div>
					<div class="author" v-if="obj[vm.author]"><span>{{obj[vm.author]}}</span></div>
					<div class="tag" v-if="obj[vm.tag]"><span>{{obj[vm.tag]}}</span></div>
					<div class="time" v-if="obj[vm.create_time]"><span>{{ $to_time(obj[vm.create_time]) }}</span></div>
				</div>
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
