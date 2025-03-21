<template>
  <view class="mm_modal" v-bind:class="'from_' + display + (show ? '' : ' hide-x' )">
    <view class="modal_main">
      <slot></slot>
    </view>
    <view class="mask" v-if="mask && mask !='false' " @click="close()"></view>
  </view>
</template>

<script>
  export default {
    props: {
      display: {
        type: String,
        default: "default"
      },
      show: {
        type: Boolean,
        default: false
      },
      mask: {
        type: String,
        default: ""
      }
    },
    model: {
      prop: "show",
      event: "change"
    },
    methods: {
      close: function close() {
        this.$emit("change", false);
      }
    }
  };
</script>

<style>
</style>
