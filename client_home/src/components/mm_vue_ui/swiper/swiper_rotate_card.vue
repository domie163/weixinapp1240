<template>
	<!-- 轮播图 -->
	<div class="swiper_rotate_card swiper-container" :id="id">
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
		data() {
			return {
				// slides: [1,2,3,4,5,6]
			}
		},
		methods: {
			doing() {
				var swiper = new this.$Swiper('#' + this.id, {
					speed: 350,
					watchSlidesProgress: true, //查看slide的progress
					resistanceRatio: 0, //禁止边缘移动
					on: {
						init: function() {
							var slides = this.slides
							for (var i = 0; i < slides.length; i++) {
								var slide = slides.eq(i)
								slide.css('zIndex', 100 - i); //设置slide的z-index层级
							}
						},

						resize: function(swiper) {
							this.update()
						},

						setTranslate: function() {
							var slides = this.slides
							var offsetAfter = this.width * 0.95 //每个slide的位移值
							for (var i = 0; i < slides.length; i++) {
								var slide = slides.eq(i)
								var progress = slides[i].progress
								if (progress <= 0) { //右边slide位移
									slide.transform('translate3d(' + (progress) * offsetAfter +
										'px, 0, 0) scale(' + (1 -
											Math.abs(progress) / 20) + ')');
									slide.css('opacity', (progress + 3)); //最右边slide透明
								}

								if (progress > 0) {
									slide.transform('rotate(' + (-progress) * 5 + 'deg)'); //左边slide旋转
									slide.css('opacity', 1 - progress); //左边slide透明
								}
							}
						},
						setTransition: function(swiper, transition) {
							for (var i = 0; i < this.slides.length; i++) {
								var slide = this.slides.eq(i)
								slide.transition(transition);
							}
						},
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
	.swiper_rotate_card .swiper-slide div {
		width: 86%;
		border-radius: 7px;
		margin: 10px 0 10px 4%;
	}
</style>
