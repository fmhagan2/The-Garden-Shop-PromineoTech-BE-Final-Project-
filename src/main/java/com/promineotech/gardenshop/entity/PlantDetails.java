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
public class PlantDetails {
  private int plantPK;
  private String comesBack;
  private String floweringType;
  private int amountOfSun;
  private String hardyZone;

}
