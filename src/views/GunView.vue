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
      <div class="duration-300 cursor-pointer">
        <p
          class="text-neutral-600 shadow-xl font-black bg-neutral-200 hover:bg-neutral-600 mt-4 rounded-xl text-center hover:text-neutral-200 duration-300 text-4xl"
        >
          ♡
        </p>
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
  loaded.value = true;
});
//watch(
//  () => route.params,
//  () => {
//    getSkinById(route.params.id);
//  }
//);
</script>
