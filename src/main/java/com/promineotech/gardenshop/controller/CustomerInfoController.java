/**
 * 
 */
package com.promineotech.gardenshop.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.gardenshop.entity.Customer;
import com.promineotech.gardenshop.entity.CustomerRequest;
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
@RequestMapping("/customer")

@OpenAPIDefinition(info = @Info(title = "Customer Info Service"), servers={
    @Server(url = "http://localhost:8080", description = "Local server.")
})
public interface CustomerInfoController {

  //@formatter:off
   @Operation(
       summary = "Returns a list of Customers",
       description = "Returns a list of Customers given an optional filter.",
       responses={
           @ApiResponse(
               responseCode = "200", 
               description = "A list of Customers is returned.", 
               content = @Content(
                   mediaType = "application/json", 
                   schema = @Schema(implementation = Customer.class))),
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
       }
   )
   
   @GetMapping
   @ResponseStatus(code = HttpStatus.OK)
   
   List<Customer> fetchCustomers();
   
   // @formatter:on

///////////////////////////////////////////////////////////////////////////////////////////////////////////
   
 /// @formatter:off
 @Operation(
     summary = "Creates new Customer",
     description = "Returns a newly created Customer.",
     responses={
         @ApiResponse(
             responseCode = "200", 
             description = "A newly created Customer was returned.", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Customer.class))),
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
             name = "CustomerRequest", 
             required = true, 
             description = "The customer as JSON"),
         
     }
 )
 
 @PostMapping
 @ResponseStatus(code = HttpStatus.CREATED)
 
 Customer createCustomer (
     @Valid
     @RequestBody CustomerRequest customerRequest);
 
 // @formatter:on  

}

