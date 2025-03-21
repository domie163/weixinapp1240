<template>
  <div class="nav_main">
    <div class="list">
      <div class="item" :class="{active: key_drop === i}" v-for="(o,i) in list" :key="i" @click="show_items(i)">
        <a class="title" :href="o.url"><span>{{o[vm.title]}}</span></a>
        <mm_icon :src="o.icon"></mm_icon>
        <div class="dropdown" v-if="o.sub">
          <div class="sub" v-for="(obj,idx) in o[vm.sub]" :key="idx">
            <a :href="obj.url">
              <div class="item_sub">
                <i v-if="obj.icon" :class="'icon ' + obj.icon"></i>
                <span>{{obj[vm.title]}}</span>
              </div>
            </a>
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
        default: function() {
          return [{
              title: "首页",
              url: ""
            },
            {
              title: "选我！",
              url: ""
            },
            {
              title: "搜索",
              url: ""
            },
            {
              title: "图标",
              sub: [{
                title: "网页",
                icon: "fa-camera-retro",
                url: ""
              }, {
                title: "手势",
                icon: "fa-handshake-o",
                url: ""
              }, {
                title: "辅助功能",
                icon: "fa-universal-access",
                url: ""
              }, {
                title: "运输",
                icon: "fa-ship",
                url: ""
              }, {
                title: "性别",
                icon: "fa-venus-mars",
                url: ""
              }, {
                title: "文件类型",
                url: ""
              }, {
                title: "可旋转",
                url: ""
              }, {
                title: "表单",
                url: ""
              }, {
                title: "支付",
                url: ""
              }, {
                title: "图表",
                url: ""
              }, {
                title: "货币",
                url: ""
              }, {
                title: "文本编辑",
                url: ""
              }, ],
              icon: "fa-caret-down",
            },
            {
              title: "起步",
              url: ""
            },
            {
              title: "示例",
              sub: [{
                title: "基本图标",
                url: ""
              }, {
                title: "大图标",
                url: ""
              }, {
                title: "固定宽度",
                url: ""
              }, {
                title: "用于列表",
                url: ""
              }, {
                title: "边框与对齐",
                url: ""
              }, {
                title: "动画",
                url: ""
              }, {
                title: "旋转与翻转",
                url: ""
              }, {
                title: "组合使用",
                url: ""
              }, {
                title: "Bootstrap3示例",
                url: ""
              }, {
                title: "自定义CSS",
                url: ""
              }, ],
              icon: "fa-caret-down",
            },
            {
              title: "交流",
              url: ""
            },
            {
              title: "许可协议",
              url: ""
            },
          ]
        }
      },
    },
    data() {
      return {
        key_drop: -1,
      };
    },
    methods: {
      show_items(i) {
        var key_drop = this.key_drop
        if (key_drop !== i) {
          key_drop = i
        } else {
          key_drop = -1
        }
        this.key_drop = key_drop
      }
    }
  }
</script>

<style>
</style>
