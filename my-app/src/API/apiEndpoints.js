const API_BASE_URL = "https://api.nstyleintl.com/customer-staging";
// const API_BASE_URL = "http://localhost:8005";

// GET_SHOPS_TRANS_DATA: `${API_BASE_URL}/Customers/get/Customers/byShop`,
const API_ENDPOINTS = {
  LOGIN: `${API_BASE_URL}/Users/login`,
  GET_ALL_SHOP_ITEMS: `${API_BASE_URL}/shop/get/all`,
  // Customer Trans Data
  GET_SHOPS_TRANS_PAGE_DATA: `${API_BASE_URL}/Customers/get/`,
  GET_SHOPS_TRANS_AFTER_FROM: `${API_BASE_URL}/Customers/get/afterTime`,
  
  
  // Exports
  EXPORT_BEFORE_FROM: `${API_BASE_URL}/Customers/export/beforeTime`,
  EXPORT_AFTER_FROM: `${API_BASE_URL}/Customers/export/afterTime`,
};

export default API_ENDPOINTS;