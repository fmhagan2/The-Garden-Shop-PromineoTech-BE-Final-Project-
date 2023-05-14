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
import com.promineotech.gardenshop.entity.PlantDetails;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Component
@Slf4j
public class ThisPlantDetailsDao implements PlantDetailsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<PlantDetails> fetchPlantDetails(String plantName) {
    log.debug("DAO: plantName={}", plantName);
    
    // @formatter:off
       String sql = ""
           + "SELECT * "
           + "FROM plant_details "
           + "WHERE plant_name = :plant_name";
    // @formatter:on  
       
    Map<String, Object> params = new HashMap<>();
    params.put("plant_name", plantName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public PlantDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
        return PlantDetails.builder()
            .plantPK(rs.getInt("plant_pk"))
            .comesBack(rs.getString("comes_back"))
            .floweringType(rs.getString("flowering_type"))
            .amountOfSun(rs.getInt("amount_of_sun"))
            .hardyZone(rs.getString("hardy_zone"))
            .build();
        // @formatter:on
      }
      
    });
       
  }

}
