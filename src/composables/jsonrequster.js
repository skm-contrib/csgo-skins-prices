import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

export default function jsonRequest() {
  const skins = ref([]);
  const skin = ref();
  const skinsCount = ref();

  const getAllSkins = async (page) => {
    try {
      const response = await axios.get(
        "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins?page=" + page
      );
      console.log(response);
      skins.value = response.data;
      //return skins;
    } catch (err) {
      console.log(err);
    }
  };

  const getSkinsCount = async () => {
    try {
      const response = await axios.get(
        "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins/count"
      );
      skinsCount.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };

  const getSkinById = async (id) => {
    try {
      const response = await axios.get(
        "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins/" + id
      );
      console.log(response);
      skin.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };

  const getAllSkinsByType = async (type, page_number) => {
    if (page_number === undefined) {
      page_number = 0;
    }
    console.log(type);
    const response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins?weapon_type=" +
        type +
        "&page=" +
        page_number
    );
    skins.value = response.data;

    const count_response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins/count?weapon_type=" +
        type
    );
    skinsCount.value = count_response.data;
  };

  const getAllSkinsByWeapon = async (weapon, page_number) => {
    if (page_number === undefined) {
      page_number = 0;
    }
    const response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins?" +
        weapon +
        "&page=" +
        page_number
    );
    skins.value = response.data;

    const count_response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins/count?" +
        weapon
    );
    skinsCount.value = count_response.data;
  };

  const getSkinsByName = async (name, page_number) => {
    const response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins?search=" +
        name +
        "&page=" +
        page_number
    );
    skins.value = response.data;

    const count_response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/skins/count?search=" +
        name
    );
    skinsCount.value = count_response.data;
  };

  const addToFav = async (user_id, skin_id) => {
    console.log(user_id);
    console.log(skin_id);
    const response = await axios.post(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/favorites/" +
        user_id +
        "/" +
        skin_id
    );
    console.log(response.data);
  };

  const haveInFav = async (skin_id) => {
    let userId = localStorage.getItem("userId");
    const response = await axios.get(
      "https://cagoskins-ed80d8718043.herokuapp.com/api/v1/favorites/" +
        userId +
        "/" +
        skin_id
    );
    return response.data;
  };

  return {
    skin,
    skins,
    skinsCount,
    getSkinsCount,
    haveInFav,
    addToFav,
    getAllSkins,
    getSkinsByName,
    getSkinById,
    getAllSkinsByType,
    getAllSkinsByWeapon,
  };
}
