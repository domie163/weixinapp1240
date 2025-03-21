<template>
	<view class="mm_side" :class="{'hide-x': hide, fold: fold}" :id="side_id">
		<slot></slot>
		<view class="line"></view>
		<view class="mask" @click="set_hide()"></view>
	</view>
</template>

<script>
	function bindResize(tag, target, func) {
		var width_init = $(target).width();
		var el = $(tag);
		var x = 0;
		var y = 0;
		el.mousedown(function(e) {
			x = e.clientX - el.offset().left;
			el.setCapture ? (el.setCapture(), el.onmousemove = function(ev) {
				mouseMove(ev || event);
			}, el.onmouseup = mouseUp) : $(document).bind("mousemove", mouseMove).bind("mouseup", mouseUp);
			e.preventDefault();
		});
	
		function mouseMove(e) {
			var width = e.clientX - x;
	
			if (width >= width_init) {
				$(target).width(width + "px");
	
				if (func) {
					func(width);
				}
			}
		}
	
		function mouseUp() {
			el.releaseCapture ? (el.releaseCapture(), el.onmousemove = el.onmouseup = null) : $(document).unbind(
				"mousemove",
				mouseMove).unbind("mouseup", mouseUp);
		}
	}
	
	export default {
		model: {
			prop: "hide",
			event: "change"
		},
		props: {
			id: {
				type: String,
				default: ""
			},
			hide: {
				type: Boolean,
				default: false
			},
			fold: {
				type: Boolean,
				default: false
			},
			func: {
				type: Function,
				default: function _default(width) {}
			}
		},
		data: function data() {
			var id = this.id;

			if (!id) {
				id = "mm_side" + parseInt(Math.random() * 1000 + 1, 10);
			}

			return {
				side_id: id
			};
		},
		methods: {
			set_hide: function set_hide() {
				this.$emit('change', true);
			}
		},
		mounted: function mounted() {
			var target = "#" + this.side_id;
			bindResize(target + " .line", target, this.func);
		}
	};
</script>

<style>
</style>
