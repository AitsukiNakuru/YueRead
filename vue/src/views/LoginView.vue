<template>
  <div style="width: 100% ;height: 100vh ;background-color: navajowhite;overflow: hidden;text-align: center">
    <div style="font-family: 华文行楷;font-size:50px;padding-top: 60px;">欢迎登录yueRead后台管理系统！</div>
    <div style="margin: 50px 38% 50px 38%;background-color: aliceblue" :model="form">
      账号：<el-input prefix-icon="User" v-model="form.admin_username" style="margin-top: 40px; width: 50%" clearable /><br><br><!--clearable可以快速清空输入内容-->
      密码：<el-input prefix-icon="Lock" suffix-icon="hidden" v-model="form.admin_password" style="margin-bottom: 20px; width: 50%" show-password/><br><br><!--加了show-password 就能控制密码的显示隐藏，而如果写type="password",那么就是密码框，只隐藏-->
      <el-button type="primary" style="margin-bottom: 30px;" @click="login">登录</el-button>
    </div>
  </div>

</template>

<script>
import request from "../../utils/request";

export default {
  name: "LoginView",
  data(){
    return {
      form:{//注意变量名要与数据库/User一致
        admin_username:'',
        admin_password:''
      }
    }
  },
  methods:{
    login(){
      if(this.form.admin_password.trim()===''||this.form.admin_username.trim()===''){
        this.$message({
          type: "error",
          message: "用户名或密码不为空！"
        })
      }
      else{
        request.post('/user/login',this.form).then(res=>{
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "登录成功"
            })
            this.$router.push("/manage/home")
          } else {
            this.$message({
              type: "error",
              message: res.msg,
            });
          }
        })
      }

    }
  }

}
</script>

<style scoped>

</style>