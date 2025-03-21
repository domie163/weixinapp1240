<template>
  <!-- 侧边导航 -->
  <div class="nav_side">
    <!-- 一级 -->
    <div class="nav_item" v-for="(o,i) in list" :key="i">
      <a class="btn_nav" :class="css" v-if="has_sub(o)" href="javascript:void(0)" @click="open_sub(o,i)">
        <mm_icon :src="o.icon" v-if="o.icon"></mm_icon>
        <span>{{ to_lang(o.title) }}</span>
        <i class="arrow_nav" :class="{rotate:key_rotate === i,rotate_back:key_rotate !== i}"></i>
      </a>
      <a target="_blank" class="btn_nav" :class="css" v-else-if="o.command && (o.command.indexOf('.') !== -1)"
        :href="o.command" @click="$emit('change', o)">
        <mm_icon :src="o.icon" v-if="o.icon"></mm_icon>
        <span>{{ to_lang(o.title) }}</span>
      </a>
      <router-link class="btn_nav" :class="css"
        v-else-if="o.command && (o.command.indexOf('/') === 0 || o.command.indexOf('http') === 0)" :to="o.command"
        @click.native="$emit('change', o)">
        <mm_icon :src="o.icon" v-if="o.icon"></mm_icon>
        <span>{{ to_lang(o.title) }}</span>
      </router-link>
      <a class="btn_nav" :class="css" v-else href="javascript:void(0)" @click="event_click(o)">
        <mm_icon :src="o.icon" v-if="o.icon"></mm_icon>
        <span>{{ to_lang(o.title) }}</span>
      </a>

      <!-- 二级 -->
      <div class="sub_list" v-if="has_sub(o)" :style="get_height(o, i)">
        <div @click="close_sub" class="sub_item" v-for="(obj, idx) in o.sub">
          <router-link class="btn_nav"
            v-if="obj.command && (obj.command.indexOf('/') === 0 || obj.command.indexOf('http') === 0)"
            :to="obj.command" @click.native="$emit('change', obj)">
            <mm_icon :src="obj.icon" v-if="obj.icon"></mm_icon>
            <span>{{ to_lang(obj.title) }}</span>
          </router-link>
          <a class="btn_nav" v-else href="javascript:void(0)" @click="event_click(obj)">
            <mm_icon :src="obj.icon" v-if="obj.icon"></mm_icon>
            <span>{{ to_lang(obj.title) }}</span>
          </a>
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
              title: "item1",
              command: "#",
              icon: "fa-map-marker"
            },
            {
              title: "item2",
              command: "#",
              icon: "fa-th-large",
              sub: [{
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
              ]
            },
            {
              title: "item3",
              command: "#",
              icon: "fa-file-text-o",
              sub: [{
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                },
                {
                  title: "sub_item1",
                  command: "#",
                }
              ]
            },
            {
              title: "item4",
              command: "#",
              icon: "fa-cog",
            },
            {
              title: "跳转自动关闭导航",
              command: "close",
              icon: "fa-close"
            }
          ]
        }
      }
    },
    data() {
      return {
        // 控制下拉
        key_drop: -1,
        // 控制箭头旋转
        key_rotate: -1
      };
    },
    methods: {
      // 打开折叠
      open_sub(o, i) {
        var key_drop = this.key_drop
        var key_rotate = this.key_rotate
        if (o.sub && o.sub.length) {
          if (key_drop !== i) {
            key_drop = i
            key_rotate = i
          } else {
            key_drop = -1
            key_rotate = -1
          }
        }
        this.key_drop = key_drop
        this.key_rotate = key_rotate
      },
      // 关闭折叠
      close_sub() {
        this.key_drop = -1
        this.key_rotate = -1
      },
      // 获取折叠高度
      get_height(o, i) {
        if (this.key_drop === i) {
          if (this.has_sub(o)) {
            var height = 2.75 * o.sub.length;
            return 'height:' + height + 'rem;'
          }
        }
      },
      // 判断是否有子导航
      has_sub(o) {
        return o.sub && o.sub.length
      },
      event_click(o) {
        if (this.func) {
          this.func(o);
        }
      }
    },
  };
</script>

<style scoped>
</style>
