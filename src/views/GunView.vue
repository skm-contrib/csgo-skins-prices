<template>
  <div
    v-if="skin"
    class="w-2/3 m-auto flex bg-palette-300 my-12 p-4 rounded-b-xl shadow-xl"
  >
    <div class="flex flex-col gap-4 m-auto">
      <div class="relative">
        <div class="absolute justify-center bottom-0" v-if="skin.stattrak">
          <img class="h-24" src="/public/images/service/StatTrak.webp" alt="" />
        </div>
        <img
          class="filter m-auto drop-shadow-2xl w-2/3 justify-center"
          :src="skin.image"
          alt=""
        />
      </div>
      <div class="flex flex-col gap-4">
        <p class="font-black text-6xl text-white">
          {{ skin.name }}
        </p>
        <div class="text-xl flex flex-col gap-4 font-medium text-neutral-200">
          <p class="text-neutral-300 italic font-light pb-4">
            {{ skin.description }}
          </p>
          <p>Minimal float: {{ skin.min_float }}</p>
          <p>Maximail float: {{ skin.max_float }}</p>
          <p class="text-xl">
            Rarity:
            <span
              v-if="skin.rarity == `Consumer Grade`"
              class="text-blue-400 font-bold"
              >Industrial Grade</span
            >
            <span
              v-if="skin.rarity == `Industrial Grade`"
              class="font-bold text-blue-600"
            >
              Mil-Spec Grade
            </span>
            <span
              v-if="skin.rarity == `Mil-Spec Grade`"
              class="font-bold text-purple-700"
            >
              Restricted</span
            >
            <span
              v-if="skin.rarity == `Restricted`"
              class="text-pink-600 font-bold"
              >Classified</span
            >
            <span
              v-if="skin.rarity == `Classified`"
              class="text-red-700 font-bold"
              >Covert</span
            >
            <span
              v-if="skin.rarity == `Covert`"
              class="text-red-700 font-bold"
              >{{ skin.rarity }}</span
            >
            <span
              v-if="skin.rarity == `Contraband`"
              class="text-orange-500 font-bold"
              >{{ skin.rarity }}</span
            >
            <span
              v-if="skin.rarity == `Extraordinary`"
              class="text-red-700 font-bold"
              >{{ skin.rarity }}</span
            >
          </p>
          <p>Paint index: {{ skin.paint_index }}</p>
        </div>
      </div>
      <div class="duration-300 cursor-pointer">
        <p
          class="text-neutral-600 shadow-xl font-black bg-neutral-200 hover:bg-neutral-600 mt-4 rounded-xl text-center hover:text-neutral-200 duration-300 text-4xl"
        >
          ♡
        </p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, reactive, onMounted, computed } from "vue";
import { useRoute } from "vue-router";
import jsonCompose from "../composables/jsonrequster";
const route = useRoute();
const { skin, prices, getAllSkins, getSkinByName, getAllSkinsByType } =
  jsonCompose();

onMounted(() => {
  getSkinByName(route.params.name);
});

watch(
  () => route.params,
  () => {
    getSkinByName(route.params.name);
  }
);
</script>
