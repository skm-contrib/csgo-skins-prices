<template>
  <div class="w-2/3 m-auto">
    <div class="grid grid-cols-4 gap-4">
      <RouterLink
        :to="{
          name: 'GunView',
          params: { type: skin.weapon, name: skin.name },
        }"
        v-for="skin in skins"
        class="relative group bg-gradient-to-t from-palette-200 to-palette-300 rounded-xl p-2 shadow-xl hover:shadow-palette-300 transition duration-300 cursor-pointer hover:-translate-y-2"
      >
        <h2 class="text-palette-100 text-xl font-bold">
          {{ skin.pattern }}
        </h2>
        <h3 class="text-palette-100 opacity-30">
          {{ skin.weapon }}
        </h3>
        <p class="text-sm">
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
          <span v-if="skin.rarity == `Covert`" class="text-red-700 font-bold">{{
            skin.rarity
          }}</span>
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

        <img :src="skin.image" alt="" />
        <div class="flex flex-row items-center justify-between gap-4">

          <div
            class="absolute p-2 text-xs rounded-2xl flex flex-col backdrop-filter backdrop-blur-xl group-hover:opacity-100 opacity-0 inset-0"
          >
            <p
              class="text-white font-bold max-w-xs sm:max-w-sm md:max-w-md lg:max-w-lg xl:max-w-xl"
            >
              <span class="opacity-70"> Pattern: </span> <br /><span
                class="text-xl opacity-100"
                >{{ skin.pattern }}</span
              >
            </p>
            <img class="w-2/3 justify-center m-auto" :src="skin.image" alt="" />
            <p
              class="text-white font-bold max-w-xs sm:max-w-sm md:max-w-md lg:max-w-lg xl:max-w-xl"
            >
              Min / Max float:
              <span class="opacity-70"
                >{{ skin.min_float }} / {{ skin.max_float }}</span
              >
            </p>

            <p
              class="text-white font-bold max-w-xs sm:max-w-sm md:max-w-md lg:max-w-lg xl:max-w-xl"
            >
              Rarity:
        <p class="text-sm">
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
          <span v-if="skin.rarity == `Covert`" class="text-red-700 font-bold">{{
            skin.rarity
          }}</span>
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
            </p>
            <p
              class="text-white font-bold max-w-xs sm:max-w-sm md:max-w-md lg:max-w-lg xl:max-w-xl"
            >
              Paint index:
              <span class="opacity-70">{{ skin.paint_index }}</span>
            </p>

          <div class="group-hover:opacity-100 opacity-0 duration-300">
            <p
              class="text-neutral-600 shadow-xl font-black bg-neutral-200 hover:bg-neutral-600
              mt-4 rounded-xl text-center hover:text-neutral-200 duration-300 text-4xl"
            >
              ♡
            </p>
          </div>
          </div>

          <div class="flex" v-if="skin.stattrak">
            <img
              class="h-8"
              src="../../public/images/service/StatTrak.webp"
              alt=""
            />
          </div>
        </div>
      </RouterLink>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, reactive, onMounted, computed } from "vue";
import { useRoute } from "vue-router";
import jsonCompose from "../composables/jsonrequster";
const route = useRoute();
const { skins, prices, getAllSkins, getAllSkinsByName } = jsonCompose();

onMounted(() => {
  getAllSkinsByName(route.params.name);
});

watch(
  () => route.params,
  () => {
    getAllSkinsByName(route.params.name);
  }
);
</script>
