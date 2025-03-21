<template>
  <div class="control_radio">
    <div class="title" v-if="title" v-html="title"></div>
    <div class="value" v-bind:class="{'disabled': disabled }">
      <label v-for="(o, idx) in options" :key="idx" :class="{ 'active': value == o[field] }"
        @click="$emit('input', $event.target.value)">
        <input type="radio" :name="name" :value="o[field]" />
        <slot :row="o"><span class="figure"></span><span class="name">{{ o.name }}</span></slot>
      </label>
    </div>
    <div class="tip" v-if="tip">{{ tip }}</div>
  </div>
</template>

<script>
  import mixin from "@/mixins/control.js";
  export default {
    mixins: [mixin],
    data: function data() {
      var name = this.name;

      if (!name) {
        name = $.md5(Math.random().toString()).substring(0, 8);
      }

      return {
        name: name
      };
    }
  };
</script>

<style>
</style>
