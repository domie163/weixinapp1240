<template>
	<view :class="'mm_col' + this.wh">
		<slot></slot>
	</view>
</template>

<script>
	export default {

		props: {
			width: {
				type: String,
				default: ""
			}
		},
		data: function data() {
			return {
				wh: this.width
			};
		},
		created: function created() {
			var wh = this.wh;
			if (wh) {
				if (wh.indexOf("-") == -1) {
					this.wh = " w-" + wh;
				}
			}
		}
	};
</script>

<style>
</style>
