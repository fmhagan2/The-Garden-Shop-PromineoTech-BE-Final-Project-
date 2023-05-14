/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Component
@Slf4j
public class ThisCustomerInfoDao implements CustomerInfoDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Customer> fetchCustomers() {
    log.debug("DAO: customers");
    
    // @formatter:off
       String sql = ""
           + "SELECT * "
           + "FROM customers ";
       
       Map<String, Object> params = new HashMap<>();
     //  params.put("first_name", firstName);
     //  params.put("lastName", lastName);
       
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Customer.builder()
            .customerPK(rs.getInt("customer_pk"))
            .firstName(rs.getString("first_name"))
            .lastName(rs.getString("last_name"))
            .address(rs.getString("address"))
            .payment(rs.getString("payment"))
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public Customer createCustomer(CustomerRequest customerRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteCustomer(int customerPK) {
    // TODO Auto-generated method stub
    
  }

}
