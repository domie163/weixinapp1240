<template>
	<div class="list_user" :class="cols">
		<item_user v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_user>
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
							user_id: 1,
							name: "姓名1",
							avatar: "/img/default.png",
							level:15,
							tag:11,
							state:"在线",
							description: "个性签名个性签名个性签名个性签名个性签名个性签名个性签名个性签名个性签名",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 2,
							name: "姓名2",
							avatar: "/img/default.png",
							level:85,
							tag:0,
							state:"隐身",
							description: "个性签名个性签名个性签名个性签名",
							qrcode:0,
							url: "/"
						},
						{
							user_id: 3,
							name: "姓名3",
							avatar: "/img/default.png",
							level:5,
							tag:2,
							state:"勿扰",
							description: "这是一个用户的描述",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 4,
							name: "姓名4",
							avatar: "/img/default.png",
							level:15,
							tag:8,
							state:"在线",
							description: "",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 5,
							name: "姓名5",
							avatar: "/img/default.png",
							level:15,
							tag:0,
							state:"在线",
							description: "这是一个用户的描述",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 6,
							name: "姓名6",
							avatar: "/img/default.png",
							level:15,
							tag:3,
							state:"在线",
							description: "这是一个用户的描述",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 7,
							name: "姓名8",
							avatar: "/img/default.png",
							level:15,
							tag:5,
							state:"在线",
							description: "这是一个用户的描述",
							qrcode:1,
							url: "/"
						},
						{
							user_id: 8,
							name: "姓名8",
							avatar: "/img/default.png",
							level:15,
							tag:7,
							state:"在线",
							description: "这是一个用户的描述",
							qrcode:1,
							url: "/"
						}
					]
				}
			}
		}
	}
</script>

<style>
</style>
