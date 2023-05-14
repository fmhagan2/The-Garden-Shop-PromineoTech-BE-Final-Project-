/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import com.promineotech.gardenshop.entity.PlantDetails;

/**
 * @author fmhag
 *
 */
public interface PlantDetailsService {

  List<PlantDetails> fetchPlantDetails(String plantName);
  
  PlantDetails createPlantDetails(String comesBack, String floweringType, int amountOfSun, String hardyZone);
  
  void deletePlantDetails(int plantPK);

}
