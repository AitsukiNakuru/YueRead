<template>
  <!--  注释不能写在标签属性的地方    页面高度默认为100vh，这样就能撑满整个页面，更美观,要减去header的height：50px-->
  <el-menu style="width: 150px;height: calc(100vh - 50px) " default-active="2" class="el-menu-vertical-demo" >
    <el-sub-menu index="1">
      <template #title>
        <el-icon><location /></el-icon>
        <span>导航一</span>
      </template>
      <el-sub-menu index="1-1">
        <template #title>子菜单一</template>
        <el-menu-item index="1-1-1">选项一</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="2">
      <el-icon><icon-menu /></el-icon>
      <span>导航二</span>
    </el-menu-item>
    <el-menu-item index="3" disabled>
      <el-icon><document /></el-icon>
      <span>导航三</span>
    </el-menu-item>
    <el-menu-item index="4">
      <el-icon><setting /></el-icon>
      <span>导航四</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "Menu",
}
</script>

<style scoped>

</style>