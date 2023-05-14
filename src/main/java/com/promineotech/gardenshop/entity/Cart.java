/**
 * 
 */
package com.promineotech.gardenshop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author fmhag
 *
 */
@Data
@Builder
public class Cart {
  private Customer customerPK;
  private Plant plantPK;
}
