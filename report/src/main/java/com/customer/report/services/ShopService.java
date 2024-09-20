package com.customer.report.services;

import com.customer.report.dto.ShopDTO;
import com.customer.report.entity.Shop;
import com.customer.report.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    @Autowired
    private ShopRepository shopRepository;


    public List<ShopDTO> getShops(){
        List<Shop> shops = shopRepository.findAll();
        List< ShopDTO > shopDTOs = new ArrayList<>();
        for (Shop shop : shops) {
            shopDTOs.add(new ShopDTO(shop));
        }
        return shopDTOs;
    }

    public Shop getShopByName(String name){
        return shopRepository.findByName(name);
    }

    public List<Shop> getShops(String location){
        return shopRepository.findByLocationStartingWith(location);
    }
}
