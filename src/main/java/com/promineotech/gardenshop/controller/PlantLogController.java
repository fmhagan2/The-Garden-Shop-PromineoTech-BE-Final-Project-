/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gardenshop.entity.LogRequest;
import com.promineotech.gardenshop.entity.Plant;
import com.promineotech.gardenshop.entity.PlantLog;
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
@RequestMapping("/plant_log")
@OpenAPIDefinition(
    info = @Info(title = "Plant Log Service"), 
    servers = @Server(url = "http://localhost:8080", description = "Local server.")
  )              
public interface PlantLogController {
//@formatter:off
 @Operation(summary = "Returns a log of plant maintenance.",
     description = "Returns a log of plant maintenance given a plant name.",
     responses={
         @ApiResponse(
             responseCode = "200", 
             description = "A plant maintenance log is returned.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Plant.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No log found for given plant.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occured.", 
             content = @Content(mediaType = "application/json"))
     }, 
     parameters={
         @Parameter(
             name = "plantName", 
             allowEmptyValue = false, 
             required = false, 
             description = "The plant that this maintenance log is for: "),
     }
 )
 
 
 @GetMapping
 @ResponseStatus(code = HttpStatus.OK)
 
 List<PlantLog> fetchPlantLog(
       @RequestParam(required = false)
       String plantName
     );
 
//////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 @Operation(summary = "Creates a log of plant maintenance.",
     description = "Returns the created log of plant maintenance.",
     responses={
         @ApiResponse(
             responseCode = "200", 
             description = "The created maintenance log is returned.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = PlantLog.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No log found for given plant.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occured.", 
             content = @Content(mediaType = "application/json"))
     }, 
     parameters={
         @Parameter(
             name = "LogRequest", 
             required = true, 
             description = "The plant log as JSON:"),
     }
 )
 
@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
 
PlantLog createLog(@Valid @RequestBody LogRequest logRequest);
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 @Operation(summary = "Updates a log of plant maintenance.",
     description = "Returns an updated log of plant maintenance for a given plant.",
     responses={
         @ApiResponse(
             responseCode = "200", 
             description = "A plant maintenance log was successfully updated.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Plant.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No log found for given plant.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occured.", 
             content = @Content(mediaType = "application/json"))
     },
     parameters={
         @Parameter(
             name = "plantName", 
             allowEmptyValue = false, 
             required = false, 
             description = "The plant name (i.e., 'Petunia'):"),
         @Parameter(
             name = "plantedDate",
             allowEmptyValue = false,
             required = false,
             description = "The date this plant was planted/potted")
         
     }
 )
 
 @PutMapping
 @ResponseStatus(code = HttpStatus.OK)
  
 void updateLog(
       @RequestParam(required = false)
       String plantName,
       @RequestParam(required = false)
       LocalDate plantedDate
       );

 //////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 @Operation(summary = "Deletes a log of plant maintenance.",
     description = "The given plant log has been deleted.",
     responses={
         @ApiResponse(
             responseCode = "200", 
             description = "A plant maintenance log was successfully deleted.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Plant.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "404", 
             description = "No log found for given plant.", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occured.", 
             content = @Content(mediaType = "application/json"))
     },
     parameters={
         @Parameter(
             name = "plantName", 
             allowEmptyValue = false, 
             required = false, 
             description = "The plant name (i.e., 'Petunia'):"),
     }
 )
 
 @DeleteMapping
 @ResponseStatus(code = HttpStatus.OK)
  
 void deleteLog(
       @RequestParam(required = false)
       String plantName
       );

 
 // @formatter:on


}
