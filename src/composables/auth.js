import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

export default function jsonRequest() {
  const router = useRouter();

  const user = ref([]);
  const users = ref();
  const errors = ref([]);

  const loginUser = async (data) => {
    try {
      const response = await axios.post(
        "http://localhost:9000/api/v1/auth/login",
        data
      );
      user.value = response.data;
      console.log(response.data);
      localStorage.setItem("userId", user.value.id);
      router.push({ name: "Profile" });
    } catch (err) {
      console.log(err);
      errors.value = err.response.data;
    }
  };

  const isAdmin = async () => {
    await getUser();
    if (user.value.role != "ROLE_ADMIN") {
      router.push({ name: "Profile" });
    }
  };

  const logOut = async () => {
    localStorage.clear();
    router.push({ name: "Login" });
  };
  const registerUser = async (data) => {
    try {
      const response = await axios.post(
        "http://localhost:9000/api/v1/auth/signup",
        data
      );
      user.value = response.data;
      localStorage.setItem("userId", user.value.id);
      router.push({ name: "Profile" });
    } catch (err) {
      console.log(err);
      errors.value = err.response.data;
    }
  };

  const userLogged = async () => {
    if ("userId" in localStorage) {
      const token = localStorage.getItem("userId");
      console.log(token);
      router.push({ name: "Profile" });
    } else {
      router.push({ name: "Login" });
    }
  };

  const editUser = async (user) => {
    try {
      const response = await axios.put(
        "http://localhost:9000/api/v1/users/" + user.id,
        user
      );
      router.go();
    } catch (err) {
      console.log(err);
      errors.value = err.response.data;
    }
  };

  const deleteAccount = async (id) => {
    if (!window.confirm("Видалити акаунт?")) {
      return;
    }
    try {
      const response = await axios.delete(
        "http://localhost:9000/api/v1/users/" + id
      );
      localStorage.clear();
      router.push({ name: "Register" });
    } catch (err) {
      console.log(err);
      errors.value = err.response.data;
    }
  };

  const getUser = async () => {
    try {
      let userId = localStorage.getItem("userId");
      const response = await axios.get(
        "http://localhost:9000/api/v1/users/" + userId
      );
      user.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };
  const getUserById = async (id) => {
    try {
      const response = await axios.get(
        "http://localhost:9000/api/v1/users/" + id
      );
      user.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };

  const getUsers = async () => {
    try {
      const response = await axios.get("http://localhost:9000/api/v1/users");
      users.value = response.data;
    } catch (err) {
      console.log(err);
    }
  };

  return {
    user,
    users,
    errors,
    getUsers,
    editUser,
    isAdmin,
    getUserById,
    deleteAccount,
    getUser,
    logOut,
    loginUser,
    userLogged,
    registerUser,
  };
}
