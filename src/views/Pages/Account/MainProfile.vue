<template>
  <div class="m-auto sm:w-2/3 w-full sm:mx-4">
    <div
      class="text-red-400 mx-4 font-black text-2xl"
      v-if="user.role == 'ROLE_ADMIN'"
    >
      АДМІНІСТРАТОР
    </div>
    <h1 class="text-6xl mx-4 text-white font-bold mb-8">
      Акаунт "{{ user.nickname }}"
    </h1>
    <router-link
      v-if="user.role == 'ROLE_ADMIN'"
      class="text-white mx-4 bg-blue-800 p-4 text-xl font-bold hover:bg-blue-900 duration-300 rounded-xl"
      :to="{ name: 'AllUsers' }"
      >Адмін панель</router-link
    >
    <div class="flex flex-col gap-4 mt-12 w-screen sm:w-2/3">
      <h2 class="text-4xl text-white sm:text-start font-bold text-center">
        Редагування профіля
      </h2>
      <p class="text-white pt-4 mx-4">Зміна нікнейму</p>
      <input
        class="p-3 mx-4 rounded-xl focus:outline-none"
        type="text"
        v-model="user.nickname"
      />
      <p class="text-white pt-4 mx-4">Нова пошта</p>
      <input
        class="p-3 mx-4 rounded-xl focus:outline-none"
        type="text"
        v-model="user.email"
      />
      <p class="text-white pt-4 mx-4">Оновлення пароля</p>
      <input
        @change="checkPasswordCorrectivity"
        class="p-3 mx-4 rounded-xl focus:outline-none"
        type="text"
        v-model="user.password"
      />
      <p v-if="!canUpdate" class="text-red-400 mx-4">
        Пароль має містити більше 5 символів
      </p>
      <div v-for="error in errors" :key="error">
        <p class="text-red-400 mx-4">{{ error }}</p>
      </div>
      <button
        class="p-4 hover:bg-emerald-800 mx-4 duration-300 bg-emerald-600 text-white font-bold rounded-xl"
        @click="editWithValidation"
      >
        Зберегти зміни
      </button>
    </div>

    <div class="sm:w-2/3">
      <h2
        class="text-4xl text-center sm:text-start sm:mt-32 mt-12 text-red-400 font-bold"
      >
        Небезпечна зона
      </h2>
      <button
        class="p-4 my-4 w-full hover:bg-yellow-800 duration-300 bg-yellow-600 text-white font-bold rounded-xl"
        @click="logOut"
      >
        Вийти з акаунту
      </button>
      <button
        class="p-4 my-4 w-full hover:bg-red-800 duration-300 bg-red-600 text-white font-bold rounded-xl"
        @click="deleteAccount(user.id)"
      >
        Видалити акаунт
      </button>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import restAuth from "../../../composables/auth";

const { userLogged, logOut, getUser, user, editUser, errors, deleteAccount } =
  restAuth();

const canUpdate = ref(true);

const editWithValidation = async () => {
  if (canUpdate.value) {
    editUser(user.value);
  }
};
const checkPasswordCorrectivity = async () => {
  if (user.value.password.length < 5) {
    canUpdate.value = false;
  } else {
    canUpdate.value = true;
  }
};

onMounted(() => {
  userLogged();
  getUser();
});
</script>
