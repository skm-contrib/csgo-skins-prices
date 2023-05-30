import { ref } from "vue"
import axios from 'axios'
import { useRouter } from "vue-router"

export default function jsonRequest() {
    const skins = ref([]);
    const skin = ref();

    const getAllSkins = async () => {
        const response = await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        skins.value = response.data;
        return skins
    };
    const getAllSkinsByType = async (type) => {

        const response =
        await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        const data = response.data;
        const filteredObjects = ref([]);
        console.log(type)
        for(var i = 0; i > type.length; i++)
        {
            console.log('asd')
        }

        type.forEach(gunName => {
            filteredObjects.value.push(data.filter(obj => obj.weapon === gunName.name))
        });

        skins.value = filteredObjects.value[0];
        return skins
    };

    const getAllSkinsByName = async (name) => {
        const response =
        await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        const data = response.data;

        const filteredObjects = data.filter(obj => obj.weapon === name);
        console.log(filteredObjects)

        skins.value = filteredObjects;
        return skins
    };

    const getSkinByName = async (name) => {
        const response =
        await axios.get("https://bymykel.github.io/CSGO-API/api/en/skins.json");
        //
        const data = response.data;

        const filteredObjects = data.filter(obj => obj.name === name);

        skin.value = filteredObjects[0];
        return skin
    };

    return {
        skin,
        skins,
        getAllSkins,
        getSkinByName,
        getAllSkinsByName,
        getAllSkinsByType
    }
}
