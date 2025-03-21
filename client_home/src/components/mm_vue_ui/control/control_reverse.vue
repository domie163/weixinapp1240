<template>
	<div class="control_reverse">
		<div class="title" v-if="title" v-html="title" @click="set"></div>
		<div class="value" v-bind:class="{'disabled': disabled }">
			<slot>
				<div class="figure" v-bind:class="{ 'reverse_arrow' : display !== '1' }" @click="set"><span class="up"
					 v-bind:class="{'active': selected === 0 }"></span><span class="down" v-bind:class="{'active': selected === 1 }"></span></div>
			</slot>
		</div>
		<div class="tip" v-if="tip">{{ tip }}</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/control.js";
	export default {
		mixins: [mixin],
		methods: {
			set: function set() {
				var n = this.selected;
				n += 1;
				var lt = this.ops;
				var v = "";

				if (n < lt.length) {
					v = lt[n];
				} else if (n > lt.length) {
					n = 0;
					v = lt[0];
				}

				var val = this.value;
				var has = false;

				for (var i = 0; i < lt.length; i++) {
					var o = lt[i];

					if (val.indexOf(o) !== -1) {
						val = val.replace(o, v);
						has = true;
						val = val.replace(",,", ",");
						break;
					}
				}

				if (!has) {
					val += "," + v;
				}

				if (val.indexOf(",") === 0) {
					val = val.substring(1);
				}

				this.$emit("input", val.trim(','));

				if (this.func) {
					this.func(val);
				}
			}
		},
		computed: {
			ops: function ops() {
				var o = this.options;
				if (o) {
					if (typeof(o) === 'string') {
						return ["`" + o + "` asc", "`" + o + "` desc"]
					} else if (typeof(o) === 'object' && o.length > 1) {
						return o;
					} else if (this.field) {
						var f = this.field;
						return ["`" + f + "` asc", "`" + f + "` desc"]
					}
				}
				return ["asc", "desc"]
			},
			selected: function selected() {
				if (this.ops) {
					var lt = this.ops;
					var val = this.value;
					var selected = 2;

					for (var i = 0; i < lt.length; i++) {
						var o = lt[i];

						if (val.indexOf(o) !== -1) {
							selected = i;
							break;
						}
					}

					return selected;
				} else {
					return 0;
				}
			}
		}
	};
</script>

<style>
</style>
