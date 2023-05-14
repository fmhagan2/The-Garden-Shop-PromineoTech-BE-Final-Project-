/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.gardenshop.entity.Plant;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Component
@Slf4j
public class ThisBrowsePlantsDao implements BrowsePlantsDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Plant> fetchPlants(String plantName) {
    log.debug("DAO: plantName={}", plantName);
    
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM plants ";
    
    Map<String, Object> params = new HashMap<>();
    params.put("plant_name", plantName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Plant mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return Plant.builder()
            .plantPK(rs.getInt("plant_pk"))
            .plantName(rs.getString("plant_name"))
            .plantHeight(rs.getInt("plant_height"))
            .potSize(rs.getInt("pot_size"))
            .build();
        // @formatter:on
      }     
    });
 
  }
  
  
}
