<template>
	<div class="control_textarea" :class="{ 'show-expand': sw }">
		<div class="title" v-if="title" v-html="title"></div>
		<div class="value" v-bind:class="{'disabled': disabled }"><textarea :value="value" @blur="set" :disabled="disabled"
			 :placeholder="desc || placeholder" v-if="type == 'text'"></textarea><button class="btn_expand" type="button" v-show="$slots.default"
			 @click="sw = !sw"><i class="fa-expand"></i></button></div>
		<div class="tip" v-if="tip">{{ tip }}</div>
		<slot></slot>
	</div>
</template>

<script>
	import mixin from "@/mixins/control.js";

	export default {
		mixins: [mixin],
		props: {
			placeholder: {
				type: String
			}
		},
		methods: {
			set: function set(e) {
				this.$emit("input", e.target.value);
			}
		}
	};
</script>

<style>
</style>
