<template>
    <div class="bg-palette-300 backdrop-blur-lg bg-opacity-30 hover:bg-opacity-100 rounded-xl">
    <RouterLink  class="relative group  rounded-xlshadow-md hover:shadow-palette-300 transition duration-300 cursor-pointer hover:-translate-y-2"
        :to="{
          name: 'GunView',
          params: { id: skin.skinId },
        }"

        >
        <div class="flex flex-row justify-between p-4 items-center">
            <h2 class="text-palette-100 text-3xl font-bold">
          {{ skin.pattern }}

        </h2><div class="flex" v-if="skin.stattrak">
            <img
              class="h-16"
              src="../../../../../../../../../public/images/service/StatTrak.webp"
              alt=""
            />
          </div></div>
        <h3 class="text-palette-100 text-xl px-4 font-bold opacity-60">{{ skin.name.match(/\((.*?)\)/)[1] }}</h3>
        <h3 class="text-palette-100 px-4 opacity-30">
          {{ skin.weapon }}
        </h3>
        <p class="text-sm px-4">
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

        <img :src="skin.image" alt="" class="p-4" />
        <p class="text-3xl px-4 font-bold text-center pb-2 text-emerald-400">${{ skin.skinPrices[skin.skinPrices.length-1].price }}</p>
        <div class="flex flex-row items-center justify-between gap-4">

          <div
            class="absolute p-2 text-xs rounded-2xl flex flex-col backdrop-filter
            backdrop-blur-xl group-hover:opacity-100 opacity-0 transition-all duration-300 inset-0"
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
                >{{ skin.minFloat }} / {{ skin.maxFloat }}</span
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
              <span class="opacity-70">{{ skin.paintIndex }}</span>
            </p>

          <div class="flex" v-if="skin.stattrak">
            <img
              class="h-8"
              src="../../../../public/images/service/StatTrak.webp"
              alt=""
            />
          </div>
        <p class="text-3xl text-center font-bold text-emerald-400">${{ skin.skinPrices[skin.skinPrices.length-1].price }}</p>

          </div>
        </div>
      </RouterLink><div class="cursor-pointer" @click="addSkinToFavourites">
        <svg :class="[isInFav ? 'bg-neutral-700 hover:bg-neutral-500 hover:fill-neutral-900 fill-neutral-200' :
         'bg-neutral-200 hover:bg-neutral-500 hover:fill-neutral-200']" class=" h-12 w-full p-2 shadow-xl font-black
              rounded-xl text-center hover:text-neutral-200 duration-300 text-4xl " fill="#000000" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
	 viewBox="0 0 369.486 369.486"
	 xml:space="preserve">
<g>
	<g>
		<path d="M184.743,357.351c-3.478,0-6.798-1.449-9.164-3.998l-147.67-159.16c-0.038-0.041-0.076-0.082-0.113-0.123
			C9.871,174.223,0,147.921,0,120.008c0-27.914,9.871-54.215,27.796-74.061l2.244-2.484c18.246-20.201,42.608-31.327,68.599-31.327
			s50.354,11.126,68.601,31.328l17.503,19.38l17.503-19.379c18.246-20.202,42.608-31.328,68.6-31.328s50.354,11.126,68.601,31.329
			l2.241,2.478c17.928,19.851,27.799,46.152,27.799,74.065s-9.872,54.215-27.796,74.061c-0.037,0.043-0.075,0.084-0.113,0.125
			l-147.671,159.16C191.541,355.901,188.221,357.351,184.743,357.351z M46.295,177.252l138.448,149.219l138.448-149.22
			c28.485-31.603,28.467-82.97-0.055-114.549l-2.239-2.478c-13.449-14.891-31.224-23.09-50.051-23.09
			c-18.828,0-36.603,8.199-50.048,23.085L194.02,89.869c-2.369,2.624-5.74,4.121-9.275,4.121s-6.906-1.497-9.276-4.121
			l-26.779-29.648c-13.446-14.887-31.22-23.086-50.048-23.086S62.039,45.333,48.594,60.22l-2.244,2.484
			C17.828,94.283,17.809,145.65,46.295,177.252z"/>
	</g>
</g>
</svg>
          </div></div>
</template>

<script>
export default {
    props: ['skin', 'haveInFav']
}
</script>





<script setup>
import { onMounted, ref } from 'vue';
import jsonRequest from '../../../composables/jsonrequster';
const { addToFav, haveInFav } = jsonRequest();

const props = defineProps ({
    skin: Object,
})

const addSkinToFavourites = async () => {
    const token = localStorage.getItem("userId");
    addToFav(token, props.skin.skinId);
}
const isInFav = ref(false);

const checkIsFavorite = async () => {
    isInFav.value = await haveInFav(props.skin.skinId);
}
onMounted(async()=> {
    await checkIsFavorite()
})
</script>
