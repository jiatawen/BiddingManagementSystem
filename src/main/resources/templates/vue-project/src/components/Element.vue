<template>

</template>


<style>
 
</style>

<script>
  export default{
    data() {
      return {
        ruleForm: {
          id: '',
          name: '',
          address: '',
          tel: '',
          type: false,
          money: '',
         
        },
        dialogVisible: true,
        rules: {
          name: [
            { required: true, message: '请输入供应商名称', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '请输入供应商地址', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '请输入供应商电话', trigger: 'blur' }
          ],
          type: [
            { type: 'array', required: true, message: '请选择供应商类型', trigger: 'change' }
          ],
          money: [
            { required: true, message: '请输入供应商注册资金', trigger: 'blur' }
          ],
         
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
  
</script>