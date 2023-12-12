<script setup>
  
</script>

<template>
  <div class="common-layout">
    <el-container id="home-main">
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main><RouterView></RouterView></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped lang="scss">
.commom-layout{
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
}
#home-main {
  width: 100%;
  height: 100%;
  padding: 0;
  margin: 0;
  background-color: rgb(245, 247, 255);
  .el-header{
    background-color: rgb(149, 212, 117);
    height: 48px;
  }
  .el-aside{
    background-color: rgb(179, 225, 157);
  }
  
}

</style>