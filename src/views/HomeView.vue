<script setup>
import { ref, reactive, onMounted, computed } from "vue";

import { all } from "axios";
import jsonRequest from "../composables/jsonrequster";
const {
  skins,
  haveInFav,
  skinsCount,
  getAllSkins,
  getSkinsByName,
  getSkinsCount,
} = jsonRequest();

let pageNumber = 0;
const skinsOnPage = 20;
const allPages = ref(0);

const props = defineProps({
  propSkins: Array,
});
onMounted(async () => {
  await getSkinsByName("");
});
</script>

<script>
import SkinCard from "../components/modals/Skins/SkinCard.vue";
export default {
  components: { SkinCard },
  props: ["propSkins"],
};
</script>

<template>
  <div class="sm:w-2/3 m-auto">
    <div class="grid grid-cols-2 sm:grid-cols-4 gap-4">
      <SkinCard v-for="skin in propSkins" :skin="skin"></SkinCard>
    </div>
  </div>
</template>
