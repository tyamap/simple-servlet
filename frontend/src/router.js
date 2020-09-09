import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import About from './views/About.vue'
import Events from './views/Event/IndexEvents.vue'
import NewEvent from './views/Event/NewEvent.vue'
import Employees from './views/Employee/IndexEmployees.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/about',
      name: 'about',
      component: About
    },
    {
      path: '/employees',
      name: 'employees',
      component: Employees
    },
    {
      path: '/events',
      name: 'events',
      component: Events
    },
    {
      path: '/event/new',
      name: 'newEvent',
      component: NewEvent
    }
  ]
})
