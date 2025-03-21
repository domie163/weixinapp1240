<template>
	<!-- 收获地址列表 -->
	<mm_item :url="obj[vm.url]">
		<div class="item_address" :class="css">
			<div class="media">
				<mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
			</div>
			<div class="doc">
				<div class="title" v-html="obj[vm.title]"></div>
				<div class="content" v-html="obj[vm.description]" v-if="obj[vm.description]"></div>
			</div>
		</div>
	</mm_item>
</template>

<script>
</script>

<style>
</style>
