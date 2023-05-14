/**
 * 
 */
package com.promineotech.plant.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import lombok.Getter;

/**
 * @author fmhag
 *
 */
public class GardenShopBaseTest {
  
  @LocalServerPort
  private int serverPort;

  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
  protected String getBaseUriForPlants() {
    return String.format("http://localhost:%d/plants", serverPort);
  }

}

