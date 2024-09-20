package com.customer.report.Controller;


import com.customer.report.dto.CustomerShopDTO;
import com.customer.report.dto.FilterDTO;
import com.customer.report.services.DataCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Customers")
public class DataCustomerController {
    @Autowired
    private DataCustomerService dataCustomerService;

    @RequestMapping(value = "/get/", method = RequestMethod.POST)
    public Map<String,Object> getCustomerNotShowedInTrans(@RequestBody FilterDTO dto, @RequestHeader("page") int page) throws Exception {
        try{
            return dataCustomerService.getCustomerNotShowed(dto,page);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @RequestMapping(value = "/get/afterTime", method = RequestMethod.POST)
    public Map<String,Object> getCustomerNotShowedInTransAfterTime(@RequestBody FilterDTO dto, @RequestHeader("page") int page) throws Exception {
        try{
            return dataCustomerService.getCustomerNotShowedAfterFrom(dto,page);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value = "/export/beforeTime", method = RequestMethod.POST)
    public List<CustomerShopDTO> exportData(@RequestBody FilterDTO dto) throws Exception {
        try{
            return dataCustomerService.getCustomerNotShowedBefore(dto);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    @RequestMapping(value = "/export/afterTime", method = RequestMethod.POST)
    public List<CustomerShopDTO> exportDataAfterTime(@RequestBody FilterDTO dto) throws Exception {
        try{
            return dataCustomerService.getCustomerNotShowedAfterDate(dto);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value = "/get/byShop", method = RequestMethod.POST)
    public List<CustomerShopDTO> getCustomerNotShowedInTrans(@RequestHeader("shopName") String shopName) throws Exception {
        return dataCustomerService.getCustomerNotShowed(shopName);
    }
}