<template>
  <p class="m-2">Assault</p>

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=AK-47' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_AK-47_Inventory.webp"
      alt=""
    />
    <p class="text-lg">AK-47</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=AUG' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_AUG_Inventory.webp"
      alt=""
    />
    <p class="text-lg">AUG</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=FAMAS' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_FAMAS_Inventory.webp"
      alt=""
    />
    <p class="text-lg">FAMAS</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Galil AR' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_Galil_AR_Inventory.webp"
      alt=""
    />
    <p class="text-lg">Galil AR</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=M4A1-S' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_M4A1-S_Inventory.webp"
      alt=""
    />
    <p class="text-lg">M4A1-S</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=M4A4' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_M4A4_Inventory.webp"
      alt=""
    />
    <p class="text-lg">M4A4</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=SG 553' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/assault/CSGO_SG_553_Inventory.webp"
      alt=""
    />
    <p class="text-lg">SG 553</p></RouterLink
  >
  <p class="m-2">Sniper</p>
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=AWP' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/sniper/CSGO_AWP_Inventory.webp"
      alt=""
    />
    <p class="text-lg">AWP</p></RouterLink
  >
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=G3SG1' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/sniper/CSGO_G3SG1_Inventory.webp"
      alt=""
    />
    <p class="text-lg">G3SG1</p></RouterLink
  >
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=SCAR-20' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/sniper/CSGO_SCAR-20_Inventory.webp"
      alt=""
    />
    <p class="text-lg">SCAR-20</p></RouterLink
  >
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=SSG 08' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../../../../../../../public/images/guns/rifles/sniper/CSGO_SSG_08_Inventory.webp"
      alt=""
    />
    <p class="text-lg">SSG 08</p></RouterLink
  >
</template>
