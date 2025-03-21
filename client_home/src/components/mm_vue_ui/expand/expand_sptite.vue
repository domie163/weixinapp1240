<template>
	<!-- 精灵拓展 -->
	<div class="expand_sptite" :style="style" :id="name" :class="'group_' + group">
		<slot :style_sub="style_sub">
			<img :src="src" alt="" v-if="tag === 'img' || src" :style="style_sub">
			<button v-else-if="tag === 'button'" type="button" :class="'mm_btn btn-' + type" v-html="text"
				:style="style_sub"></button>
			<input class="control_input" v-else-if="tag === 'input'" :type="type" :value="text" :style="style_sub"
				@input="$emit('input', $event.target.value)">
			<div class="block" v-else v-html="text" :style="style_sub"></div>
		</slot>
	</div>
</template>

<script>
	// 实时屏幕宽高度
	var screen = document.documentElement;

	export default {
		data() {
			return {

			}
		},
		model: {
			event: "input",
			prop: "text"
		},
		props: {
			pixel: {
				type: Number,
				default: 1
			},
			zIndex: {
				type: Number,
				default: 100
			},
			name: {
				type: String,
				default: ""
			},
			src: {
				type: String,
				default: ""
			},
			tag: {
				type: String,
				default: ""
			},
			type: {
				type: String,
				default: ""
			},
			color: {
				type: String,
				default: ""
			},
			group: {
				type: String,
				default: "default"
			},
			background: {
				type: String,
				default: ""
			},
			size: {
				type: Object,
				default: function() {
					return {
						width: "",
						height: ""
					}
				}
			},
			pos: {
				type: Object,
				default: function() {
					return {
						x: "",
						y: ""
					}
				}
			},
			text: {
				type: String,
				default: ""
			},
			align: {
				type: Object,
				default: function() {
					return {
						// x: left center right stretch(对齐方式)
						x: "",
						// y: top center bottom stretch
						y: ""
					}
				}
			}
		},
		computed: {
			style() {
				var style = `position:absolute; z-index:${this.zIndex};`;

				//  x轴
				if (this.align.x === 'left') {
					if (typeof(this.pos.x) === 'number' || /^-?[0-9]+$/.test(this.pos.x)) {
						style += `left:${this.pos.x * this.pixel}px;`;
					} else {
						style += `left:${this.pos.x};`;
					}
				} else if (this.align.x === 'right') {
					if (typeof(this.pos.x) === 'number' || /^-?[0-9]+$/.test(this.pos.x)) {
						style += `right:${this.pos.x * this.pixel}px;`;
					} else {
						style += `right:${this.pos.x};`;
					}
				} else {
					if (typeof(this.pos.x) === 'number' || /^-?[0-9]+$/.test(this.pos.x)) {
						var left = this.pos.x * this.pixel;
						if (left > 0) {
							style += `left: calc(50% + ${left}px);`;
						} else if (left < 0) {
							var l = left.toString().substring(1);
							style += `left: calc(50% - ${l}px);`;
						} else {
							style += 'left: 50%;';
						}
					} else if (this.pos.x.indexOf('-') !== -1) {
						var x = this.pos.x.toString().substring(1);
						if (/^[0-9]+$/.test(x)) {
							x += "px";
						}
						style += `left: calc(50% - ${x});`;
					} else {
						style += `left: calc(50% + ${this.pos.x});`;
					}
					if (this.align.y === 'center' || this.align.y === 'stretch') {
						style += "transform: translate(-50%, -50%);";
					} else {
						style += "transform: translateX(-50%);";
					}
				}

				//  y轴
				if (this.align.y === 'top') {
					if (typeof(this.pos.y) === 'number' || /^-?[0-9]+$/.test(this.pos.y)) {
						style += `top:${this.pos.y * this.pixel}px;`;
					} else {
						style += `top:${this.pos.y};`;
					}
				} else if (this.align.y === 'bottom') {
					if (typeof(this.pos.y) === 'number' || /^-?[0-9]+$/.test(this.pos.y)) {
						style += `bottom:${this.pos.y * this.pixel}px;`;
					} else {
						style += `bottom:${this.pos.y};`;
					}
				} else {
					if (typeof(this.pos.y) === 'number' || /^-?[0-9]+$/.test(this.pos.y)) {
						var top = this.pos.y * this.pixel;
						if (top > 0) {
							style += `top: calc(50% + ${top}px);`;
						} else if (top < 0) {
							var t = top.toString().substring(1);
							style += `top: calc(50% - ${t}px);`;
						} else {
							style += 'top: 50%;';
						}
					} else if (this.pos.y.indexOf('-') !== -1) {
						var y = this.pos.y.toString().substring(1);
						if (/^[0-9]+$/.test(y)) {
							y += "px";
						}
						style += `top: calc(50% - ${y});`;
					} else {
						style += `top: calc(50% + ${this.pos.y});`;
					}

					if (this.align.x !== 'center' && this.align.x !== 'stretch') {
						style += "transform: translateY(-50%);";
					}
				}

				// 宽
				var wh = this.size.width;
				if (wh && typeof(wh) !== 'number' && wh.indexOf('%') !== -1) {
					style += `width:${wh};`;
				} else if (this.align.x === 'stretch') {
					if (wh === '' || wh === 'auto' || wh === '100%') {
						style += `width: 100%;`;
					}
				}

				// 高
				var ht = this.size.height;
				if (ht && typeof(ht) !== 'number' && ht.indexOf('%') !== -1) {
					style += `height:${ht};`;
				} else if (this.align.y === 'stretch') {
					if (ht === '' || ht === 'auto' || ht === '100%') {
						style += `height: 100%;`;
					}
				}
				return style;
			},
			style_sub() {
				var style = "";
				// 宽度
				var wh = this.size.width;
				if (typeof(wh) === 'number') {
					style += `width:${wh * this.pixel}px;`;
				} else if (wh === '' || wh === 'auto') {
					if (this.align.x === 'stretch') {
						style += `width: 100%;`;
					}
				} else if (wh && wh.indexOf('%') !== -1) {
					style += `width: 100%;`;
				} else if (/^-?[0-9]+$/.test(wh)) {
					style += `width:${wh * this.pixel}px;`;
				} else {
					style += `width:${wh};`;
				}

				// 高度
				var ht = this.size.height;
				if (typeof(ht) === 'number') {
					style += `height:${ht * this.pixel}px;`;
				} else if (ht === '' || ht === 'auto') {
					if (this.align.y === 'stretch') {
						style += `height: 100%;`;
					}
				} else if (ht && ht.indexOf('%') !== -1) {
					style += `height: 100%;`;
				} else if (/^-?[0-9]+$/.test(ht)) {
					style += `height:${ht * this.pixel}px;`;
				} else {
					style += `height:${ht};`;
				}

				if (this.background) {
					style += `background:${this.background};`
				}
				if (this.color) {
					style += `color:${this.color};`
				}
				return style;
			}
		},
		mounted() {}
	}
</script>

<style>
</style>
