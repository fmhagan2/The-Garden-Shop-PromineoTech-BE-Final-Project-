/**
 * 
 */
package com.promineotech.gardenshop.service;

import java.util.List;
import com.promineotech.gardenshop.entity.Plant;

/**
 * @author fmhag
 *
 */
public interface BrowsePlantsService {

  List<Plant> fetchPlants(String plantName);

}
