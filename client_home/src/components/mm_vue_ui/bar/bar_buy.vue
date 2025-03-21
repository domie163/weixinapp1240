<template>
	<div class="bar_buy">
		<div class="btn" v-for="(o,i) in list" @click="event_click(o)">
			<i v-if="o.icon" :class="'icon ' + o.icon"></i>
			<span>{{o[vm.title]}}</span>
		</div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			list: {
				type: Array,
				default () {
					return [{
						title: "商铺",
						command: "store",
						icon:"fa-home"
					}, {
						title: "客服",
						command: "customer_service",
						icon:"fa-comments-o"
					}, {
						title: "收藏",
						command: "collect",
						icon:"fa-star"
					},{
						title: "加入购物车",
						command: "cart"
					},{
						title: "立即购买",
						command: "buy"
					}]
				}
				}
		},
		methods: {
			event_click(o) {
				if (this.func) {
					this.func(o);
				}
			},
		}
	}
</script>

<style>
</style>
