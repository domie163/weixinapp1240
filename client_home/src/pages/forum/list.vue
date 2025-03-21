<template>
  <view class="page_forum" id="forum_index">
    <uni-search-bar
      placeholder="搜索帖子"
      @confirm="search"
      @cancel="cancel"
      cancelText="取消"
      @input="input($event, 'title')"
    >
      <uni-icons slot="searchIcon" color="#999999" size="18" type="home" />
    </uni-search-bar>
    <view class="change">
      <uni-data-select
        @change="searchType"
        style="width: 50%;"
        v-model="query.type"
        :localdata="list_forum_type"
      ></uni-data-select>
      <navigator
        class="button"
        v-if="user_group == '管理员' || $check_action('/forum/list', 'add')"
        url="/pages/forum/view"
      >
        <text>发布内容</text>
      </navigator>
    </view>

    <!-- 论坛列表模块(开始) -->

    <template v-if="$check_action('/forum/list', 'get')">
      <!-- 论坛列表 -->
      <list_forum
        style="background-color: #fff"
        :list="list"
        class="mb"
      ></list_forum>
      <!-- /论坛列表 -->
    </template>
    <!-- 分页器 -->
    <uni-pagination
      class="pager"
      show-icon="true"
      :total="count"
      :pageSize="query.size"
      :current="query.page"
      @change="page_change"
    ></uni-pagination>
    <!-- /分页器 -->

    <!-- 论坛列表模块(结束) -->

  </view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";
import list_forum from "@/components/diy/list_forum.vue";

export default {
  mixins: [mixin],
  components: {
    list_forum,
  },
  data() {
    return {
      url_get_list: "~/api/forum/get_list?like=0",
      list: [],
      query: {
        title: "",
        page: 1,
        size: 3,
        type: "",
      },
      list_forum_type: [{value:"",text:"全部"}],
      type_names: [],
      filter_title: "筛选",
      sort_title: "排序",
      sort_list: [
        {
          name: "热度从高到低",
          value: "`hits` desc",
        },
        {
          name: "热度从低到高",
          value: "`hits` asc",
        },
        {
          name: "更新时间从高到低",
          value: "`create_time` desc",
        },
        {
          name: "更新时间从低到高",
          value: "`create_time` asc",
        },
      ],
    };
  },
  methods: {
    /**
     * 添加论坛内容过滤
     */
    get_forum_type() {
      this.$get("~/api/forum_type/get_list", {}, (res) => {
        if (res.result) {
          res.result.list.map((o) => this.list_forum_type.push({value:o.name,text:o.name}));
        }
      });
    },
    /**
     * 下拉筛选选择
     */
    filter_item(name) {
      if (name.name == "全部") {
        this.query = {
          page: 1,
          size: 10,
        };
        this.get_list();
      } else {
        this.query.type = name.name;
        this.search();
      }
    },
    /**
     *下拉排序
     */
    sort_item(o) {
      this.query.orderby = o.name.value;
      this.search();
    },
    input(e, key) {
      this.query[key] = e.value;
    },
    search() {
      this.query.page = 1;
      this.get_list();
    },
    searchType(v){
      this.query.type = v;
      this.query.page = 1;
      this.get_list();
    },
    cancel() {
      this.query.title = "";
      this.search();
    },
  },
  mounted() {
    this.get_forum_type();
  },
};
</script>

<style lang="scss" scoped>
.page_forum {
  padding: 0 10px;
  .change {
    display: flex;
    align-items: flex-start;
    .button {
      background-color: #0154ba;
      width: 50%;
      display: block;
      line-height: 36px;
      margin: 8px;
      text-align: center;
      color: white;
      border-radius: 5px;
      font-size: 14px;
    }
  }
}
</style>
