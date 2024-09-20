package com.customer.report.Controller;


import com.customer.report.dto.ShopDTO;
import com.customer.report.entity.Shop;
import com.customer.report.services.ShopService;
import com.customer.report.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
 
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<ShopDTO> getShops() {
        return shopService.getShops();
    }
 
    @RequestMapping(value = "/get/shops", method = RequestMethod.POST)
    public List<Shop> getShops(String location) {
        return shopService.getShops(location);
    }



}
