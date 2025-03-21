<template>
	<div class="list_number" :class="cols">
		<item_number v-for="(o, i) in list" :key="i" :viewmodel="vm" :obj="o" :css="css"
			:class="(select === i ? ' active' : '')" @click.native="selected(i, o)">
			<slot></slot>
		</item_number>
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
							id: 1,
							phone: "189-2292-8865",
							type:"快递外卖",
							address:'广东广州',
							date:'4月21日',
							time:"呼入14秒",
							business:"联通",
							url: "/"
						},
						{
							id: 2,
							phone: "小吃",
							type:"诈骗",
							address:'广东广州',
							date:'4月20日',
							time:"呼出1分21秒",
							business:"移动",
							url: "/"
						},
						{
							id: 3,
							phone: "31111111111",
							type:"广告推销",
							address:'广东广州',
							date:'4月19日',
							time:"呼入7秒",
							business:"电信",
							url: "/"
						},
						{
							id: 4,
							phone: "同学",
							type:"",
							address:'广东广州',
							date:'3月30日',
							time:"呼入13分5秒",
							business:"电信",
							url: "/"
						},
						{
							id: 5,
							phone: "携程",
							type:"",
							address:'广东广州',
							date:'1月1日',
							time:"呼入7秒",
							business:"联通",
							url: "/"
						},	
						{
							id: 6,
							phone: "66666666666",
							type:"诈骗",
							address:'广东广州',
							date:'4月21日',
							time:"呼入7秒",
							business:"移动",
							url: "/"
						},
						{
							id: 7,
							phone: "11111111111",
							type:"",
							address:'广东广州',
							date:'4月21日',
							time:"呼入7秒",
							url: "/"
						},
						{
							id: 8,
							phone: "802316516",
							type:"诈骗",
							address:'广东广州',
							date:'4月21日',
							time:"呼入7秒",
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
