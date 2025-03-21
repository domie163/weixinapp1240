<template>
	<div class="bar_user" @click="event_click(obj)">
		<div class="media">
			<mm_icon :src="obj[vm.image]" :desc="obj[vm.image]"></mm_icon>
		</div>
		<div class="doc">
			<div class="name"><span>{{obj.name}}</span></div>
			<span class="chevron"></span>
			<span class="qrcode"></span>
			<div class="account"><span>{{obj.user_id}}</span></div>
      <slot></slot>
		</div>
	</div>
</template>

<script>
	import mixin from '@/mixins/component.js'
	export default {
		mixins: [mixin],
		props: {
			obj: {
				type: Object,
				default: function() {
					return {
						image: "/img/default.png",
						name: "Tao",
						user_id: "123456",
						url:"#",
					}
				}
			}
		},
		data() {
			return {};
		},
    methods:{
      event_click(o){
        if (this.func) {
        	this.func(o);
        }
      }
    }
	}
</script>

<style>
</style>
