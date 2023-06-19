<template>
  <div class="w-2/3 my-12 m-auto">
    <h1 class="text-4xl text-white font-bold">
      Вподобані {{ user.name }} скіни
    </h1>
  </div>
  <div class="w-2/3 gap-12 m-auto grid grid-cols-3">
    <div v-for="favSkin in user.favorites" :key="favSkin.skinId">
      <SkinCard :skin="favSkin"></SkinCard>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useRoute } from "vue-router";
import restAuth from "../../composables/auth";
import SkinCard from "../../components/modals/Skins/SkinCard.vue";
const { getUserById, editUser, user } = restAuth();
const route = useRoute();

onMounted(async () => {
  await console.log(route.params.id);
  await getUserById(route.params.id);
});
</script>
