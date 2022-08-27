<template>
  <div>
    <!--  头部栏-->
    <TheHeader/>
    <div style="display:flex">
      <Menu/>
      <router-view style="flex:1" />
    </div>
   </div>
</template>

<script>
import TheHeader from "@/components/TheHeader";
import Menu from "@/components/Menu";

export default {
  name: "Layout",
  components:{
    TheHeader,
    Menu
  }
}
</script>

<style scoped>

</style>