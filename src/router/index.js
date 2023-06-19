import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import WeaponsView from "../views/WeaponsView.vue";
import WeaponView from "../views/WeaponView.vue";
import TypeView from "../views/TypeView.vue";
import GunView from "../views/GunView.vue";
import AllUsers from "../views/Admin/AllUsers.vue";
import UsersFavorite from "../views/Admin/UsersFavorite.vue";
import Profile from "../views/Pages/Account/MainProfile.vue";
import FavoritesPage from "../views/Pages/FavoritesPage.vue";
import RegisterPage from "../views/Pages/Auth/RegisterPage.vue";
import LoginPage from "../views/Pages/Auth/LoginPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/weapons_types/:type?",
      name: "Weapons",
      component: WeaponsView,
    },
    {
      path: "/user_favorite/:id?",
      name: "UsersFavorite",
      component: UsersFavorite,
      props: true,
    },
    {
      path: "/all_users",
      name: "AllUsers",
      component: AllUsers,
    },
    {
      path: "/favorites",
      name: "Favorites",
      component: FavoritesPage,
    },
    {
      path: "/register",
      name: "Register",
      component: RegisterPage,
    },
    {
      path: "/login",
      name: "Login",
      component: LoginPage,
    },
    {
      path: "/profile",
      name: "Profile",
      component: Profile,
    },
    {
      path: "/skin/:id?",
      name: "GunView",
      component: GunView,
      props: true,
    },
    {
      path: "/weapon/:name?",
      name: "TypeView",
      component: TypeView,
      props: true,
    },
    {
      path: "/weapons/:id?",
      name: "Weapon",
      component: WeaponView,
      props: true,
    },
    {
      path: "/about",
      name: "about",
      component: () => import("../views/AboutView.vue"),
    },
  ],
});

export default router;
