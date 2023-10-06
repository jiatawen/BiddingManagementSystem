<template>
  <div>   
  <!-- 添加按钮 -->
  <el-button type="primary" round @click="dialogVisible = true">＋添加</el-button>
  <div style="float:right;">
  <!-- 搜索框 -->
  <el-input v-model.trim="search" placeholder="请输入查找的供方类型" style="width: 200px; height: 40px; "> </el-input>&nbsp;
  <el-button type="success" round @click="handleQuery();exitQuery=true" >查询</el-button>
  <el-button type="danger" round v-show="exitQuery" @click="handleQueryAll();exitQuery =false">退出查询</el-button>
  </div>
  <!-- 显示表格 -->
      <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        label="类型编号"
        prop="id">
      </el-table-column>
      <el-table-column
        label="类型名称"
        prop="text">
      </el-table-column>
      <el-table-column
        label="类型描述"
        prop="memo">
      </el-table-column>
      <el-table-column
      label="操作"
        align="right">  
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.row)">编辑</el-button>       
            <el-popconfirm
                title="这是一条记录确定删除吗？"
                @confirm="handleDelete(scope.row.id)">
                <el-button type="text" slot="reference">删除</el-button>
              </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  
    <!-- 添加/修改表单 -->
    <el-dialog
          title="提示"
          :visible.sync="dialogVisible"
          width="600px"
          >
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <!-- <el-form-item label="类型id" prop="id">
      <el-input v-model="ruleForm.id"></el-input>
    </el-form-item> -->
    <el-form-item label="类型名称" prop="text">
      <el-input v-model="ruleForm.text"></el-input>
    </el-form-item>
    <el-form-item label="类型描述" prop="memo">
      <el-input v-model="ruleForm.memo"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
  </el-dialog>
    </div>
  </template>
  
  <script>
  export default {
      name:'SupplierType',
      data() {
        return {
          tableData: [],
          search: '',
          dialogVisible: false,
          exitQuery:false,
          ruleForm: {
            // id: '',
            text: '',
            memo: '',
          },
          // 验证表单
          rules: {
            text: [
              { required: true, message: '请输入类型名称', trigger: 'blur' },
              { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
            ],
            memo:[
            { required: true, message: '请输入类型描述', trigger: 'blur' },
            ]
          }
        }
      },
      //监听属性
     watch:{
      tableData:{
        handler(newVal){
          console.log(newVal)
        },
        deep:true,
        immediate:true
      }
     },
      methods: {
        //编辑数据
        handleEdit(row) {
         console.log(row)
        //   // this.$axios.
        this.dialogVisible=true
        this.ruleForm = row
        },
        //查询数据
        async handleQuery(){
          await this.$axios.get('/suppliertype/getone/?name='+ this.search).then(res=>{
            // console.log(res.data.data)
            this.tableData = res.data.data
          })
        },
          //删除记录
         handleDelete(id) {
          // console.log(id)
          this.$axios.get('/suppliertype/delete?id='+id).then(res=>{
            // console.log(res.code)
            this.handleQueryAll()
            this.$message({
                    showClose: true,
                    message: '恭喜你，操作成功',
                    type: 'success',
              //       onClose:() => {
              //         this.handleQueryAll(),
              // }
              
                  });
          })
        },
        //查询所有数据
        handleQueryAll(){
          this.$axios.get('/suppliertype/getall').then(res=>{
         
          this.tableData = res.data.data;
        })
        },
        //提交表单
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              // alert('提交成功!');
              this.$axios.post('/suppliertype/'+(this.ruleForm.id?'update':'add'),JSON.stringify(this.ruleForm),).then(
                res=>{
                  this.handleQueryAll()
                  this.$message({
                    showClose: true,
                    message: '恭喜你，操作成功',
                    type: 'success',
              //       onClose:() => {
              //         this.handleQueryAll()
              // }
                  });
                  this.dialogVisible = false
              })
      
            } else {
             alert('操作失败!!');
              return false;
            }
          });
        },
        //重置表单
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      },
      //再刷新页面前，发请求获取数据
      created(){
        this.$axios.get('/suppliertype/getall').then(res=>{
          console.log(res.data.data)
          this.tableData = res.data.data;
        })
      }
  }
  </script>
  
  
  <style>
   
  </style>
  
  