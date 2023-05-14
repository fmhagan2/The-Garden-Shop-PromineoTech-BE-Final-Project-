/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;
import com.promineotech.gardenshop.service.CustomerInfoService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@RestController
@Slf4j
public class ThisCustomerInfoController implements CustomerInfoController {

  @Autowired
  private CustomerInfoService customerInfoService;
  
  @Override
  public List<Customer> fetchCustomers() {
    return customerInfoService.fetchCustomers();
  }

  @Override
  public Customer createCustomer(CustomerRequest customerRequest) {
    return customerInfoService.createCustomer(customerRequest);
  }

}
