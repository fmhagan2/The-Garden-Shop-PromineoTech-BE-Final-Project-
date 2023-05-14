/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gardenshop.dao.BrowsePlantsDao;
import com.promineotech.gardenshop.entity.Plant;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Service
@Slf4j
public class ThisBrowsePlantsService implements BrowsePlantsService {
  @Autowired
  private BrowsePlantsDao browsePlantsDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Plant> fetchPlants(String plantName) {
    log.info("The fetchPlant method was called with plantName={}", plantName);
    
    List<Plant> plants = browsePlantsDao.fetchPlants(plantName);
    
    if(plants.isEmpty()) {
      String msg = String.format("No plants found with plantName = %s", plantName);
      throw new NoSuchElementException(msg);
    }
        
    return plants;
  }

}
