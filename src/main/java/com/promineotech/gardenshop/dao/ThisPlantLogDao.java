/**
 * 
 */
package com.promineotech.gardenshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.Plant;
import com.promineotech.gardenshop.entity.PlantLog;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fmhag
 *
 */
@Slf4j
@Component
public class ThisPlantLogDao implements PlantLogDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  private SqlParams generateInsertSql(Plant plant, Customer customer) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO cart ("
        + "plant_fk, customer_fk" 
        + ") VALUES (" 
        + ":plant_fk, customer_fk"
        + ")";
    // @formatter:on
    
    params.source.addValue("plant_fk", plant.getPlantPK());
    params.source.addValue("customer_fk", customer.getCustomerPK());
    
    return params;
  }
  
  private SqlParams generateInsertSql(int plantFK, LocalDate plantedDate,
      LocalDate sproutedDate, LocalDate prunedDate) {
    
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT INTO plant_log ("
        + "plant_fk, planted_date, sprouted_date, pruned_date"
        + ") VALUES ("
        + ":plant_fk, :planted_date, :sprouted_date, :pruned_date"
        + ")";
        
    // @formatter:on
    
    params.source.addValue("plant_fk", plantFK);
    params.source.addValue("planted_date", plantedDate);
    params.source.addValue("sprouted_date", sproutedDate);
    params.source.addValue("pruned_date", prunedDate);
    
    return params;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
///////////////////////////////////////////////////////////////////////////////////////////////////////////  
  @Override
  public List<PlantLog> fetchPlantLog(String plantName) {
    log.debug("DAO: fetchPlantLog plantName={}", plantName);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM plant_log "
        + "INNER JOIN plants "
        + "ON plants.plant_pk = plant_log.plant_fk "
        + "WHERE plant_name = :plant_name";
   // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("plant_fk", plantName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public PlantLog mapRow(ResultSet rs, int numRow) throws SQLException {
        // @formatter:off
        return PlantLog.builder()
            .plantPK(rs.getInt("plant_pk"))
            .plantedDate(rs.getDate("planted_date").toLocalDate())
            .sproutedDate(rs.getDate("sprouted_date").toLocalDate())
            .prunedDate(rs.getDate("pruned_date").toLocalDate())
            .build();
        // @formatter:on
      }
    });
  }

  @Override
  public void updateLog(String plantName, LocalDate plantedDate) {
    
  }

  @Override
  public void deleteLog(String plantName) {
    
    // formatter:off
    String sql = ""
        + "DELETE plant_log "
        + "WHERE plant_name = :plant_name";
    // formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("plant_name", plantName);
    
    jdbcTemplate.update(sql, params);
    
  }

  @Override
  public PlantLog saveLog(String plantName, LocalDate plantedDate, LocalDate sproutedDate,
      LocalDate prunedDate) {
    
    SqlParams params = generateInsertSql(plantName, plantedDate, sproutedDate, prunedDate);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long logPK = keyHolder.getKey().longValue();
    
    // @formatter:off
    
    return PlantLog.builder()
        .logPK(logPK)
       //how to get plantFK from plantName?? .plantFK(plantName)
        .plantedDate(plantedDate)
        .sproutedDate(sproutedDate)
        .prunedDate(prunedDate)
        .build();
    
    // @formatter:on
    
  }

  //how to get plantFK from plantName?? .plantFK(plantName)

//  @Override
//  public int fetchPlantFK(String plantName) {
//    // @formatter:off
//    String sql = ""
//        + "SELECT plant_fk "
//        + "FROM plants "
//        + "WHERE plant_name = :plant_name";
//    // @formatter:on
//    
//    int plantFK;
//    
//    Map<String, Object> params = new HashMap<>();
//    params.put("plant_fk", plantFK);
//    
//    return plantFK;
//  }
//  
//  @Override
//  public String fetchPlantName(String plantName) {
//    // @formatter:off
//    String sql = ""
//        + "SELECT plant_name "
//        + "FROM plants "
//        + "WHERE plant_name = :plant_name";
//    // @formatter:on
//    
//    Map<String, Object> params = new HashMap<>();
//    params.put("plant_name", plantName);
//    
//    return ;
//  }

  @Override
  public LocalDate fetchPlantedDate(LocalDate plantedDate) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocalDate fetchSproutedDate(LocalDate sproutedDate) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocalDate fetchPrunedDate(LocalDate prunedDate) {
    // TODO Auto-generated method stub
    return null;
  }
//  @Override
//  public Plant fetchPlantFK(String plantName, int plantFK, int plantPK) {
//    // @formatter:off
//    String sql = ""
//        + "SELECT * "
//    plantName
//    
//    plantFK = plantPK;
//    
//    return null;
// 
}
