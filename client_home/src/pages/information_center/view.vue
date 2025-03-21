<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','send_user') || $check_field('add','send_user') || $check_field('set','send_user')" label="发送用户" name="send_user">
                        <uni-data-select
                  id="form_send_user"
                  v-model="form['send_user']"
                  :localdata="list_user_send_user"
                  :clear="!disabledObj['send_user_isDisabled']"
                  :disabled="disabledObj['send_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','send_user')) || (!form['information_center_id'] && $check_field('add','send_user'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['send_user']"
                  :localdata="list_user_send_user"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','send_user')" id="send_user"
                ></uni-data-select>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','receiving_user') || $check_field('add','receiving_user') || $check_field('set','receiving_user')" label="接收用户" name="receiving_user">
                        <uni-data-select
                  id="form_receiving_user"
                  v-model="form['receiving_user']"
                  :localdata="list_user_receiving_user"
                  :clear="!disabledObj['receiving_user_isDisabled']"
                  :disabled="disabledObj['receiving_user_isDisabled']"
                  v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','receiving_user')) || (!form['information_center_id'] && $check_field('add','receiving_user'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['receiving_user']"
                  :localdata="list_user_receiving_user"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','receiving_user')" id="receiving_user"
                ></uni-data-select>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','message_header') || $check_field('add','message_header') || $check_field('set','message_header')" label="信息标题" name="message_header">
                                <uni-easyinput type="text" v-model="form['message_header']" v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','message_header')) || (!form['information_center_id'] && $check_field('add','message_header'))" :disabled="disabledObj['message_header_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','message_header')">
                  {{ form['message_header'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','send_date') || $check_field('add','send_date') || $check_field('set','send_date')" label="发送日期" name="send_date">
                        <uni-datetime-picker v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','send_date')) || (!form['information_center_id'] && $check_field('add','send_date'))" v-model="form['send_date']" type="date" :disabled="disabledObj['send_date_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','send_date')">
                  {{ form['send_date'] }}
                </text>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','information_content') || $check_field('add','information_content') || $check_field('set','information_content')" label="信息内容" name="information_content">
                        <uni-easyinput type="textarea" v-model="form['information_content']" v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','information_content')) || (!form['information_center_id'] && $check_field('add','information_content'))" :disabled="disabledObj['information_content_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','information_content')">
                  {{ form['information_content'] }}
                </text>
                    </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
            </view>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";

export default {
  mixins: [mixin],
  data() {
    return {
      field: "information_center_id",
      url_add: "~/api/information_center/add?",
      url_set: "~/api/information_center/set?",
      url_get_obj: "~/api/information_center/get_obj?",
      url_upload: "~/api/information_center/upload?",

      query: {
        "information_center_id": 0,
      },

      form: {
            "send_user": 0, // 发送用户
                    "receiving_user": 0, // 接收用户
                    "message_header":  '', // 信息标题
                    "send_date": this.$toTime(new Date().getTime(), "yyyy-MM-dd"),
                    "information_content":  '', // 信息内容
                                "information_center_id": 0, // ID
                
              },
          disabledObj:{
                        "send_user_isDisabled": false,
                                "receiving_user_isDisabled": false,
                                "message_header_isDisabled": false,
                                "send_date_isDisabled": false,
                                "information_content_isDisabled": false,
                                  },
                                // 用户列表
            list_user_send_user: [],
                        // 用户组
            group_user_send_user: "",
                                                    // 用户列表
            list_user_receiving_user: [],
                                                                                                      }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/information_center/upload?'),
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
    /**
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
      var _self = this;
      _self.upload_img_flag = false
      // 选择图像方法
      uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/information_center/upload?'),
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
    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_before(param){
      var form = uni.db.get("form");
      if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
        this.obj = uni.push(this.obj ,form);
        this.form = uni.push(this.form ,form);
      }
      var arr = []
      for (let key in form) {
        arr.push(key)
      }
      for (var i=0;i<arr.length;i++){
        this.disabledObj[arr[i] + '_isDisabled'] = true
      }
                                      if (this.form["send_date"] && JSON.stringify(this.form["send_date"]).indexOf("-")===-1) {
        this.form["send_date"] = this.$toTime(parseInt(this.form["send_date"]), "yyyy-MM-dd")
      }
                  uni.db.del("form");
      return param;
    },
            /**
     * 获取学生用户用户列表
     */
    async get_list_user_send_user() {
      // if(this.user_group !== "管理员" && this.form["send_user"] === 0) {
      //     this.form["send_user"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=学生用户");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_send_user.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取学生用户用户组
     */
    async get_group_user_send_user() {
      this.form["send_user"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=学生用户");
      if(json.result && json.result.obj){
        this.group_user_send_user = json.result.obj;
        this.get_user_session_send_user(this.form['send_user'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_send_user(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_send_user.source_table+"/get_obj?"
      this.$get(url, user_id, function(res) {
        if (res.result && res.result.obj) {
          var arr = []
          for (let key in res.result.obj) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in _this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arr[i] === arrForm[j]) {
                  if (arr[i] !== "send_user") {
                    _this.form[arrForm[j]] = res.result.obj[arr[i]]
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    break;
                  } else {
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  }
                }
              }
            }
          }
        }
      });
    },
            
                /**
     * 获取学生用户用户列表
     */
    async get_list_user_receiving_user() {
      // if(this.user_group !== "管理员" && this.form["receiving_user"] === 0) {
      //     this.form["receiving_user"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=学生用户");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_receiving_user.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                      if (this.form["send_date"] && JSON.stringify(this.form["send_date"]).indexOf("-")===-1) {
        this.form["send_date"] = this.$toTime(parseInt(this.form["send_date"]),"yyyy-MM-dd")
      }
                },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/information_center/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/information_center/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/information_center/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/information_center/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/information_center/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
            this.get_list_user_send_user();
            this.get_group_user_send_user();
                        this.get_list_user_receiving_user();
                                      },
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline:none;
}

.query_option{
  width: 100%;
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
