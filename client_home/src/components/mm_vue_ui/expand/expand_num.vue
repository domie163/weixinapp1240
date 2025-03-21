<template>
  <div class="expand_num"><span :ref='name' class="text"></span></div>
</template>

<script>
  import {
    CountUp
  } from 'countup.js'

  export default {
    props: {
      name: {
        type: String,
        default: "countup"
      },
      init_num: {
        type: Number,
        default: 0.00
      },
      num: {
        type: Number,
        default: 0.00
      },
      useGrouping: {
        type: Boolean,
        default: false
      },
      decimals: {
        type: Number,
        default: 0
      },
      duration: {
        type: Number,
        default: 2
      }
    },
    data() {
      return {
        start: this.init_num,
        countUp: null
      }
    },
    methods: {
      change_num(start, end) {
        var options = {
          startVal: start,
          duration: this.duration,
          useGrouping: this.useGrouping,
          decimalPlaces: this.decimals
        };
        this.countUp = new CountUp(this.$refs[this.name], end, this.options);
        $.push(this.countUp.options, options);
        if (!this.countUp.error) {
          this.countUp.start()
        } else {
          console.error(this.countUp.error)
        }
        this.end = end;
      }
    },
    mounted() {
      this.change_num(this.start, this.num);
    },
    watch: {
      num() {
        this.countUp.update(this.num);
      }
    }
  }
</script>

<style>
</style>
