package com.customer.report.Controller;


import com.customer.report.services.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/trans")
public class TransController {
    @Autowired
    private TranService tranService;

//    @PostMapping("/get/transByShopId")
//    public List<Tran> getTrans(@RequestParam int shopId) {
//        System.out.println(shopId);
//        return tranService.getTransByShopId(shopId);
//    }
//
//
//    @PostMapping("/get/transByDateRange")
//    public List<Tran> getTransByDateRange(@RequestBody DateRangeDTO dateRangeDTO) {
//        return tranService.findTransactionsByDateRange(dateRangeDTO.getStartDate(), dateRangeDTO.getEndDate());
//    }



}