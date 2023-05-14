/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.time.LocalDate;
import java.util.List;
import com.promineotech.gardenshop.entity.LogRequest;
import com.promineotech.gardenshop.entity.PlantLog;

/**
 * @author fmhag
 *
 */
public interface PlantLogService {

  List<PlantLog> fetchPlantLog(String plantName);
  PlantLog createLog(LogRequest logRequest);
  void updateLog(String plantName, LocalDate plantedDate);
  void deleteLog(String plantName);

}
