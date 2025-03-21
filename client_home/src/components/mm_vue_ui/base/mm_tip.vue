<template>
  <view class="mm_tip">
    <button class="btn">
      <slot></slot>
    </button>
    <view class="box">
      <slot name="tip">{{ tip }}</slot>
    </view>
  </view>
</template>

<script>
  export default {
    props: {
      tip: {
        type: String,
        default: ""
      }
    }
  }
</script>

<style>
</style>
