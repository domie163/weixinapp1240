<template>
	<!-- 轮播图 -->
	<div class="swiper_page swiper-container" :id="id">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<slot></slot>
			</div>
			<div class="swiper-slide">
				<slot name="page1"></slot>
			</div>
			<div class="swiper-slide">
				<slot name="page2"></slot>
			</div>
			<div class="swiper-slide">
				<slot name="page3"></slot>
			</div>
		</div>
		<div class="swiper-pagination"></div>
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
				default: "id"
			}
		},
		methods: {
			doing() {
				var swiper = new this.$Swiper('#' + this.id, {
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
		}
	}
</script>

<style>
	.swiper_page {
		height: 80vh;
	}

	.swiper_page .swiper-slide {
		width: calc(100% - 4rem);
	}

	.swiper_page .mm_icon {
		width: 100%;
		border-radius: 0.25rem;
		height: 10rem;
		margin: auto;
	}
</style>
