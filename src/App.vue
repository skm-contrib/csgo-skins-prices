<script setup>
import { RouterLink, RouterView } from "vue-router";
import { ref, reactive, onMounted, computed } from "vue";
import { useRoute } from "vue-router";

import jsonCompose from "./composables/jsonrequster";
import { all } from "axios";
const route = useRoute();

const { skins, skinsCount, getAllSkins, getSkinsByName, getSkinsCount } =
  jsonCompose();

const searchSkinName = ref("");

let pageNumber = 0;
const skinsOnPage = 20;
const allPages = ref(0);
const getAllPages = async () => {
  allPages.value = Math.ceil(skinsCount.value / skinsOnPage);
};
const goToPreviousPage = () => {
  if (pageNumber > 0) {
    pageNumber--;
  }
  changePage();
};
const changePage = async () => {
  await makeSearch();
};

const goToLastPage = () => {
  pageNumber = allPages.value - 1;
  changePage();
};
const goToNextPage = () => {
  if (pageNumber < allPages.value - 1) {
    pageNumber++;
  }
  changePage();
};

const resetPageNumber = async () => {
  pageNumber = 0;
};
const goToPage = (page) => {
  page--;
  if (page >= 0 && page < allPages.value) {
    pageNumber = page;
  }
  changePage();
};

const resetSearch = async () => {
  pageNumber = 0;
  searchSkinName.value = "";
  makeSearch();
};

const makeSearch = async () => {
  router.push({ name: "home" });
  await getSkinsByName(searchSkinName.value, pageNumber);
  getAllPages();
};

onMounted(async () => {
  await getSkinsCount();
  await changePage();
  await getAllPages();
  getSkinsByName("");
});
</script>

<template>
  <div class="flex flex-col relative">
    <div
      class="w-2/3 z-50 m-auto backdrop-blur-lg bg-opacity-25 font-bold bg-palette-300 flex text-palette-100 flex-row justify-between items-center transition duration-300 rounded-b-xl"
    >
      <div class="flex flex-row">
        <div class="m-4">
          <RouterLink @click="resetSearch" class="p-4" to="/"
            >Головна</RouterLink
          >
        </div>
        <div
          class="m-4 z-10"
          @mouseover="showPistols = true"
          @mouseleave="showPistols = false"
        >
          <RouterLink
            class="link p-4"
            :to="{ name: 'Weapons', params: { type: 'weapon_type=pistol' } }"
            >Пістолети</RouterLink
          >

          <div
            class="absolute bg-palette-300 top-12 z-50 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-80 flex flex-col"
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
            :to="{ name: 'Weapons', params: { type: 'weapon_type=rifle' } }"
            >Рушниці</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 z-50 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-80 flex flex-col"
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
            :to="{ name: 'Weapons', params: { type: 'weapon_type=smg' } }"
            >СМГ</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 z-50 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-80 flex flex-col"
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
            :to="{ name: 'Weapons', params: { type: 'weapon_type=heavy' } }"
            >Тяжкі</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 z-50 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-80 flex flex-col"
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
            :to="{ name: 'Weapons', params: { type: 'weapon_type=knife' } }"
            >Ножі</RouterLink
          >
          <div
            class="absolute bg-palette-300 top-12 z-50 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-80 flex flex-col"
            v-if="showKnife"
          >
            <knifeSelector />
          </div>
        </div>
      </div>
      <div class="font-medium text-black">
        <input
          type="text"
          class="p-2 rounded-l-xl focus:outline-none"
          placeholder="Пошук по назві"
          v-model="searchSkinName"
          @change="resetPageNumber"
        />
        <button
          @click="makeSearch()"
          class="bg-neutral-700 hover:bg-neutral-500 duration-300 text-white h-full p-2 rounded-r-xl"
        >
          Пошук
        </button>
      </div>
      <div
        class="m-4 z-10"
        @mouseover="showProfile = true"
        @mouseleave="showProfile = false"
      >
        <div class="p-4">Акаунт</div>
        <div
          class="absolute bg-palette-300 top-12 rounded-md shadow-2xl backdrop-blur-lg bg-opacity-25 flex flex-col"
          v-if="showProfile"
        >
          <accountSelector />
        </div>
      </div>
    </div>
    <RouterView class="pt-12" :propSkins="skins" />
    <div
      v-if="route.name === 'home'"
      class="flex mb-32 w-2/3 m-auto text-white gap-4 mt-4 text-3xl flex-row justify-between"
    >
      <div>
        <p
          class="cursor-pointer text-white hover:text-emerald-600 duration-300"
          @click="goToPreviousPage"
        >
          Попередня
        </p>
      </div>
      <div class="flex flex-row gap-12">
        <p
          class="cursor-pointer text-white hover:text-emerald-600 duration-300"
          v-for="page in 3"
          :key="page"
          @click="goToPage(page)"
        >
          {{ page }}
        </p>
        <p>...</p>
        <p class="cursor-pointer hover:text-emerald-600 duration-300">
          {{ pageNumber + 1 }}
        </p>
        <p v-if="pageNumber >= 0">...</p>
        <p
          class="cursor-pointer hover:text-emerald-600 duration-300"
          @click="goToPage(allPages - 2)"
        >
          {{ allPages - 2 }}
        </p>
        <p
          class="cursor-pointer hover:text-emerald-600 duration-300"
          @click="goToPage(allPages - 1)"
        >
          {{ allPages - 1 }}
        </p>
        <p
          class="cursor-pointer hover:text-emerald-600 duration-300"
          @click="goToPage(allPages)"
        >
          {{ allPages }}
        </p>
      </div>
      <div>
        <p
          class="cursor-pointer hover:text-emerald-600 duration-300"
          @click="goToNextPage"
        >
          Наступна
        </p>
      </div>
    </div>
    <div class="absolute right-0 -z-50">
      <img
        class=""
        src="../src/assets/service/images/akimage.png"
        alt=""
        srcset=""
      />
    </div>
  </div>
</template>

<script>
import pistolSelector from "./components/modals/PistolSelector.vue";
import rifleSelector from "./components/modals/RifleSelector.vue";
import smgSelector from "./components/modals/SmgSelector.vue";
import heavySelector from "./components/modals/HeavySelector.vue";
import knifeSelector from "./components/modals/KnifeSelector.vue";
import accountSelector from "./components/modals/AccountSelector.vue";
import router from "./router";
export default {
  data() {
    return {
      showPistols: false,
      showRifles: false,
      showSMG: false,
      showHeavy: false,
      showKnife: false,
      showProfile: false,
    };
  },
  components: {
    pistolSelector,
    rifleSelector,
    smgSelector,
    heavySelector,
    knifeSelector,
    accountSelector,
  },
};
</script>

<style>
body {
  background-color: #393646;
}
</style>
