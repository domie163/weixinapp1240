<template>
	<view :class="'mm_table table-' + type">
		<table>
			<slot></slot>
		</table>
	</view>
</template>

<script>
	export default {
		props: {
			type: {
				type: String,
				default: "1"
			}
		}
	};
</script>

<style>
</style>
