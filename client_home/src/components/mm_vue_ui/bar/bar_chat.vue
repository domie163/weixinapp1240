<template>
	<div class="bar_chat">
		<div class="btn_keyboard" @click="even_click(obj.keyboard)"><span class="icon_keyboard"></span></div>
		<div class="btn_voice" @click="even_click(obj.voice)"><span class="icon_voice"></span></div>
		<div class="input_box">
			<input type="text" :value="value" v-on:input="$emit('input', $event.target.value)">
			<span class="icon_smile" @click="even_click(obj.smile)"></span>
		</div>

		<div class="btn_more" @click="even_click(obj.more)"><span class="icon_more"></span></div>
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
						keyboard: {
							title: "键盘",
							command: "keyboard"
						},
						voice: {
							title: "语音",
							command: "voice"
						},
						smile: {
							title: "表情",
							command: "smile"
						},
						more: {
							title: "更多",
							command: "more"

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
