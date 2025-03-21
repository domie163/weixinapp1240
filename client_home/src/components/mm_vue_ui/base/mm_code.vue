<template>
	<view class="mm_code">
		<mm_icon :icon="icon"></mm_icon>
		<view class="title" v-if="title">{{ title }}</view>
		<slot>
			<mm_group><input type="text" :value="value" :placeholder="desc || placeholder" @input="$emit('input', $event.target.value)"></input><button
				 :class="'btn-' + type" v-html="btn"></button></mm_group>
		</slot>
		<view class="tip" v-if="tip" v-html="tip"></view>
	</view>
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
		props: {
			btn: {
				type: String,
				default: "发送验证码"
			}
		},
		computed: {
			ds: function ds() {
				if (this.btn.indexOf("s") == -1) {
					return false;
				} else {
					return true;
				}
			}
		}
	};
</script>

<style>
</style>
