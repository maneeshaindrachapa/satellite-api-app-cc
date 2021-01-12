package com.cloud.satelliteapi.controller.impl;

import com.cloud.satelliteapi.controller.SatelliteController;
import com.cloud.satelliteapi.model.ModelApiResponse;
import com.cloud.satelliteapi.model.Satellite;
import com.cloud.satelliteapi.service.SatelliteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Api(tags = {"satellite"})
public class SatelliteControllerImpl implements SatelliteController {

    @Autowired
    private SatelliteService satelliteService;

    @Override
    public ResponseEntity<ModelApiResponse> addConstellation(@ApiParam(value = "ID of the satellite",required=true)
                                                          @PathVariable("satelliteID") Long satelliteID) {
        if(satelliteService.addConstellation(satelliteID) > 0) {
            return new ResponseEntity<>(new ModelApiResponse(200, "","Successfully added the constellation (commissioned)"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ModelApiResponse(404, "", "Satellite not found"), HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<ModelApiResponse> decommissionConstellation(@ApiParam(value = "ID of the satellite",required=true)
                                                                   @PathVariable("satelliteID") Long satelliteID) {
        if(satelliteService.decommissionConstellation(satelliteID) > 0) {
            return new ResponseEntity<>(new ModelApiResponse(200, "","Successfully removed the constellation (decommission)"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ModelApiResponse(404, "","Satellite not found"), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Satellite> getSatelliteHealth(@ApiParam(value = "ID of the satellite",required=true)
                                                            @PathVariable("satelliteID") Long satelliteID) {

        Optional<Satellite> satellite = satelliteService.getSatelliteHealth(satelliteID);
        return satellite.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new Satellite(), HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Satellite>> getAllSatellites() {
        List<Satellite> satellites = satelliteService.getAllSatellites();
        if(satellites.size()>0){
            return (new ResponseEntity<>(satellites, HttpStatus.OK));
        }else{
            return (new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
        }
    }
}


