<template>
  <!-- 操作栏 -->
  <div class="bar_action">
    <div class="btn_action" v-for="(o,i) in list" :key="i" @click="event_click(o)">{{o.title}}</div>
    <div class="btn_close" @click="event_click(obj_cancel)">{{obj_cancel.title}}</div>
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
              title: "拍照",
              command: "take_picture"
            },
            {
              title: "选取",
              command: "select"
            }
          ]
        },
      },
      obj_cancel: {
        type: Object,
        default () {
          return {
            title: "取消",
            command: "cancel"
          }
        }
      }
    },
    data() {
      return {};
    },
    methods: {
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
