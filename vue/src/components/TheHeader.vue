<template>
  <div style="height: 50px; line-height: 50px;border-bottom:1px solid #ccc; display:flex;">
    <!--font-weight:900;定义由细到粗的字符。400 等同于 normal(默认值)，lighter(更细)而 700 等同于 bold(粗）bolder(更粗)。-->
    <div style="width: 200px;padding-left: 50px;font-weight: bold;color: dodgerblue">后台管理</div>
    <div style="flex:1"></div>
    <div style="width: 100px">
      <el-dropdown>
        <span class="el-dropdown-link"><br>
          adminer
          <el-icon class="el-icon--right">
            <arrow-down/>
          </el-icon>
        </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>退出</el-dropdown-item>
              </el-dropdown-menu>
            </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>

export default {
  name: "TheHeader",
  components:{

  }
}
</script>
<style scoped>

</style>