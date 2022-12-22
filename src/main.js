import Vue from 'vue'
import Vuelidate from 'vuelidate'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import Routes from './routes'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueRouter)
Vue.use(Vuelidate)

const router = new VueRouter({
  routes: Routes,
  mode: "history"
})

router.beforeEach((to, from, next) => {
  if(to.name !== "login" && !localStorage.user_login) next ({name: "login"});
  else if (to.name === "login" && localStorage.user_login)
    next({name: "home"});
  else next();
})

new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')
