<template>
    <div>
        <h1>{{email}}</h1>
        <form @submit.prevent="demo">
          姓名：<input type="text" v-model.trim="userInfo.sname" name="sname"/><br/><br/>
          性别：<input type="text" v-model.trim="userInfo.sex" name="sex"/><br/><br/>
          <button>提交</button>
        </form>
    </div>

</template>


<script>
import {  mapGetters,mapState } from 'vuex'

export default {
    name:"HelloWorld",
    data(){
        return{
            // name1:this.$store.state.name,
            // name:'',
            code:'',
            userInfo:{
                   sid:'',
                   sname:'',
                   sex:''
                }
        }
    },
    computed:{
        ...mapState({
            email:state=>state.list.email
        })
    },
    methods:{
        demo(){
            // console.log(JSON.stringify(this.userInfo))
            // axios({
            //             method:'post',
            //             headers:{
            //                 "Content-Type":"application/json",          
            //             },
            //             url:'http://localhost:80/stu',
            //             data:JSON.stringify(this.userInfo)
            //             // data:this.userInfo
            //         }).then(resonse=>{
            //             console.log(resonse)
            //         })
            this.$axios.post('/stu',JSON.stringify(this.userInfo)).then(res => {
            this.code = res.data.code;
            console.log(this.code)
})
        }
    }
    
}
</script>

<style>

</style>

