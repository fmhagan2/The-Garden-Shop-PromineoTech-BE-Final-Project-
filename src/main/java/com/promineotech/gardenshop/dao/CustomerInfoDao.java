/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.util.List;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;

/**
 * @author fmhag
 *
 */
public interface CustomerInfoDao {

  Customer createCustomer(CustomerRequest customerRequest);
 
  void deleteCustomer(int customerPK);

  List<Customer> fetchCustomers();

}
