<template>
  <!-- 文章 -->
  <mm_item :url="obj[vm.url]">
    <div class="item_article" :class="css">
      <div class="media">
        <mm_icon :src="obj[vm.image]" :desc="obj[vm.tip]"></mm_icon>
      </div>
      <div class="doc">
        <div class="title" v-if="obj[vm.title]">
          <span class="h4">{{ obj[vm.title] }}</span>
          <span class="tag" v-if="obj[vm.tag]">{{ obj[vm.tag] }}</span>
        </div>
        <div class="content">
          <div class="desc" v-if="obj[vm.description]">{{ obj[vm.description] }}</div>
          <div class="source" v-if="obj[vm.source]">{{ obj[vm.source] }}</div>
          <div class="num_comment" v-if="obj[vm.num_comment]">{{ obj[vm.num_comment] }}</div>
          <div class="time" v-if="obj[vm.create_time]">{{ $to_time(obj[vm.create_time]) }}</div>
          <div class="collect" v-if="obj[vm.collect] && show" @click="run('collect', obj)">
            <span class="fa fa-heart" v-bind:class="{ 'font-default': obj[vm.collect] }"></span>
            <span>{{ obj[vm.collect] }}</span>
          </div>
          {{ obj[vm.content] }}
        </div>
      </div>
    </div>
  </mm_item>
</template>

<script>
  import mixin from '@/mixins/item.js'

  export default {
    mixins: [mixin],
    props: {
      uid: {
        type: Number,
        default: 0
      },
      show: {
        type: Boolean,
        default: true
      },
      field: {
        type: String,
        default: "id"
      }
    },
    methods: {
      click_fun(o) {
        var u = obj[this.vm.url];
        if (this.func) {
          if (!this.func(o)) {
            return;
          }
        }
        if (u) {
          this.$nav(u);
        }
      },
      has_collect(arr) {
        if (arr) {
          if (this.uid && arr) {
            return arr.has(this.field, this.uid);
          }
        }
        return false;
      }
    }
  }
</script>

<style>
</style>
