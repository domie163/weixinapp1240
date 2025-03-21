<template>
  <el-menu
    class="side el-menu-vertical-demo"
    default-active="/"
    @open="handleOpen"
    @close="handleClose"
    text-color="#fff"
    active-text-color="#38f"
    :collapse="isCollapse"
    :router="true"
    mode="horizontal"
    menu-trigger="click"
  >
    <el-menu-item index="/">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>

        <el-submenu
      index="web"
      v-show="
        user_group == '管理员' ||
        $check_group([
          '/nav/table',
          '/link/table',
          '/notice/table',
          '/slides/table',
          '/ad/table',
          '/message/table',
        ])
      "
    >
      <template slot="title"
        ><i class="el-icon-data-board"></i><span>网站管理</span></template
      >
            <!-- <el-menu-item v-show="user_group == '管理员' || $check_action('/auth/table')" index="/auth/table">
				<span>权限管理</span>
			</el-menu-item> -->
      <!-- <el-menu-item v-show="user_group == '管理员' || $check_action('/link/table')" index="/link/table">
				<span>友情链接</span>
			</el-menu-item> -->
      <el-menu-item
        v-show="user_group == '管理员' || $check_action('/slides/table')"
        index="/slides/table"
      >
        <span>轮播图</span>
      </el-menu-item>
      <!-- <el-menu-item v-show="user_group == '管理员' || $check_action('/ad/table')" index="/ad/table">
				<span>广告</span>
			</el-menu-item> -->
             <el-menu-item
        v-show="user_group == '管理员' || $check_action('/notice/table')"
        index="/notice/table"
      >
        <span>公告信息</span>
      </el-menu-item>
           </el-submenu>
    
    <el-submenu
      index="user"
      v-show="user_group == '管理员' || $check_group(['/user/table','/user_group/table'
				,'/student_users/table'
					])"
    >
      <template slot="title"
        ><i class="el-icon-user-solid"></i><span>人员管理</span></template
      >
      <el-menu-item index="/user/table" v-show="user_group == '管理员'"
        ><span>管理员</span></el-menu-item
      >
             <el-menu-item
        index="/student_users/table"
        v-show="user_group == '管理员' || $check_action('/student_users/table')"
        ><span>学生用户</span></el-menu-item
      >
               <!-- <el-menu-item index="/user_group/table"><span>用户组</span></el-menu-item> -->
    </el-submenu>

         <el-submenu
      index="content"
      v-show="$check_group(['/forum/table','/forum_type/table','/article/table','/article_type/table','/exam/table'])"
    >
      <template slot="title"
        ><i class="el-icon-chat-line-round"></i><span>内容管理</span></template
      >
            <el-menu-item
        v-show="user_group == '管理员' || $check_action('/forum/table')"
        index="/forum/table"
      >
        <!-- <span>论坛</span> -->
        <span>{{ $page_title('/forum/table') || '论坛' }}</span>
      </el-menu-item>
      <el-menu-item
        v-show="user_group == '管理员' || $check_action('/forum_type/table')"
        index="/forum_type/table"
      >
        <!-- <span>论坛类型</span> -->
        <span>{{ $page_title('/forum_type/table') || '论坛分类' }}</span>
      </el-menu-item>
             <el-menu-item
        v-show="user_group == '管理员' || $check_action('/article/table')"
        index="/article/table"
      >
        <!-- <span>文章</span> -->
        <span>{{ $page_title('/article/table') || '文章' }}</span>
      </el-menu-item>
      <el-menu-item
        v-show="user_group == '管理员' || $check_action('/article_type/table')"
        index="/article_type/table"
      >
        <!-- <span>文章类型</span> -->
        <span>{{ $page_title('/article_type/table') || '文章分类' }}</span>
      </el-menu-item>
           </el-submenu>
          
    <el-submenu index="more" v-show="auth.length">
      <template slot="title"
        ><i class="el-icon-copy-document"></i><span>模块管理</span></template
      >
      <el-menu-item
        v-for="(o, idx) in auth"
        v-show="$check_action(o.path)"
        :index="o.path"
      >
        <span>{{ o.page_title }}</span>
      </el-menu-item>
    </el-submenu>
    <el-submenu index="individual">
      <template slot="title"
        ><i src="/img/error.png"></i><span>个人管理</span></template
      >
      <el-menu-item index="/user/info" class="bg-hover"
        ><span>个人信息</span></el-menu-item
      >
      <el-menu-item index="/user/password" class="bg-hover"
        ><span>修改密码</span></el-menu-item
      >
    </el-submenu>

    <el-menu-item>
      <div class="action_right">
        <el-dropdown @command="handleCommand" trigger="click">
          <div class="el-dropdown-link" style="margin-right: 2rem">
            <el-avatar
              style="margin-top: 0.25rem; width: 2.3rem; overflow: hidden"
              :src="$fullUrl(user.avatar)"
            >
              <img
                style="width: 2.3rem; overflow: hidden"
                src="/img/error.png"
              />
            </el-avatar>
            <span class="info_color" style="margin-left: 0.5rem">{{
              user.nickname || user.username
            }}</span>
          </div>
          <el-dropdown-menu slot="dropdown" class="el-drop">
                        <el-dropdown-item command="/quit" class="el-item"
              >退出</el-dropdown-item
            >
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-menu-item>
  </el-menu>
</template>

<script>
	export default {
		props: {
			isCollapse: {
				trye: Boolean,
				default: false
			}
		},
		data: function() {
			return {
				user_group: this.$store.state.user.user_group,
				user: this.$store.state.user
			}
		},
		methods: {
			handleOpen(key, keyPath) {
				// console.log(key, keyPath);
			},

			handleClose(key, keyPath) {
				// console.log(key, keyPath);
			},
      handleCommand(command) {
      if (command === '/quit') {
        this.$get('~/api/user/quit', {}, (res) => {
          this.$store.commit('quit')
          this.$router.push('/login')
        })
      } else if (command.indexOf('http') !== -1) {
        let token = $.db.get('token')
        if (token) {
          location.href = command + '?token=' + token
        }
      } else {
        this.$router.push(command)
      }
    }
		},
		computed: {
			auth() {
				var tables = this.$store.state.web.auth;
				var lt = [];
				for (var i = 0; i < tables.length; i++) {
					var o = tables[i];
					if (o.path.indexOf("/table") !== -1) {
						let list = ["exam","article", "article_type", ,"comment","forum","forum_type","notice"];
							list.push("student_users");
								if (list.indexOf(o.table_name) === -1) {
							lt.push(o);
						}
					}
				}
				return lt;
			}
		}
	}
</script>

<style scoped="scoped">
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 100%;
}
.side::-webkit-scrollbar {
  display: none;
}
</style>
