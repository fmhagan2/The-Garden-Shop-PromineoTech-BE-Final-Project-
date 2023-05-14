/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gardenshop.dao.CustomerInfoDao;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Service
@Slf4j
public class ThisCustomerInfoService implements CustomerInfoService {
  
  @Autowired 
  private CustomerInfoDao customerInfoDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchCustomers() {
    log.info("The fetchCustomers method was called.");
    
    List<Customer> customerList = customerInfoDao.fetchCustomers();
    
    return customerList;
  }

  @Override
  public Customer createCustomer(CustomerRequest customerRequest) {
    log.info("The method createCustomer was called.");
    return customerInfoDao.createCustomer(customerRequest);
  }

  @Override
  public void deleteCustomer(int customerPK) {
    log.info("The method deleteCustomer was called using customerPK={}", customerPK);
    customerInfoDao.deleteCustomer(customerPK);
  }

}
