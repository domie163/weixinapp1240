<template>
	<div class="control_upload_img" v-bind:class="{ 'upload_add': !bg && !value }">\t<div @click="choose()">
			<mm_icon :src="value" :style="'width:' + width + other"></mm_icon>\t<slot></slot>\t<input type="file" hidden @change="addImg"
			 :id="name" accept="image/*" />
		</div>
		<div class="btns">
			<mm_btn class='btn_default-x btn_link' v-if="value" @click.native="preview = true">预览</mm_btn>
			<mm_btn class='btn_warning-x btn_link' v-if="value" @click.native="$emit('input','')">删除</mm_btn>
		</div>
		<mm_modal v-model="preview" mask="true">
			<div><img :src="value" style="max-width:100%" :alt="name" /></div>
			<mm_btn class="btn_close" @click.native="preview = false"><i class="fa-close"></i></mm_btn>
		</mm_modal>
	</div>
</template>

<script>
	export default {
		model: {
			prop: 'value',
			event: 'input'
		},
		props: {
			name: {
				type: String,
				required: true
			},
			value: {
				type: String,
				default: ''
			},
			// 显示方式
			display: {
				type: String,
				default: '1'
			},
			// 显示隐藏
			show: {
				type: Boolean,
				default: false
			},
			func: {
				type: Function,
				default: function _default(obj) {}
			},
			width: {
				type: String,
				default: '5rem'
			},
			height: {
				type: String,
				default: ''
			},
			bg: {
				type: String,
				default: ''
			}
		},
		data: function data() {
			var other = this.bg ? '; background: url(' + this.bg + ') center center no-repeat; background-size:100%' : '';

			if (this.height) {
				other += ';height:' + this.height;
			}

			return {
				other: other,
				preview: false
			};
		},
		methods: {
			choose: function choose() {
				this.$('.control_upload_img #' + this.name).click();
			},
			addImg: function addImg(e) {
				var _this = this;

				var src,
					url = window.URL || window.webkitURL || window.mozURL,
					files = e.target.files;

				if (files.length > 0) {
					var file = files[0];
					var reader = new FileReader();
					reader.readAsDataURL(file);

					reader.onload = function(e) {
						src = this.result;

						_this.$emit('input', src);

						if (_this.func) {
							_this.func(src, file);
						}
					};
				}
			}
		}
	};
</script>

<style>
</style>
