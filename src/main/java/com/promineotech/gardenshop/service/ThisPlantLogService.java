/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.gardenshop.dao.PlantLogDao;
import com.promineotech.gardenshop.entity.LogRequest;
import com.promineotech.gardenshop.entity.PlantLog;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Service
@Slf4j
public class ThisPlantLogService implements PlantLogService {
  
  @Autowired
  private PlantLogDao plantLogDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<PlantLog> fetchPlantLog(String plantName) {
    log.info("The fetchPlantLog method was called using plantName={}", plantName);
    
    List<PlantLog> plantLog = plantLogDao.fetchPlantLog(plantName);
    
    if (plantLog.isEmpty()) {
      String message = String.format("No maintenance log was found for plantName=%s", plantName);
      throw new NoSuchElementException(message);
    }

    return plantLog;
  }

  @Transactional
  @Override
  public PlantLog createLog(LogRequest logRequest) {
    String plantName = getPlantName(logRequest);
    LocalDate plantedDate = getPlantedDate(logRequest);
    LocalDate sproutedDate = getSproutedDate(logRequest);
    LocalDate prunedDate = getPrunedDate(logRequest);
    
    return plantLogDao.saveLog(plantName, plantedDate, sproutedDate, prunedDate);
  }

  private LocalDate getPrunedDate(LogRequest logRequest) {
    return plantLogDao.fetchPrunedDate(logRequest.getPrunedDate());
  }

  private LocalDate getSproutedDate(LogRequest logRequest) {
    return plantLogDao.fetchSproutedDate(logRequest.getSproutedDate());
  }

  private LocalDate getPlantedDate(LogRequest logRequest) {
    return plantLogDao.fetchPlantedDate(logRequest.getPlantedDate());
  }

  private String getPlantName(LogRequest logRequest) {
    return plantLogDao.fetchPlantName(logRequest.getPlantName())
        //.orElseThrow(() -> new NoSuchElementException(
        //"No plant found with the name " + logRequest.getPlantName))
        ;
  }

  @Override
  public void updateLog(String plantName, LocalDate plantedDate) {
    log.info("The updateLog method was called using plantName={} and plantedDate={}", plantName, plantedDate);
    plantLogDao.updateLog(plantName, plantedDate);
  }

  @Override
  public void deleteLog(String plantName) {
    log.info("The deleteLog method was called using plantName={}", plantName);
    plantLogDao.deleteLog(plantName);
  }

}
