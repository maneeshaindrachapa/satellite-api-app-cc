package com.cloud.satelliteapi.controller;

import com.cloud.satelliteapi.model.ModelApiResponse;
import com.cloud.satelliteapi.model.Satellite;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "satellite")
public interface SatelliteController {

        @ApiOperation(value = "Add the Constellation for Satellite", nickname = "addConstellation", notes = "Returns the status", response = ModelApiResponse.class, tags={ "satellite", })
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
                @ApiResponse(code = 400, message = "Invalid satellite id", response = ModelApiResponse.class),
                @ApiResponse(code = 404, message = "satellite not found", response = ModelApiResponse.class) })
        @RequestMapping(value = "/satellite/add/{satelliteID}",
                produces = { "application/json" },
                method = RequestMethod.POST)
        ResponseEntity<ModelApiResponse> addConstellation(@ApiParam(value = "ID of the satellite",required=true)
                                                   @PathVariable("satelliteID") Long satelliteID);


    @ApiOperation(value = "Decommission the Constellation from Satellite", nickname = "decommissionConstellation", notes = "Returns the status",
            response = ModelApiResponse.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = ModelApiResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = ModelApiResponse.class) })
    @RequestMapping(value = "/satellite/remove/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> decommissionConstellation(@ApiParam(value = "ID of the satellite",required=true)
                                               @PathVariable("satelliteID") Long satelliteID);


    @ApiOperation(value = "Monitor the health of the Satellite", nickname = "getSatelliteHealth", notes = "Returns the status", response = Satellite.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Satellite.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = ModelApiResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = ModelApiResponse.class) })
    @RequestMapping(value = "/satellite/health/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Satellite> getSatelliteHealth(@ApiParam(value = "ID of the satellite",required=true)
                                                        @PathVariable("satelliteID") Long satelliteID);


    @ApiOperation(value = "Get all Satellite Details", nickname = "getAllSatellites", notes = "Returns all Satellites", response = Satellite.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Satellite.class),
            @ApiResponse(code = 404, message = "satellites not found", response = ModelApiResponse.class) })
    @RequestMapping(value = "/satellite/",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Satellite>> getAllSatellites();


}
