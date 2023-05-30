<template>
  <RouterLink
    :to="{ name: 'Profile' }"
    class="link flex flex-row items-center gap-4 px-4"
  >
    <p class="text-lg">Профіль</p></RouterLink
  >

  <RouterLink
    :to="{ name: 'Weapon', params: { type: 'heavy', name: 'Nova' } }"
    class="link flex flex-row items-center gap-4 px-4"
  >
    <p class="text-lg">Вподобані</p></RouterLink
  >
</template>
