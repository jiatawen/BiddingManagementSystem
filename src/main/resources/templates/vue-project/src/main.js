import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/main.css'
import axios from './axios';
import store from './store';
import router from './router';
import request  from './axios';
Vue.prototype.$axios=axios
Vue.use(ElementUI);

new Vue({
  render: (h) => h(App),
  store,
  router,
  request
}).$mount('#app')
