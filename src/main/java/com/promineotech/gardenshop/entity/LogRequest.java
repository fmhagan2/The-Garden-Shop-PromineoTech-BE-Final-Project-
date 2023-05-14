/**
 * 
 */
package com.promineotech.gardenshop.entity;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

/**
 * @author fmhag
 *
 */
@Data
public class LogRequest {
  
  @NotNull@NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String plantName;
  
  @NotNull
  private LocalDate plantedDate;
  
  private LocalDate sproutedDate;
  
  private LocalDate prunedDate;
  
}
