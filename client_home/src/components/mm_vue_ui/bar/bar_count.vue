<template>
    <div class="bar_count">
      <div class="figure">
        <img :src="obj.image">
        <span class="tag" v-if="obj.tag && obj.tag != 0">{{obj.tag}}</span>
      </div>
      <div class="btn" @click="even_click(obj)"><span>去结算</span></div>
      <div class="content">
        <div class="count">
          <div class="price">{{obj.price}}</div>
          <div class="price_ago">{{obj.price_ago}}</div>
        </div>
        <div class="deliver">{{obj.deliver}}</div>
      </div>
    </div>
</template>

<script>
  import mixin from '@/mixins/component.js'
  export default {
    mixins: [mixin],
    props: {
      obj:{
        type:Object,
        default: function(){
          return{
            image: "/img/default.png",
            tag: 1,
            price: 29.98,
            price_ago: 30.55,
            deliver: 0.57,
          }
        }
      }
    },
    data() {
      return {
      }
    },
    methods: {
      even_click(o) {
        if (this.func) {
          this.func(o);
        }
      }
    }
  }
</script>

<style>

</style>
