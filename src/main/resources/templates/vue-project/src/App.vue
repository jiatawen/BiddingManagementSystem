<template>
  <el-container style="height: 500px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>供方管理</template>
        <el-menu-item-group>
           <router-link to="/supplier" ><el-menu-item index="1-1">供方维护</el-menu-item></router-link>
          <router-link to="/suppliertype"><el-menu-item index="1-2"> 类型维护</el-menu-item></router-link>
          <br/>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
    </el-header>
    
    <el-main>
      <router-view></router-view>
      <!-- <Element></Element> -->
    </el-main>
  </el-container>
</el-container>

</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>
import Element from './components/Element.vue';
  export default {
    components:{
      Element
    }
  };
</script>