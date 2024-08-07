const API_BASE_URL = "http://localhost:8085";

const API_ENDPOINTS = {
  LOGIN: `${API_BASE_URL}/Users/login`,
  GET_CUSTOMERS: `${API_BASE_URL}/Customers/get/Customers`,
  GET_ALL_SHOP_ITEMS: `${API_BASE_URL}/shop/get/all`,
};

export default API_ENDPOINTS;