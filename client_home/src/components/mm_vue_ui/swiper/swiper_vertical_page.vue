<template>
	<!-- 轮播图 -->
	<div class="swiper_vertical_page swiper-container" :id="id">
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
		<div class="swiper-pagination">
			<span class="swiper-pagination-bullet"></span>
			<span class="swiper-pagination-bullet"></span>
			<span class="swiper-pagination-bullet"></span>
			<span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span>
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
				default: "id"
			}
		},
		data() {
			return {
				slides: []
			}
		},
		methods: {
			doing() {
				var _this=  this;
				var mySwiper = new this.$Swiper('.swiper-container', {
					direction: 'vertical',
					speed: 350,
					pagination: {
						el: '.swiper-pagination',
						clickable: true,
						dynamicBullets: true,
					},
					slidesPerView: 1,
					mousewheelControl: true,
					on: {
						slideChangeTransitionStart: function() {
							if(_this.func){
								_this.func(this.activeIndex);
							}
						},
					}
				})
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
	.swiper_vertical_page {
		height: 80vh;
	}

	.swiper_vertical_page .swiper-slide {
		width: 100%;
	}

	.swiper_vertical_page .swiper-slide:nth-child(1) {
		background-color: #fffae8;
	}

	.swiper_vertical_page .swiper-slide:nth-child(2) {
		background-color: #aaaaff;
	}

	.swiper_vertical_page .swiper-slide:nth-child(3) {
		background-color: #55557f;
	}

	.swiper_vertical_page .swiper-slide:nth-child(4) {
		background-color: #aa5500;
	}

	.swiper_vertical_page .swiper-pagination {
		position: absolute;
	}

	.swiper-pagination-bullet {
		width: 6px;
		height: 6px;
		background: royalblue;
		opacity: .4;
	}

	.swiper-pagination-bullet-active {
		opacity: 1;
	}
</style>
