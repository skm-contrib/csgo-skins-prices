<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <div class="flex flex-col">
    <div
      class="w-2/3 m-auto font-bold bg-palette-300 flex text-palette-100 flex-row transition duration-300"
    >
      <div class="flex flex-row">
        <div class="m-4">
          <RouterLink class="p-4" to="/">Головна</RouterLink>
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showPistols = true"
          @mouseleave="showPistols = false"
        >
          <RouterLink
            class="link p-4"
            :to="{ name: 'Weapons', params: { type: 'pistols' } }"
            >Пістолети</RouterLink
          >

          <div
            class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
            v-if="showPistols"
          >
            <pistolSelector />
          </div>
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showRifles = true"
          @mouseleave="showRifles = false"
        >
          <RouterLink
            class="p-4"
            :to="{ name: 'Weapons', params: { type: 'rifles' } }"
            >Рушниці</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
            v-if="showRifles"
          >
            <rifleSelector />
          </div>
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showSMG = true"
          @mouseleave="showSMG = false"
        >
          <RouterLink
            class="p-4"
            :to="{ name: 'Weapons', params: { type: 'smgs' } }"
            >СМГ</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
            v-if="showSMG"
          >
            <smgSelector />
          </div>
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showHeavy = true"
          @mouseleave="showHeavy = false"
        >
          <RouterLink
            class="p-4"
            :to="{ name: 'Weapons', params: { type: 'heavy' } }"
            >Тяжкі</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
            v-if="showHeavy"
          >
            <heavySelector />
          </div>
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showKnife = true"
          @mouseleave="showKnife = false"
        >
          <RouterLink
            class="p-4"
            :to="{ name: 'Weapons', params: { type: 'knifes' } }"
            >Ножі</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
            v-if="showKnife"
          >
            <knifeSelector />
          </div>
        </div>
      </div>
    </div>

    <RouterView class="pt-12" />
  </div>
</template>

<script>
import pistolSelector from "./components/modals/PistolSelector.vue";
import rifleSelector from "./components/modals/RifleSelector.vue";
import smgSelector from "./components/modals/SmgSelector.vue";
import heavySelector from "./components/modals/HeavySelector.vue";
import knifeSelector from "./components/modals/KnifeSelector.vue";
export default {
  data() {
    return {
      showPistols: false,
      showRifles: false,
      showSMG: false,
      showHeavy: false,
      showKnife: false,
    };
  },
  components: {
    pistolSelector,
    rifleSelector,
    smgSelector,
    heavySelector,
    knifeSelector,
  },
};
</script>

<style>
body {
  background-color: #393646;
}
</style>
