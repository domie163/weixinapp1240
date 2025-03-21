<template>
	<!-- 轮播图 -->
	<div class="swiper_text swiper-container" :id="id">
		<div class="swiper-wrapper">
			<div class="swiper-slide" >
				<slot></slot>
			</div>
			<div class="swiper-slide" >
				<slot name="card1"></slot>
			</div>
			<div class="swiper-slide" >
				<slot name="card2"></slot>
			</div>
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
					autoplay:true,
					direction: 'vertical',
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
	.swiper_text {
		width: calc(100% - 4rem);
		height: 1.5rem;
	}

	.swiper_text .mm_view {
		color: #666;
		padding: 0 1rem;
		font-size: 85%;
	}
	.swiper_text .text_block{
		display: flex;
	}
	.swiper_text .text_block h4{
		color: var(--color_red);
	}
</style>
