/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.gardenshop.dao.PlantDetailsDao;
import com.promineotech.gardenshop.entity.PlantDetails;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Service
@Slf4j
public class ThisPlantDetailsService implements PlantDetailsService {

  @Autowired
  private PlantDetailsDao plantDetailsDao;
  
  @Override
  public List<PlantDetails> fetchPlantDetails(String plantName) {
    log.info("The fetchPlantDetails method was called using plantName={}", plantName);
    
    List<PlantDetails> plantDetailsList = plantDetailsDao.fetchPlantDetails(plantName);
   
    return plantDetailsList;
  }

  @Override
  public PlantDetails createPlantDetails(String comesBack, String floweringType, int amountOfSun,
      String hardyZone) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deletePlantDetails(int plantPK) {
    // TODO Auto-generated method stub
    
  }

}
