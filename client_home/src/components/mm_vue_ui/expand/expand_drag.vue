<template>
	<!-- 推拽拓展 -->
	<div class="expand_drag" :id="id" :style="'left: ' + pos.x + 'px; top: ' + pos.y + 'px;'" draggable="true"
		@dragstart="dragstart" @dragend="dragend">
		<div class="drag_box" @drop="drop" @dragover.prevent>
			<slot></slot>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			id: {
				type: String
			},
			pos: {
				type: Object,
				default: function() {
					return {
						x: 0,
						y: 0
					}
				}
			},
			func: {
				type: Function,
				default: function(method, tag, taget) {
					console.log(method, tag, taget);
				}
			}
		},
		data() {
			return {}
		},
		methods: {
			/**
			 * 推拽开始
			 * @param {Object} e
			 */
			dragstart(e) {
				e.dataTransfer.setData("text", e.target.id);
				console.log('拖拽开始', e);
				if (this.func) {
					this.func("dragstart", this.id, e);
				}
			},
			/**
			 * 下拉经过
			 * @param {Object} e
			 */
			dragover(e) {
				e.preventDefault();
			},
			/**
			 * 拖拽结束
			 * @param {Object} e
			 */
			drop(e) {
				e.preventDefault();
				var data = e.dataTransfer.getData("text");
				var tag = document.getElementById(data);
				tag.style.top = 0;
				tag.style.left = 0;
				e.target.appendChild(tag);
				if (this.func) {
					this.func("drop", e, tag);
				}
				console.log('拖拽经过', this.id, e);
			},
			/**
			 * 拖拽结束
			 * @param {Object} e
			 */
			dragend(e) {
				this.pos.x = e.x;
				this.pos.y = e.y;
				if (this.func) {
					this.func("dragend", e);
				}
				console.log('拖拽结束', this.id, e);
			}
		}
	}
</script>

<style>
</style>
