<template>
	<button :type="type" class="mm_btn" v-if="!url" @click="click_down()">
		<slot></slot>
	</button><button class="mm_btn" @click="openBrowser()" v-else-if="url.indexOf('http:')===0 ||
	 url.indexOf('https:')===0">
		<slot></slot>
	</button>
	<router-link class="mm_btn" :to="url" v-else>
		<slot></slot>
	</router-link>

</template>

<script>
	export default {
		props: {
			url: {
				type: String,
				default: ""
			},
			type: {
				type: String,
				default: "button"
			},
			func: {
				type: Function,
				default: function _default() {}
			}
		},
		methods: {
			openBrowser: function openBrowser() {
				if (window) {
					window.open(this.url);
				}
			},
			click_down: function click_down() {
				if (this.func) {
					this.func();
				}
			}
		}
	};
</script>

<style>
</style>
