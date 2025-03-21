<template>
	<div class="bar_search">
		<div class="box_search">
			<span class="icon_search" @click="even_click(obj.search)"></span>
			<input type="text" placeholder="搜索" :value="value" v-on:input="$emit('input', $event.target.value)">
		</div>
		<div class="cancle" @click="even_click(obj.cancle)"><span>{{ obj.cancle.title }}</span></div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		model: {
			prop: 'value',
			event: 'input'
		},
		props: {
			value: {
				type: String,
				default () {
					return ""
				}
			},
      obj: {
      	type: Object,
      	default () {
      		return {
      			search: {
      				title: "搜索",
      				command: "search"
      			},
      			cancle: {
      				title: "取消",
      				command: "cancle"
      			}
      		}
      	}
      }
		},
		data() {
			return {};
		},
		methods: {
			even_click(o) {
				if (this.func) {
					this.func(o);
				}
			}
		}
	}
</script>

<style>

</style>
