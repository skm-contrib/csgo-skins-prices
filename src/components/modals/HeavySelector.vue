<template>
  <p class="m-2">Shotguns</p>
  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=MAG-7' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/shotguns/CSGO_MAG-7_Inventory.webp"
      alt=""
    />
    <p class="text-lg">MAG-7</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Nova' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/shotguns/CSGO_Nova_Inventory.webp"
      alt=""
    />
    <p class="text-lg">Nova</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Sawed-Off' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/shotguns/CSGO_Sawed-Off_Inventory.webp"
      alt=""
    />
    <p class="text-lg">Sawed-Off</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=XM1014' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/shotguns/CSGO_XM1014_Inventory.webp"
      alt=""
    />
    <p class="text-lg">XM1014</p></RouterLink
  >
  <p class="m-2">Machine Guns</p>

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=M249' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/machineguns/CSGO_M249_Inventory.webp"
      alt=""
    />
    <p class="text-lg">M249</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'TypeView', params: { name: 'weapon=Negev' } }"
    class="link flex flex-row items-center gap-4 px-4"
    ><img
      class="h-12"
      src="../../../public/images/guns/heavy/machineguns/CSGO_Negev_Inventory.webp"
      alt=""
    />
    <p class="text-lg">Negev</p></RouterLink
  >
</template>
