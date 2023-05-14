/**
 * 
 */
package com.promineotech.gardenshop.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

/**
 * @author fmhag
 *
 */
@Data
public class CustomerRequest {
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String firstName;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String lastName;
 
  @NotNull
  @Length(max = 120)
  @Pattern(regexp = "[\\w\\s]*")
  private String address;
  
  @NotNull
  @Length(max = 30)
  @Pattern(regexp = "[\\w\\s]*")
  private String payment; 
  
  private List<@NotNull @Pattern(regexp = "[\\w\\s]*") String> cart;

}
