<template>
	<view class="mm_page">
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
