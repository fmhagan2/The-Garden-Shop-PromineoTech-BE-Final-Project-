/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;

/**
 * @author fmhag
 *
 */
public interface CustomerInfoService {
  
  List<Customer> fetchCustomers();
  
  void deleteCustomer(int customerPK);
  
  Customer createCustomer(CustomerRequest customerRequest);

}
