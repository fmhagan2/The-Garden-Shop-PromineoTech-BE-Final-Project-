/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gardenshop.entity.Plant;
import com.promineotech.gardenshop.service.BrowsePlantsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@RestController
@Slf4j
public class ThisBrowsePlantsController implements BrowsePlantsController {
  @Autowired
  private BrowsePlantsService browsePlantsService;
  
  @Override
  public List<Plant> fetchPlants(String plantName) {
    log.debug("plantName={}", plantName);
    return browsePlantsService.fetchPlants(plantName);
  }

}
