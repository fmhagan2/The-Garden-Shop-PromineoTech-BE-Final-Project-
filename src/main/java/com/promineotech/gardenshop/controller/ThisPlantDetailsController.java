/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gardenshop.entity.PlantDetails;
import com.promineotech.gardenshop.service.PlantDetailsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@RestController
@Slf4j
public class ThisPlantDetailsController implements PlantDetailsController {

  @Autowired
  private PlantDetailsService plantDetailsService;
  
  @Override
  public List<PlantDetails> fetchPlantDetails(String plantName) {
    return plantDetailsService.fetchPlantDetails(plantName);
  }

}
