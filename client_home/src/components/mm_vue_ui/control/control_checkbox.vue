<template>
	<div class="control_checkbox">
		<div class="title" v-if="title" v-html="title"></div>
		<div class="value" v-bind:class="{'disabled': disabled }"><label v-for="(o, idx) in options" :key="idx" :class="{ 'active': has(o[field]), 'disabled': o.disabled }"
			 @click="selected(o[field])"><span class="figure"></span><span class="name">{{ o.name }}</span></label></div>
		<div class="tip" v-if="tip">{{ tip }}</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/control.js";
	export default {
		mixins: [mixin],
		props: {
			symbol: {
				type: String,
				default: ","
			}
		},
		methods: {
			selected: function selected(val) {
				var arr = this.value.split(this.symbol);
				var idx = arr.indexOf(val);

				if (idx !== -1) {
					arr.splice(idx, 1);
				} else {
					arr.push(val);
				}

				var val = arr.join(this.symbol);

				if (val.indexOf(this.symbol) === 0) {
					val = val.substring(1);
				}

				this.$emit("input", val);
			},
			has: function has(val) {
				var arr = this.value.split(this.symbol);
				return arr.indexOf(val) !== -1;
			}
		}
	};
</script>

<style>
</style>
