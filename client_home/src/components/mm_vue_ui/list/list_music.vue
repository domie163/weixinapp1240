<template>
	<div class="list_music" :class="cols">
		<item_music v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_music>
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
							image_id: 1,
							name:"这是第1首歌",
							label:"SQ",
							tag:"VIP",
							author: "张三",
							time:"3:40",
							url: "/"
						},
						{
							image_id: 2,
							icon: 0,
							name:"这是第2首歌",
							label:"SQ",
							tag:"",
							author: "张三",
							time:"5:40",
							url: "/"
						},
						{
							image_id: 3,
							icon: 1,
							name:"这是第3首歌",
							label:"",
							tag:"VIP",
							author: "张三",
							time:"3:03",
							url: "/"
						},
						{
							image_id: 4,
							icon: 0,
							name:"这是第4首歌",
							label:"",
							tag:"",
							author: "张三",
							time:"3:43",
							url: "/"
						},
						{
							image_id: 5,
							icon: 0,
							name:"这是第5首歌",
							label:"SQ",
							tag:"VIP",
							author: "张三",
							time:"4:03",
							url: "/"
						},
						{
							image_id: 6,
							icon: 0,
							name:"这是第6首歌",
							label:"SQ",
							tag:"",
							author: "张三",
							time:"2:03",
							url: "/"
						},
						{
							image_id: 7,
							icon: 1,
							name:"这是第7首歌",
							label:"SQ",
							tag:"VIP",
							author: "张三",
							time:"3:03",
							url: "/"
						},
						{
							image_id: 8,
							icon: 0,
							name:"这是第8首歌",
							label:"SQ",
							tag:"VIP",
							author: "张三",
							time:"3:03",
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
