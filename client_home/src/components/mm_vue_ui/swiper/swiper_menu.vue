<template>
	<!-- 轮播图 -->
	<div class="swiper_menu">
		<div class="swiper-container" :id="id">
			<div class="swiper-wrapper">
				<div class="swiper-slide" v-for="(o, idx) in list_new" :key="idx">
					<list_base :list='o' :col="col"  style="width: 100%;"></list_base>
				</div>
			</div>
			<div class="swiper-pagination"></div>
		</div>

	</div>

</template>

<script>
	import mixin from '@/mixins/component.js';

	export default {
		mixins: [
			mixin
		],
		props: {
			autoplay: {
				type: Boolean,
				default: false
			},
			id: {
				type: String,
				default: ".swiper-container"
			},
			col: {
				type: Number,
				default: 4
			},
			row: {
				type: Number,
				default: 2
			}
		},
		methods: {
			doing() {
				var swiper = new this.$Swiper(this.id, {
					speed: 350,
					autoplay: this.autoplay,
					slidesPerView: 1,
					pagination: {
						el: '.swiper-pagination',
						clickable: true
					}
				});
			}
		},
		mounted() {
			setTimeout(() => {
				this.doing()
			}, 300)
		},
		computed: {
			list_new() {
				var size = this.row * this.col
				var list = this.list;
				var len = Math.ceil(list.length / size)
				var arr = []
				for (var i = 0; i < len; i++) {
					var start = size * i;
					var end = start + size;
					if(end > list.length){
						end = list.length + 1
					}
					var ar = list.slice(start, end)
					arr.push(ar)
				}
				return arr
			}
		}
	}
</script>

<style>
	.swiper_menu .swiper-container {
		overflow: visible;
	}

	.swiper_menu .swiper-slide {
		display: flex;
		justify-content: space-around;
	}

	.swiper_menu .swiper-pagination {
		position: relative;
	}
</style>
