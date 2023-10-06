import Vue from "vue"
import VueRouter  from "vue-router";

import Supplier from '../components/Supplier.vue'
import SupplierType from '@/components/SupplierType.vue'
Vue.use(VueRouter)
let router = new VueRouter({
    routes:[
      {
                path:'/supplier',
                component:Supplier
    },
    {
      path:'/suppliertype',
      component:SupplierType
},
]

})

export default router