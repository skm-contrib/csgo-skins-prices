<template>
  <div class="flex flex-col m-auto sm:w-2/3">
    <div
      class="flex flex-col sm:w-1/3 m-auto gap-2 backdrop-blur-lg bg-opacity-25 p-12 rounded-xl border-palette-200 border-2"
    >
      <h1 class="text-center text-3xl font-bold text-white">Реєстрація</h1>
      <label class="text-white pt-4" for="email"
        >Ім'я користувача / нікнейм</label
      >
      <input
        type="text"
        name="email"
        class="h-12 rounded-xl focus:outline-none p-2"
        v-model="form.nickname"
      />
      <label class="text-white pt-4" for="email">Електронна пошта</label>
      <input
        type="text"
        name="email"
        class="h-12 rounded-xl focus:outline-none p-2"
        v-model="form.email"
      />
      <label class="text-white pt-4" for="password">Пароль</label>
      <input
        type="password"
        name="password"
        class="h-12 rounded-xl focus:outline-none p-2"
        v-model="form.password"
      />

      <div v-for="error in errors" :key="error">
        <p class="text-red-600">{{ error }}</p>
      </div>
      <div
        class="flex flex-col gap-12 items-center text-center pt-12 justify-center"
      >
        <button
          @click="registerUser(form)"
          class="bg-neutral-600 hover:bg-neutral-700 duration-300 hover:-translate-y-2 hover:shadow-neutral-700 w-fit text-center text-white font-bold p-4 rounded-xl shadow-neutral-600 shadow-xl"
        >
          <p>Створити аккаунт</p>
        </button>
        <div class="flex flex-col">
          <p class="text-white font-medium">Вже зареєстровані?</p>
          <router-link
            class="p-4 font-black text-xl text-white hover:text-neutral-500 duration-200"
            :to="{ name: 'Login' }"
            >Увійти</router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import restAuth from "../../../composables/auth";
const { registerUser, user, errors } = restAuth();

const form = reactive({
  nickname: "",
  email: "",
  password: "",
});
</script>
