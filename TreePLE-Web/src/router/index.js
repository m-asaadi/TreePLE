import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import TreePLE from '@/components/TreePLE'
import forecast from '@/components/forecast'
import view from '@/components/view'
import Plant from '@/components/Plant'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/app',
      name: 'TreePLE',
      component: TreePLE
    },
    {
      path: '/forecast',
      name: 'forecast',
      component: forecast
    },
    {
      path: '/view',
      name: 'view',
      component: view
    },
    {
      path: '/Plant',
      name: 'Plant',
      component: Plant
    }
  ]
})
