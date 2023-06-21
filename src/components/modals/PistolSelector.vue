<template>
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=CZ75-Auto' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_CZ75-Auto_Inventory.webp"
      alt=""
    />CZ75-Auto</RouterLink
  >

  <RouterLink
    :to="{
      name: 'TypeView',
      params: { name: 'weapon=Desert Eagle' },
    }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_Desert_Eagle_Inventory.webp"
      alt=""
    />Desert Eagle</RouterLink
  >

  <RouterLink
    :to="{
      name: 'TypeView',
      params: { name: 'weapon=Dual Berettas' },
    }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_Dual_Berettas_Inventory.webp"
      alt=""
    />Dual Berettas</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Five-SeveN' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_Five-SeveN_Inventory.webp"
      alt=""
    />Five-SeveN</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Glock-18' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_Glock-18_Inventory.webp"
      alt=""
    />Glock-18</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=P2000' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_P2000_Inventory.webp"
      alt=""
    />P2000</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=P250' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_P250_Inventory.webp"
      alt=""
    />P250</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=R8 Revolver' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_R8_Revolver_Inventory.webp"
      alt=""
    />R8 Revolver</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Tec-9' } }"
    class="link flex flex-row items-center gap-4 px-4"
  >
    <img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_Tec-9_Inventory.webp"
      alt=""
    />Tec-9</RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=USP-S' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/pistols/CSGO_USP-S_Inventory.webp"
      alt=""
    />USP-S</RouterLink
  >
</template>
