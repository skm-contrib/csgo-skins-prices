<template>
  <div>
    <div>
      <ul>
        <li v-for="gun in weaponsByType" :key="gun.name"></li>
      </ul>
    </div>
    <div class="sm:w-2/3 m-auto pt-12">
      <div class="grid sm:grid-cols-4 grid-cols-2 gap-4">
        <SkinCard v-for="skin in skins" :skin="skin"></SkinCard>
      </div>
      <div class="flex mb-32 gap-4 mt-4 text-3xl flex-row justify-between">
        <div>
          <p
            class="cursor-pointer hover:text-emerald-600 duration-300"
            @click="goToPreviousPage"
          >
            Попередня
          </p>
        </div>
        <div class="flex flex-row gap-12">
          <p
            class="cursor-pointer hover:text-emerald-600 duration-300"
            v-for="page in 3"
            :key="page"
            @click="goToPage(page)"
          >
            {{ page }}
          </p>
          ...
          <p class="cursor-pointer hover:text-emerald-600 duration-300">
            {{ pageNumber + 1 }}
          </p>
          ...
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
    </div>
  </div>
</template>
<script>
import SkinCard from "../components/modals/Skins/SkinCard.vue";
export default {
  components: { SkinCard },
};
</script>

<script setup>
import jsonCompose from "../composables/jsonrequster";
import { all } from "axios";

import { ref, reactive, onMounted, watch, computed } from "vue";

import { useRoute } from "vue-router";
import gunsNamesByType from "../assets/service/pistolsNames.json";
const route = useRoute();

const { skins, skinsCount, getAllSkins, getAllSkinsByWeapon, getSkinsCount } =
  jsonCompose();

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
  await getAllSkinsByWeapon(route.params.name, pageNumber);
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
const goToPage = (page) => {
  page--;
  if (page >= 0 && page < allPages.value) {
    pageNumber = page;
  }
  changePage();
};

const updatePageSkins = async () => {
  await getAllSkinsByWeapon(route.params.name);
  await getAllPages();
};

onMounted(async () => {
  await getSkinsCount();
  await getAllSkinsByWeapon(route.params.name);
  await changePage();
  await getAllPages();
});
watch(
  () => route.params,
  () => {
    updatePageSkins();
  }
);
</script>
