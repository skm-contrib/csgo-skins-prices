<template>
  <div
    v-if="skin"
    class="sm:w-2/3 m-auto flex bg-palette-300 my-12 p-4 rounded-b-xl shadow-xl"
  >
    <div class="flex flex-col gap-4 m-auto">
      <div class="relative">
        <div class="absolute justify-center bottom-0" v-if="skin.stattrak">
          <img class="h-24" src="/public/images/service/StatTrak.webp" alt="" />
        </div>
        <img
          class="filter m-auto drop-shadow-2xl sm:w-2/3 justify-center"
          :src="skin.image"
          alt=""
        />
      </div>
      <div class="flex flex-col gap-4">
        <p class="font-black text-xl sm:text-6xl text-white">
          {{ skin.name }}
        </p>
        <div class="text-xl flex flex-col gap-4 font-medium text-neutral-200">
          <p class="text-neutral-300 italic font-light pb-4">
            {{ skin.description }}
          </p>
          <p>Minimal float: {{ skin.minFloat }}</p>
          <p>Maximail float: {{ skin.maxFloat }}</p>
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
          <p>Paint index: {{ skin.paintIndex }}</p>
        </div>
      </div>
      <div class="cursor-pointer" @click="addSkinToFavourites">
        <svg
          :class="[
            isInFav
              ? 'bg-neutral-700 hover:bg-neutral-500 hover:fill-neutral-900 fill-neutral-200'
              : 'bg-neutral-200 hover:bg-neutral-500 hover:fill-neutral-200',
          ]"
          class="h-8 sm:h-12 w-full p-2 shadow-xl font-black rounded-xl text-center hover:text-neutral-200 duration-300 sm:text-4xl"
          fill="#000000"
          version="1.1"
          id="Capa_1"
          xmlns="http://www.w3.org/2000/svg"
          xmlns:xlink="http://www.w3.org/1999/xlink"
          viewBox="0 0 369.486 369.486"
          xml:space="preserve"
        >
          <g>
            <g>
              <path
                d="M184.743,357.351c-3.478,0-6.798-1.449-9.164-3.998l-147.67-159.16c-0.038-0.041-0.076-0.082-0.113-0.123
			C9.871,174.223,0,147.921,0,120.008c0-27.914,9.871-54.215,27.796-74.061l2.244-2.484c18.246-20.201,42.608-31.327,68.599-31.327
			s50.354,11.126,68.601,31.328l17.503,19.38l17.503-19.379c18.246-20.202,42.608-31.328,68.6-31.328s50.354,11.126,68.601,31.329
			l2.241,2.478c17.928,19.851,27.799,46.152,27.799,74.065s-9.872,54.215-27.796,74.061c-0.037,0.043-0.075,0.084-0.113,0.125
			l-147.671,159.16C191.541,355.901,188.221,357.351,184.743,357.351z M46.295,177.252l138.448,149.219l138.448-149.22
			c28.485-31.603,28.467-82.97-0.055-114.549l-2.239-2.478c-13.449-14.891-31.224-23.09-50.051-23.09
			c-18.828,0-36.603,8.199-50.048,23.085L194.02,89.869c-2.369,2.624-5.74,4.121-9.275,4.121s-6.906-1.497-9.276-4.121
			l-26.779-29.648c-13.446-14.887-31.22-23.086-50.048-23.086S62.039,45.333,48.594,60.22l-2.244,2.484
			C17.828,94.283,17.809,145.65,46.295,177.252z"
              />
            </g>
          </g>
        </svg>
      </div>
      <div v-if="chartData.datasets[0].data">
        <Line
          class="text-white font-bold"
          v-if="loaded"
          id="my-chart-id"
          :options="chartOptions"
          :key="chartData"
          ref="myChart"
          :data="chartData"
        />
      </div>
    </div>
  </div>
</template>
<script setup>
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import { Line } from "vue-chartjs";

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

import { ref, watch, reactive, onMounted, computed } from "vue";
import { useRoute } from "vue-router";
import jsonCompose from "../composables/jsonrequster";
const route = useRoute();

const {
  skin,
  prices,
  getSkinById,
  getAllSkins,
  addToFav,
  haveInFav,
  getSkinByName,
  getAllSkinsByType,
} = jsonCompose();

const chartData = reactive({
  labels: [],
  datasets: [
    {
      label: "Цінова активність",
      backgroundColor: "#4cba75",
      data: "",
    },
  ],
});
const isInFav = ref(false);

const checkIsFavorite = async () => {
  isInFav.value = await haveInFav(skin.value.skinId);
};
const chartOptions = ref({
  responsive: true,
});
const loaded = ref(false);
const pricesRange = computed(() => {
  return [chartData.datasets[0].data];
});

const labels = computed(() => {
  return [chartData.labels];
});
const addSkinToFavourites = async () => {
  if (loaded.value) {
    const token = localStorage.getItem("userId");
    addToFav(token, skin.value.skinId);
  }
};
const buildChart = async () => {
  console.log(chartData);
  pricesRange.value.splice(0, 1);
  labels.value.splice(0, 1);
  const formatDate = (dateString) => {
    const date = new Date(dateString);
    const formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1)
      .toString()
      .padStart(2, "0")}-${date.getDate().toString().padStart(2, "0")} ${date
      .getHours()
      .toString()
      .padStart(2, "0")}:${date.getMinutes().toString().padStart(2, "0")}:${date
      .getSeconds()
      .toString()
      .padStart(2, "0")}`;
    return formattedDate;
  };
  skin.value.skinPrices.forEach((priceRow) => {
    const formattedDate = formatDate(priceRow.timestamp);
    labels.value.push(formattedDate);

    //chartData.value.labels.push(priceRow.timestamp);
  });
  chartData.labels = labels.value;

  try {
    skin.value.skinPrices.forEach((priceRow) => {
      pricesRange.value.push(priceRow.price);
    });
    chartData.datasets[0].data = pricesRange.value;
  } catch (err) {
    console.log(err);
  }

  console.log(chartData);
};

onMounted(async () => {
  await getSkinById(route.params.id);
  await buildChart();
  await checkIsFavorite();
  loaded.value = true;
});
//watch(
//  () => route.params,
//  () => {
//    getSkinById(route.params.id);
//  }
//);
</script>
