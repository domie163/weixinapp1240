<template>
	<!-- 轮播图 -->
	<div class="swiper_card swiper-container" :id="id">
		<div class="swiper-wrapper">
			<div class="swiper-slide" v-for="(o, idx) in list" :key="idx">
				<div class="card">
					<slot :row="o" :index="idx"></slot>
				</div>
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
			id: {
				type: String,
				default: "id"
			}
		},
		methods: {
			doing() {
				var swiper = new this.$Swiper("#" + this.id, {
					speed: 350,
					autoplay: {
						delay: 2800,
						disableOnInteraction: false,
						waitForTransition: false,
					},
					centeredSlides: true,
					slidesPerView: 1.2,
					spaceBetween: 16,
					pagination: {
						el: '.swiper-pagination',
						clickable: true,
						dynamicBullets: true,
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
	.swiper_card .swiper-slide {
		width: calc(100% - 4rem);
		padding: 1rem 0 3rem 0;
		height: 15rem;
	}

	.swiper_card .mm_icon {
		width: 100%;
		border-radius: 0.25rem;
		height: 10rem;
		margin: auto;
	}

	.swiper_card .card {
		height: 100%;
	}
</style>
