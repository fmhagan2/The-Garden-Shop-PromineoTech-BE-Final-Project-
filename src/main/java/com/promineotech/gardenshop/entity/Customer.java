/**
 * 
 */
package com.promineotech.gardenshop.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author fmhag
 *
 */
@Data
@Builder
public class Customer {
  
  private int customerPK;
  private String firstName;
  private String lastName;
  private String address;
  private String payment;
  private List<Plant> cart;
}
