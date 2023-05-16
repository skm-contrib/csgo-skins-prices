<template>
  <div class="w-2/3 m-auto">
    <div class="grid grid-cols-4 gap-4">
      <div
        v-for="skin in skins"
        class="bg-palette-300 group rounded-xl p-2 shadow-xl hover:shadow-palette-300 transition duration-300 cursor-pointer hover:-translate-y-2"
      >
        <h2 class="text-palette-100 text-xl font-bold">
          {{ skin.pattern }}
        </h2>
        <h3 class="text-palette-100 opacity-30">
          {{ skin.weapon }}
        </h3>

        <img :src="skin.image" alt="" />
        <div class="flex flex-row items-center justify-between">
          <div class="group-hover:opacity-100 opacity-0 duration-300">
            <p
              class="text-palette-400 font-black hover:text-palette-200 duration-300 text-4xl"
            >
              ♡
            </p>
          </div>
          <div v-if="skin.stattrak">
            <img
              class="h-8"
              src="../../../../../../../../../public/images/service/StatTrak.webp"
              alt=""
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, reactive, onMounted, computed } from "vue";
import { useRoute } from "vue-router";
import jsonCompose from "../composables/jsonrequster";
const route = useRoute();
const { skins, prices, getAllSkins, getSkinPrice, getAllSkinsByType } =
  jsonCompose();

onMounted(() => {
  getAllSkinsByType(route.params.name);
});

watch(
  () => route.params,
  () => {
    getAllSkinsByType(route.params.name);
  }
);
</script>
