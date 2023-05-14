/**
 * 
 */
package com.promineotech.gardenshop.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

/**
 * @author fmhag
 *
 */
@Data
@Builder
public class PlantLog {
  private Long logPK;
  private int plantPK;
  private LocalDate plantedDate;
  private LocalDate sproutedDate;
  private LocalDate prunedDate;
  
  @JsonIgnore
  public Long getLogPK() {
    return logPK;
  }

}
