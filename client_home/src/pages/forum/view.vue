<template>
  <view>
          <view class="">
            <uni-forms :modelValue="form">
              <uni-forms-item label="封面图" name="img">
                <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form.img">
                  <img style="width: 100px;height: 100px" :src="$fullImgUrl(form.img)" @click="change_img('img')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else>
                  <view style="width: 100px;height: 100px" class="btn_add_img" @click="change_img('img')">
                    <text>+</text>
                  </view>
                </view>
              </uni-forms-item>
              <uni-forms-item label="标题" name="title">
                <uni-easyinput type="text" v-model="form.title" />
              </uni-forms-item>
              <uni-forms-item label="分类" name="type">
               <!-- <select class="type_select" id="type" v-model="form.type">
                  <option v-for="o in list_forum_type" :value="o.name">
                    {{o.name}}
                  </option>
                </select> -->
				<uni-data-select
				  
				  v-model="form.type"
				  :localdata="list_forum_type"
				></uni-data-select>
              </uni-forms-item>
              <uni-forms-item label="标签" name="tag">
                <uni-easyinput type="text" v-model="form.tag" />
              </uni-forms-item>
              <uni-forms-item label="正文" name="content">
                <!--<quill-editor v-model="form.content" class="form_editor_block">-->
                <!--</quill-editor>-->
                <uni-easyinput type="textarea" v-model="form.content" />
              </uni-forms-item>
            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()">发表内容</button>
            </view>
          </view>
  </view>
</template>

<script>
  import mixin from "@/libs/mixins/page.js";

  export default {
    mixins: [mixin],
    components: {
    },
    data() {
      return {
        field: "forum_id",
        url_add: "~/api/forum/add?",
        url_set: "~/api/forum/set?",
        url_get_obj: "~/api/forum/get_obj?",
        url_upload: "~/api/forum/upload?",

        query: {
          forum_id: 0
        },

        list_forum_type: [],

        form: {
          forum_id: 0,
          user_id: this.$store.state.user.user_id,
          display: 0,
          nickname: this.$store.state.user.nickname,
          hits: 0,
          title: "",
          keywords: "",
          description: "",
          url: "",
          tag: "",
          img: "",
          content: "",
          avatar: this.$store.state.user.avatar,
          type:""
        },

      }
    },
    methods: {
      /**
       * 上传图片
       * @param {Object} param文件参数
       */
      change_img(key_name){
        var _self = this;
        // 选择图像方法
        uni.chooseImage({
          count: 1,
          sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
          sourceType: ['album'], //从相册选择
          success: function(res) {
            const tempFilePaths = res.tempFilePaths;
            const uploadTask = uni.uploadFile({
              url: _self.$fullUrl('/api/forum/upload?'),
              filePath: tempFilePaths[0],
              name: 'file',
              formData: {
                'i_want_to_customize': 'test'
              },
              header: {
                'x-auth-token': _self.$store.state.user.token
              },
              success: function(uploadFileRes) {
                var filename = JSON.parse(uploadFileRes.data).result.url
                _self.form[key_name] = filename
              }
            });

            uploadTask.onProgressUpdate(function(res) {
              _self.percent = res.progress;
              console.log('上传进度' + res.progress);
              console.log('已经上传的数据长度' + res.totalBytesSent);
              console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
            });
          },
          error: function(e) {
            console.log(e);
          }
        });
      },

      submit_check(params) {
        var msg = "";
        if (params.title === "") {
          msg = "标题不能为空";
          return msg;
        }
      },

      async get_forum_type() {
        var json = await this.$get("~/api/forum_type/get_list?");
        if(json.result){
          // this.list_forum_type = json.result.list;
		  console.log(json.result.list)
			json.result.list.map(o=>{
				this.list_forum_type.push({value:o.name,text:o.name})
			})
        }
        else if(json.error){
          console.error(json.error);
        }
      },
    },
    created(){
      this.get_forum_type();
    }
  }
</script>

<style>

  .form_button{
    padding-bottom: 15px;
    display: flex;
  }
  .form_button button{
    width: 40%;
  }

  .btn_add_img{
    color: #D3D3D3;
    text-align: center;
    border: 1px solid #eee;
    height: 5rem;
    width: 5rem;
    position: relative;
  }
  .btn_add_img text{
    font-size: 35px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
  }
  .type_select{
    width: 100%;
    border: 1px solid #e5e5e5;
    border-radius: 4px;
    min-height: 36px;
  }

</style>
