import axios from 'axios';
import api from "./apiEndpoints.js";

const getAllShops = async() =>{
  try {
    const response = await axios.get(api.GET_ALL_SHOP_ITEMS);
    return response.data;
  } catch (error) {
    console.error('Error fetching shops:', error);
    throw error;
  }
}

const getTrans = async (shopName, before_from_Date, location, pageNum) => {
  try {
    const config = {
      headers: {
        'page': pageNum // Make sure the backend accepts pagination in headers
      },
    };
    const body = {
      shopName: shopName  ? shopName:"All Shops",
      before_from_Date: before_from_Date,
      location: location
    };
    
    const response = await axios.post(api.GET_SHOPS_TRANS_PAGE_DATA, body, config);
    return response.data;
  } catch (error) {
    if (error.response) {
      console.error("Server responded with an error:", error.response.status, error.response.data);
    } else if (error.request) {
      console.error("No response received from server:", error.request);
    } else {
      console.error("Error setting up request:", error.message);
    }
    throw error;
  }
};

const getAfterTrans = async (shopName, after_from_Date, location, pageNum) => {
  try {
    const config = {
      headers: {
        'page': pageNum // Make sure the backend accepts pagination in headers
      },
    };
    const body = {
      shopName: shopName  ? shopName:"All Shops",
      after_from_Date: after_from_Date,
      location: location
    };
    
    const response = await axios.post(api.GET_SHOPS_TRANS_AFTER_FROM, body, config);
    return response.data;
  } catch (error) {
    if (error.response) {
      console.error("Server responded with an error:", error.response.status, error.response.data);
    } else if (error.request) {
      console.error("No response received from server:", error.request);
    } else {
      console.error("Error setting up request:", error.message);
    }
    throw error;
  }
};


const exportBefore = async(shopName, after_from_Date,location)=>{
  try {
    const body = {
      shopName: shopName  ? shopName:"All Shops",
      before_from_Date: after_from_Date,
      location: location
    };
    
    const response = await axios.post(api.EXPORT_BEFORE_FROM, body);
    return response.data;
  } catch (error) {
    if (error.response) {
      console.error("Server responded with an error:", error.response.status, error.response.data);
    } else if (error.request) {
      console.error("No response received from server:", error.request);
    } else {
      console.error("Error setting up request:", error.message);
    }
    throw error;
  }
};
const exportAfter=async(shopName,after_from_Date,location)=>{
  try {
    debugger;
    const body = {
      shopName: shopName  ? shopName:"All Shops",
      after_from_Date: after_from_Date,
      location: location
    };
    
    const response = await axios.post(api.EXPORT_AFTER_FROM, body);
    return response.data;
  } catch (error) {
    if (error.response) {
      console.error("Server responded with an error:", error.response.status, error.response.data);
    } else if (error.request) {
      console.error("No response received from server:", error.request);
    } else {
      console.error("Error setting up request:", error.message);
    }
    throw error;
  }
};
export { getTrans, getAllShops,getAfterTrans,exportBefore,exportAfter}