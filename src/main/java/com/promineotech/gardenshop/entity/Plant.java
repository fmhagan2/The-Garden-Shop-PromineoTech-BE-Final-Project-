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
public class Plant {
  private int plantPK;
  private String plantName;
  private int plantHeight;
  private int potSize;
}
