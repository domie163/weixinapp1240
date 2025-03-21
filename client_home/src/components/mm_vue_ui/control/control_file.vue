<template>
	<div class="control_file">
		<label>
			<input :type="file" :accept="accept" hidden="hidden" @change="$emit('change', event)">
			<slot></slot>
		</label>
	</div>
</template>

<script>
	export default {
		props: {
			accept: {
				type: String,
				default: ".xls,.xlsx,.csv"
			},
			type: {
				type: "String",
				default: "file"
			}
		}
	}
</script>

<style>
</style>
