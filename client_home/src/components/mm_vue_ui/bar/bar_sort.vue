<template>
	<div class="bar_sort">
		<div class="list">
			<div class="item" :class="{show_drop:key === i,active:key_sub!==-1&&o.title!==obj.title}" @click="event_click(o, i)" v-for="(o,i) in list" :key="i">
				<div class="title">
					<span>{{obj[vm.title] || o[vm.title]}}</span>
					<span class="icon_title"></span>
				</div>
				<div class="group">
					<div class="sub" :class="{active:key_sub==index}" v-for="(object,index) in o[vm.sub]" :key="o.command + index"  @click="event_click_sub(object,index)"><span>{{object[vm.title]}}</span></div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			list: {
				type: Array,
				default: function() {
					return [{
						title: "综合",
						sub: [{
								title: "综合",
								command: "default",
							},
							{
								title: "信用",
								command: "credit",
							},
							{
								title: "价格降序",
								command: "price desc",
							},
							{
								title: "价格升序",
								command: "price asc",
							}
						],
						command: "default"
					}]
				}
			}
		},
		data() {
			return {
				obj: {},
				key: -1,
				key_sub: -1
			};
		},
		methods: {
			event_click(o, key) {
				if (this.key !== key) {
					this.key = key;
				} else {
					this.key = -1;
				}
				if (this.func) {
					this.func(o);
				}
			},
			event_click_sub(o, key_sub) {
				this.key_sub = key_sub;
				this.key = -1;
				this.obj = o;
				event.stopPropagation();
				if (this.func) {
					this.func(o);
				}
			}
		},
	}
</script>

<style>
</style>
