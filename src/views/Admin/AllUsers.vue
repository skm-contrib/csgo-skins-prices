<template>
  <div class="flex flex-col m-auto gap-4 sm:w-2/3">
    <div
      class="flex sm:justify-between gap-4 justify-center items-center text-white text-2xl p-2 rounded-xl backdrop-blur-xl bg-opacity-10 border-2 border-neutral-400 flex-col sm:flex-row bg-neutral-200"
      v-for="user in users"
      :key="user.id"
    >
      <div class="bg-transparent items-center">
        {{ user.id }}
        <input
          class="bg-transparent focus:outline-none"
          v-model="user.nickname"
        /><input
          class="bg-transparent focus:outline-none"
          v-model="user.email"
        />
        <select v-model="user.role" class="bg-transparent cursor-pointer">
          <option value="ROLE_USER" class="text-neutral-700">Користувач</option>
          <option value="ROLE_ADMIN" class="text-neutral-700">
            Адміністратор
          </option>
        </select>
      </div>
      <div
        @click="editUser(user)"
        class="bg-emerald-500 font-bold text-neutral-100 p-2 rounded-xl cursor-pointer hover:bg-emerald-700 duration-300"
      >
        Змінити
      </div>
      <div
        v-if="user.favorites.length != 0"
        @click="goToFavs(user.id)"
        class="bg-violet-500 font-bold text-neutral-100 p-2 rounded-xl cursor-pointer hover:bg-violet-700 duration-300"
      >
        Вподобані
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import restAuth from "../../composables/auth";
const { getUsers, editUser, users, isAdmin } = restAuth();
import { useRouter } from "vue-router";

const router = useRouter();
const goToFavs = async (uid) => {
  console.log(uid);
  router.push({ name: "UsersFavorite", params: { id: uid } });
};

onMounted(() => {
  isAdmin();
  getUsers();
});
</script>
