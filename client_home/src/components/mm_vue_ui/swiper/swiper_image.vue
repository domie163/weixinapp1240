<template>
	<!-- 轮播图 -->
	<div class="swiper_image">
		<div class="swiper-container" :id="id" >
			<div class="swiper-wrapper">
				<div class="swiper-slide" v-for="(o, idx) in list" :key="idx">
					<slot :row="o" :index="idx"></slot>
				</div>
			</div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
			<div class="swiper-pagination"></div>
		</div>
	</div>

</template>

<script>
	import mixin from '@/mixins/component.js';

	export default {
		mixins: [mixin],
		props: {
			id: {
				type: String,
				default: "id"
			}
		},
		methods: {
			doing() {
				var swiper = new this.$Swiper('#' + this.id, {
					speed: 350,
					autoplay: {
						delay: 2800,
						disableOnInteraction: false,
						waitForTransition: false,
					},
					centeredSlides: true,
					slidesPerView: 1,
					pagination: {
						el: '.swiper-pagination',
						clickable: true,
						dynamicBullets: true,
					},
					navigation: {
						nextEl: '.swiper-button-next',
						prevEl: '.swiper-button-prev',
					},
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
	.swiper_image .swiper-slide {
		width: calc(100% - 4rem);
		padding: 1rem 0 3rem 0;
		height: 18.75rem;

	}

	.swiper_image .swiper-container {
		user-select: none;
	}

	.swiper_image .mm_icon {
		width: 100%;
		border-radius: 0.25rem;
		height: 10rem;
		margin: auto;
	}
</style>
