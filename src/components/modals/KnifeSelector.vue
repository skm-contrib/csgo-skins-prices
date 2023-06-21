<template>
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Bayonet' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-bayonet-stock.webp"
      alt=""
    />
    <p class="text-lg">Bayonet</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Bowie Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-weapon_knife_survival_bowie.webp"
      alt=""
    />
    <p class="text-lg">Bowie Knife</p></RouterLink
  >

  <RouterLink
    :to="{
      name: 'Weapon',
      params: { type: 'knifes', name: 'weapon=Butterfly Knife' },
    }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-butterfly-stock-market.webp"
      alt=""
    />
    <p class="text-lg">Butterfly Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Classic Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_css_inventory.webp"
      alt=""
    />
    <p class="text-lg">Classic Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Falchion Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-falchion-knife-market.webp"
      alt=""
    />
    <p class="text-lg">Falchion Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Flip Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-flip-stock.webp"
      alt=""
    />
    <p class="text-lg">Flip Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Gut Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-gut-stock.webp"
      alt=""
    />
    <p class="text-lg">Gut Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Huntsman Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-huntsman-stock.webp"
      alt=""
    />
    <p class="text-lg">Huntsman Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Karambit' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="@/images/guns/knifes/Csgo-knife-karambit-stock.webp"
      alt=""
    />
    <p class="text-lg">Karambit</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=M9 Bayonet' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-m9-bayonet-stock.webp"
      alt=""
    />
    <p class="text-lg">M9 Bayonet</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Navaja Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_gypsy_jackknife.webp"
      alt=""
    />
    <p class="text-lg">Navaja Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Nomad Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_outdoor.fdb3ce5ceef1584781759ef5a7bd6f819bf12e9b.webp"
      alt=""
    />
    <p class="text-lg">Nomad Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Paracord Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Paracord_knife.webp"
      alt=""
    />
    <p class="text-lg">Paracord Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Shadow Daggers' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Csgo-knife-shadow-daggers-stock.webp"
      alt=""
    />
    <p class="text-lg">Shadow Daggers</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Skeleton Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_skeleton.webp"
      alt=""
    />
    <p class="text-lg">Skeleton Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Stiletto Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_stiletto.webp"
      alt=""
    />
    <p class="text-lg">Stiletto Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Survival Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Survival_Knife.webp"
      alt=""
    />
    <p class="text-lg">Survival Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Talon Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_widowmaker.webp"
      alt=""
    />
    <p class="text-lg">Talon Knife</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Ursus Knife' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/knifes/Weapon_knife_ursus.webp"
      alt=""
    />
    <p class="text-lg">Ursus Knife</p></RouterLink
  >
</template>
