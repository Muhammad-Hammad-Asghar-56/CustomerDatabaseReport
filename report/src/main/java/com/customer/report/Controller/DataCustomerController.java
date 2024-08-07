package com.customer.report.Controller;


import com.customer.report.dto.CustomerShopDTO;
import com.customer.report.dto.DateRangeDTO;
import com.customer.report.dto.VisitDTO;
import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.Tran;
import com.customer.report.services.DataCustomerService;
import com.customer.report.services.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Customers")
public class DataCustomerController {
@Autowired
    private DataCustomerService dataCustomerService;

    @PostMapping("/get/Customers")
    public List<CustomerShopDTO> getCustomerNotShowedInTrans(@RequestBody DateRangeDTO date) {
        return dataCustomerService.getNoShowedCustomers(date.getStartDate(), date.getEndDate());
    }
}
