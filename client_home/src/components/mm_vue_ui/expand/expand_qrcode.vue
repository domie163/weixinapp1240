<template>
  <!-- 二维码拓展 -->
  <div class="expand_qrcode" :id="id || ide">
    <slot></slot>
  </div>
</template>

<script>
  export default {
    props: {
      id: {
        type: String,
        default: ""
      },
      value: {
        type: String,
        default: ""
      },
      icon: {
        type: String,
        default: ""
      },
      url: {
        type: String,
        default: ""
      },
      width: {
        type: Number,
        default: 0
      },
      height: {
        type: Number,
        default: 0
      },
      background: {
        type: String,
        default: '#ffffff'
      },
      foreground: {
        type: String,
        default: '#000000'
      },
      iconRadius: {
        type: Number,
        default: 10
      },
      iconBorderWidth: {
        type: Number,
        default: 3
      }
    },
    data() {
      return {
        qrcode: {},
        ide: 'qrcode_' + Date.now() + Math.ceil(Math.random() * 100)
      }
    },
    methods: {
      init(value) {
        var id = '#' + (this.id || this.ide);
        $(id).html('');
        this.qrcode = new QRCode(this.id || this.ide, {
          text: value,
          width: this.width || 128,
          height: this.height || this.width || 128,
          iconSrc: this.icon,
          //二维码中心图片边框弧度
          iconRadius: this.iconRadius,
          //二维码中心图片边框宽度
          iconBorderWidth: this.iconBorderWidth,
          //二维码中心图片边框颜色
          iconBorderColor: "#fff",
          colorDark: this.foreground,
          colorLight: this.background,
          correctLevel: QRCode.CorrectLevel.H
        });
      }
    },
    watch: {
      value() {
        this.init(this.value);
      },
      url() {
        this.init(this.url);
      }
    },
    mounted() {
      var _this = this;
      this.$nextTick(function() {
        _this.init(this.value || this.url);
      });
    },
    destroyed() {
      if (this.qrcode) {
        this.qrcode.clear();
      }
      this.qrcode = null;
    }
  }
</script>

<style>
</style>
