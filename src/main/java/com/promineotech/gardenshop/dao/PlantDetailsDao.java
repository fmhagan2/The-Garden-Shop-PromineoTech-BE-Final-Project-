/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.util.List;
import com.promineotech.gardenshop.entity.PlantDetails;

/**
 * @author fmhag
 *
 */
public interface PlantDetailsDao {

  /**
   * @param plantName
   * @return
   */
  List<PlantDetails> fetchPlantDetails(String plantName);

}
