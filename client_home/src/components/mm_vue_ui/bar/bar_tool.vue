<template>
  <div class="bar_tool">
    <div class="list">
      <div class="item" v-for="(o, i) in list" :key="i">
        <div class="dropdown" :class="{show:index===i}">
          <!-- 一级 -->
          <div class="btn_first" @click="click_first(o,i)">
            <i :class="o[vm.icon]"></i>
            <span class="title">{{ o[vm.title] }}</span>
          </div>
          <!-- 二级 -->
          <div class="box" v-if="o[vm.sub] && o[vm.sub].length">
            <div class="dropdown_menu">
              <div class="btn_dropdown_item" v-for="(obj, idx) in o.sub" :key="idx" @click="click_second(obj, idx)">
                <i :class="obj[vm.icon]"></i>
                <span>{{ obj[vm.title] }}</span>
              </div>
            </div>
          </div>
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
        default () {
          return [{
              title: "百日誓师",
              command: "#",
              icon:"fa-bars",
              sub: [{
                  title: "高考真题",
                  command: "#",
                  icon:"fa-book"
                },
                {
                  title: "模拟试题",
                  command: "#",
                },
                {
                  title: "最新讲座",
                  command: "#",
                },
              ],
            },
            {
              title: "四六级",
              command: "#",
              icon:"fa-bars",
              sub: [{
                  title: "四六级真题",
                  command: "#",
                  icon:"fa-book"
                },
                {
                  title: "四六级真题",
                  command: "#",
                },
              ],
            },
            {
              title: "首页",
              command: "#",
            },
          ];
        },
      },
    },
    data() {
      return {
        index: -1
      }
    },
    methods: {
      // 点击一级
      click_first(o, i) {
        this.show_dropdown(i)
        this.event_click(o)
      },
      // 点击二级
      click_second(o, i) {
        this.close_dropdown()
        this.event_click(o)
      },
      // 展示下拉框
      show_dropdown(i) {
        let index = this.index
        if (index === i) {
          this.index = -1
        } else {
          this.index = i
        }
      },
      // 关闭下拉框
      close_dropdown(){
        this.index = -1
      },
      // 发射
      event_click(o) {
        if (this.func) {
          this.func(o);
        }
      }
    }
  };
</script>

<style scoped>

</style>
