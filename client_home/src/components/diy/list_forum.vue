<template>
  <view class="list row">
    <navigator
      v-for="(o, i) in list"
      :key="i"
      class="item"
      :url="'/pages/forum/details?' + vm.forum_id + '=' + o[vm.forum_id]"
    >
      <image
        class="image"
        :style="{ width: img_width, height: img_width }"
        :src="$fullImgUrl(o[vm.img])"
        mode="scaleToFill"
      >
      </image>
      <view class="right_block">
        <view class="top_info">
          {{ o[vm.title] }}
        </view>
        <view class="mid_info">{{
          $toTime(o[vm.create_time], "yyyy-MM-dd hh:mm:ss")
        }}</view>
        <view class="bottom_info">
          <text class="name">{{ o[vm.nickname] }}</text>
          <view>
            <text class="praise">{{ o[vm.praise_len] }}点赞</text>
            <text class="see"> {{ o[vm.hits] }}点击 </text>
          </view>
        </view>
      </view>
    </navigator>
  </view>
</template>

<script>
export default {
  props: {
    list: {
      type: Array,
      default: function () {
        return [];
      },
    },
    vm: {
      type: Object,
      default: function () {
        return {
          img: "img",
          forum_id: "forum_id",
          title: "title",
          description: "description",
          create_time: "create_time",
          content: "content",
          praise_len: "praise_len",
          hits: "hits",
          nickname: "nickname",
        };
      },
    },
    img_width: {
      type: String,
      default: "5rem",
    },
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style lang="scss" scoped>
.list {
  display: block;

  .item {
    display: flex;
    padding: 0.5rem;
    .image {
      margin-right: 1rem;
      &:hover {
        transform: rotateY(360deg);
        transition: all 0.5s ease-in-out;
      }
    }
    .right_block {
      flex: 1;
      display: flex;
      flex-direction: column;
      line-height: normal;
      .top_info {
        flex: 1;
        font-size: 0.8rem;
        color: $uni-text-color;
      }
      .mid_info {
        flex: 1;
        font-size: 0.5rem;
        color: $uni-text-color-grey;
      }
      .bottom_info {
        flex: 1;
        display: flex;
        justify-content: space-between;
        align-items: baseline;
        font-size: 0.5rem;
        color: $uni-text-color-grey;
      }
    }
  }
}
</style>
