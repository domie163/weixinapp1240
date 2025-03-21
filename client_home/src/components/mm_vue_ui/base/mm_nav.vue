<template>
	<view class="mm_nav">
		<ul>
			<li v-for="(o, index) in list" :key="index"><a :href="o.url" v-if="o.url.indexOf('http:') === 0 || o.url.indexOf('https:') === 0">{{ o.title }}<span
					 class="message" v-show="o.message > 0">{{ o.message }}</span></a>
				<router-link :to="o.url" v-else>{{ o.title }}<span class="message" v-show="o.message > 0">{{ o.message }}</span></router-link>
			</li>
		</ul>
	</view>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function _default() {
					return [];
				}
			},
			vm: {
				type: Object,
				default: function _default() {
					return {
						icon: "icon",
						title: "title",
						desc: "desc",
						url: "url",
						name: "name",
						tip: "tip"
					};
				}
			}
		}
	};
</script>

<style>
</style>
