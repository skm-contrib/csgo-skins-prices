<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <div class="flex flex-col">
    <div
      class="w-2/3 m-auto bg-neutral-700 flex flex-row transition duration-300"
    >
      <div class="m-4">
        <RouterLink class="link p-4" to="/">Головна</RouterLink>
      </div>
      <div class="m-4">
        <RouterLink class="link p-4" to="/about">Пістолети</RouterLink>
      </div>
      <div class="m-4">
        <RouterLink class="link p-4" to="/about">Рушниці</RouterLink>
      </div>
      <div class="m-4">
        <RouterLink class="link p-4" to="/about">СМГ</RouterLink>
      </div>
      <div class="m-4">
        <RouterLink class="link p-4" to="/about">Тяжкі</RouterLink>
      </div>
      <div class="m-4">
        <RouterLink class="link p-4" to="/about">Ножі</RouterLink>
      </div>
    </div>

    <RouterView />
  </div>
</template>

<style>
body {
  background-color: #262626;
}
</style>
