package com.cloud.satelliteapi.service;

import com.cloud.satelliteapi.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SatelliteService {

    int addConstellation(Long satelliteID);

    int decommissionConstellation(Long satelliteID);

    Optional<Satellite> getSatelliteHealth(Long satelliteID);

    List<Satellite> getAllSatellites();
}
