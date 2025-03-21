<template>
  <div class="control_number">
    <div class="title" v-if="title" v-html="title"></div>
    {{ value }}
    <div class="value" v-bind:class="{'disabled': disabled }">
      <mm_btn class="btn_primary btn_del" @click.native="del"><span></span></mm_btn><input type="number"
        :value.number="value" :min="min" :max="max" @input="set" @blur="setInt" :disabled="disabled" />
      <mm_btn class="btn_primary btn_add" @click.native="add"><span></span></mm_btn>
    </div>
    <div class="tip" v-if="tip">{{ tip }}</div>
  </div>
</template>

<script>
  import mixin from "@/mixins/control.js";
  export default {
    mixins: [mixin],
    methods: {
      setInt: function setInt(e) {
        var value = e.target.value ? e.target.value : "0";
        var num = Number(value);
        this.call(num);
      },
      add: function add() {
        this.call(this.value + this.num);
      },
      del: function del() {
        this.call(this.value - this.num);
      },
      set: function set(e) {
        var value = e.target.value ? e.target.value : "0";
        if (value == '-' || value.endsWith('.')) {

        } else if (value == '0-') {
          e.target.value = '-';
        } else {
          var num = Number(value);
          e.target.value = this.call(num);
        }
      },
      call: function call(num) {
        if (num > this.max && this.max !== 0) {
          num = this.max;
        } else if (num < this.min) {
          num = this.min;
        }
        this.$emit("input", num);
        return num;
      }
    }
  };
</script>

<style>
</style>
