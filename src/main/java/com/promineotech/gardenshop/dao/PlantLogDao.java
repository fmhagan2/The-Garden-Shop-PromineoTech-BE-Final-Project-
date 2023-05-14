/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.time.LocalDate;
import java.util.List;
import com.promineotech.gardenshop.entity.PlantLog;

/**
 * @author fmhag
 *
 */
public interface PlantLogDao {

  List<PlantLog> fetchPlantLog(String plantName);

  void updateLog(String plantName, LocalDate plantedDate);

  void deleteLog(String plantName);

  PlantLog saveLog(String plantName, LocalDate plantedDate, LocalDate sproutedDate,
      LocalDate prunedDate);
  String fetchPlantName(String plantName);
  int fetchPlantFK(String plantName);
  LocalDate fetchPlantedDate(LocalDate plantedDate);
  LocalDate fetchSproutedDate(LocalDate sproutedDate);
  LocalDate fetchPrunedDate(LocalDate prunedDate);

  

}
