import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import WeaponsView from '../views/WeaponsView.vue'
import WeaponView from '../views/WeaponView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/weapons/:type?',
      name: 'Weapons',
      component: WeaponsView
    },
    {
      path: '/weapons/:type?/:name?',
      name: 'Weapon',
      component: WeaponView
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
