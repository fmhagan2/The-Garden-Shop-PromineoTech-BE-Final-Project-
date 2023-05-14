/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.gardenshop.entity.LogRequest;
import com.promineotech.gardenshop.entity.PlantLog;
import com.promineotech.gardenshop.service.PlantLogService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@RestController
@Slf4j
public class ThisPlantLogController implements PlantLogController {
  
  @Autowired
  private PlantLogService plantLogService;
  
  @Override
  public List<PlantLog> fetchPlantLog(String plantName) {
    log.debug("plantName={}", plantName);
    return plantLogService.fetchPlantLog(plantName);
  }
  
  @Override
  public PlantLog createLog(LogRequest logRequest) {
    log.info("LogRequest={}", logRequest);
    return plantLogService.createLog(logRequest);
  }

  @Override
  public void updateLog(String plantName, LocalDate plantedDate) {
    log.info("plantName={}, plantedDate={}", plantName, plantedDate);
    plantLogService.updateLog(plantName, plantedDate);
  }

  @Override
  public void deleteLog(String plantName) {
    log.info("plantName={}", plantName);
    plantLogService.deleteLog(plantName);
  }

}
