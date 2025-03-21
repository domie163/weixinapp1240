<template>
	<div class="control_input">
		<div class="title" v-if="title" v-html="title"></div>
		<div class="value" v-bind:class="{'disabled': disabled }"><input v-bind:class="{'auto-width': auto }" :type="type"
			 :value="value" :min="min" :max="max" :minlength="min_length" :maxlength="max_length" :placeholder="desc
			 || placeholder" @input="set" :disabled="disabled" :required="required" @blur="$emit('blur')" :style="style" />
			<slot><span class="unit" v-if="unit">{{ unit }}</span></slot>
		</div>
		<div class="tip" v-if="tip">{{ tip }}</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/control.js";
	export default {
		mixins: [mixin],
		props: {
			placeholder: {
				type: String
			},
			required: {
				type: Boolean,
				default: false
			},
			auto: {
				type: Boolean,
				default: false
			},
			size: {
				type: Number,
				default: 0.625
			}
		},
		methods: {
			set: function set(e) {
				if (this.type === "number") {
					var value = e.target.value ? e.target.value : "0";

					if (value.length > this.max_length && this.max_length !== 0) {
						value = value.substring(0, this.max_length);
					}

					var num = Number(value);

					if (num > this.max && this.max !== 0) {
						num = this.max;
					} else if (num < this.min) {
						num = this.min;
					}

					e.target.value = num.toString();
					this.$emit("input", num);
				} else {
					this.$emit("input", e.target.value);
				}
			}
		},
		computed: {
			style: function() {
				if (this.auto && this.value) {
					var len = this.value.length;
					return "width:" + ((len + 1) * this.size) + "rem";
				} else {
					return '';
				}
			}
		}
	};
</script>

<style>
</style>
