/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gardenshop.entity.PlantDetails;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author fmhag
 *
 */
@RequestMapping("/plant_details")

@OpenAPIDefinition(info = @Info(title = "Plant Details Service"), servers={
    @Server(url = "http://localhost:8080", description = "Local server.")
})
public interface PlantDetailsController {
//@formatter:off
  @Operation(
      summary = "Returns a list of Plant Details",
      description = "Returns a list of Plant Details given an optional filter.",
      responses={
          @ApiResponse(
              responseCode = "200", 
              description = "A list of Plant Details is returned.", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = PlantDetails.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No Plants were found with the specified filters.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occured.", 
              content = @Content(mediaType = "application/json"))
      }, 
        parameters={
            @Parameter(
                name = "Plant Name:", 
                allowEmptyValue = false, 
                required = false, 
                description = "The plant name (i.e., 'Petunia'):"),
        }
    )
    
 
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  
  List<PlantDetails> fetchPlantDetails(
      @RequestParam(required = false)
      String plantName);
  
  // @formatter:on

  

}
