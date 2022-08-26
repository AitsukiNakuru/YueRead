import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/Home.vue'
import LoginView from "@/views/LoginView";
import Layout from "@/layout/Layout";

const routes = [
  {
    path:'/',
    redirect:'login'
  },
  {
    path:  '/login',
    name:'login',
    component: LoginView
  },
  // {
  //   path:'/manager',
  //   name:  'home',
  //   // route level code-splitting 路由级代码拆分
  //   // this generates a separate chunk (about.[hash].js) for this route 这会为此路由生成一个单独的块（about.[hash].js）
  //   // which is lazy-loaded when the route is visited.访问路由时延迟加载。
  //   component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
  // }
  {
    path:  '/manage/',
    name:'layout',
    children:[
      {// 当/manager /home 匹配成功，即路径为/home时
        // Home组件会被渲染在 / 的 <router-view> 中
        path:'home',
        name:'home',
        component:()=>import('@/views/Home')
      },
    ],
    component: Layout
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes //(缩写)相当于routes:routes
})

export default router
