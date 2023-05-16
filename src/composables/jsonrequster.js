import { ref } from "vue"
import axios from 'axios'
import { useRouter } from "vue-router"

export default function jsonRequest() {
    const skins = ref([]);
    const prices = ref ([]);
    var header = "Access-Control-Allow-Origin: *"

    const getAllSkins = async () => {
        const response = await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        skins.value = response.data;
        return skins
    };
    const getAllSkinsByType = async (type) => {
        const response =
        await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        //
        const data = response.data;
        console.log(type)
        const filteredObjects = data.filter(obj => obj.weapon === type);
        skins.value = filteredObjects;
        return skins
    };

    const getSkinPrice = async () => {
        const response = await axios.get("https://loot.farm/fullprice.json",
        {headers: {header}});
        prices.value = response.data;

        const filteredObjects = response.filter(obj => obj.name === 'Blaze');
        console.log(filteredObjects);

        return prices
    };

    return {
        skins,
        prices,
        getAllSkins,
        getSkinPrice,
        getAllSkinsByType
    }
}
