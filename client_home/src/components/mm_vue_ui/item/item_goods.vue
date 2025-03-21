<template>
	<!-- 商品 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_goods" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
				<span class="tag" v-if="obj[vm.tag]"><span>{{obj[vm.tag]}}</span></span>
			</div>
			<div class="doc">
				<div class="title" v-if="obj[vm.title]"><span>{{obj[vm.title]}}</span></div>
				<div class="content" v-if="obj[vm.description]"><span>{{obj[vm.description]}}</span></div>
				<div class="price" v-if="obj[vm.price]"><span>{{obj[vm.price]}}</span></div>
				<div class="price_ago" v-if="obj[vm.price_ago]"><span>{{obj[vm.price_ago]}}</span></div>
				<div class="num_comment"><span>{{obj[vm.num_comment]}}</span></div>
				<div class="collect"><span>{{obj[vm.collect]}}</span></div>
				<div class="info">
					<div class="freight" v-if="(obj[vm.freight] && obj[vm.freight] > 0)"><span class="freight_before">{{obj[vm.freight]}}</span></div>
					<div class="freight" v-else><span>免运费</span></div>
					<div class="address" v-if="obj[vm.address]">
						<span>{{obj[vm.address]}}</span>
					</div>
					<div class="hot"><span>{{obj[vm.hot]}}</span></div>
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
