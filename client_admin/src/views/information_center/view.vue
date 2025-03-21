<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','send_user') || $check_field('add','send_user') || $check_field('set','send_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发送用户" prop="send_user">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_send_user(form['send_user']) }}
							<!--<el-input id="business_name" v-model="form['send_user']" placeholder="请输入发送用户"-->
							<!--v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','send_user')) || (!form['information_center_id'] && $check_field('add','send_user'))" :disabled="disabledObj['send_user_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','send_user')">{{form['send_user']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','send_user')) || (!form['information_center_id'] && $check_field('add','send_user'))" id="send_user" v-model="form['send_user']" :disabled="disabledObj['send_user_isDisabled']">
								<el-option v-for="o in list_user_send_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','send_user')" id="send_user" v-model="form['send_user']" :disabled="true">
								<el-option v-for="o in list_user_send_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="send_user" v-model="form['send_user']" :disabled="disabledObj['send_user_isDisabled']">
							<el-option v-for="o in list_user_send_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','receiving_user') || $check_field('add','receiving_user') || $check_field('set','receiving_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="接收用户" prop="receiving_user">
													<el-select v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','receiving_user')) || (!form['information_center_id'] && $check_field('add','receiving_user'))" id="receiving_user" v-model="form['receiving_user']" :disabled="disabledObj['receiving_user_isDisabled']">
							<el-option v-for="o in list_user_receiving_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','receiving_user')" id="receiving_user" v-model="form['receiving_user']" :disabled="true">
							<el-option v-for="o in list_user_receiving_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','message_header') || $check_field('add','message_header') || $check_field('set','message_header')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="信息标题" prop="message_header">
												<el-input id="message_header" v-model="form['message_header']" placeholder="请输入信息标题"
							  v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','message_header')) || (!form['information_center_id'] && $check_field('add','message_header'))" :disabled="disabledObj['message_header_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','message_header')">{{form['message_header']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','send_date') || $check_field('add','send_date') || $check_field('set','send_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发送日期" prop="send_date">
								<el-date-picker :disabled="disabledObj['send_date_isDisabled']" v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','send_date')) || (!form['information_center_id'] && $check_field('add','send_date'))" id="send_date"
						v-model="form['send_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','send_date')">{{form['send_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','information_content') || $check_field('add','information_content') || $check_field('set','information_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="信息内容" prop="information_content">
								<el-input type="textarea" id="information_content" v-model="form['information_content']" placeholder="请输入信息内容"
						v-if="user_group === '管理员' || (form['information_center_id'] && $check_field('set','information_content')) || (!form['information_center_id'] && $check_field('add','information_content'))" :disabled="disabledObj['information_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','information_content')">{{form['information_content']}}</div>
							</el-form-item>
			</el-col>
					
	
	

	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

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
										"send_date":  '', // 发送日期
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


	
	
				/**
			 * 获取学生用户用户列表
			 */
			async get_list_user_send_user() {
                // if(this.user_group !== "管理员" && this.form["send_user"] === 0) {
                //     this.form["send_user"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生用户");
                if(json.result && json.result.list){
                    this.list_user_send_user = json.result.list;
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
			
									_this.form["send_user"] = id
									_this.disabledObj['send_user' + '_isDisabled'] = true
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
					get_user_send_user(id){
				var obj = this.list_user_send_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
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
                    this.list_user_receiving_user = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_receiving_user(id){
				var obj = this.list_user_receiving_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
		
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
								        if (this.form["send_date"].indexOf("-")===-1){
          this.form["send_date"] = this.$toTime(parseInt(this.form["send_date"]),"yyyy-MM-dd")
        }
							$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


											        if(this.form["send_date"]=="0000-00-00"){
          this.form["send_date"] = null;
        }
				if(parseInt(this.form["send_date"]) > 9999){
					this.form["send_date"] = this.$toTime(parseInt(this.form["send_date"]),"yyyy-MM-dd")
				}
					

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																					return msg;
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
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},


		},
		created() {
					this.get_list_user_send_user();
					this.get_group_user_send_user();
								this.get_list_user_receiving_user();
											},
	}
</script>

<style>
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

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
