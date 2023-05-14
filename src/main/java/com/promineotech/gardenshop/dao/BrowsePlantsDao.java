/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.util.List;
import com.promineotech.gardenshop.entity.Plant;

/**
 * @author fmhag
 *
 */
public interface BrowsePlantsDao {

  /**
   * @param plantName
   * @param type
   * @return
   */
  List<Plant> fetchPlants(String plantName);

}
