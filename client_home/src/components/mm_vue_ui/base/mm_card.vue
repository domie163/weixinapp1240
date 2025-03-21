<template>
	<view class="mm_card">
		<slot></slot>
	</view>
</template>

<script>
	export default {
		props: {
			fun: {
				type: Function,
				default: function _default() {}
			}
		}
	};
</script>

<style>
</style>
