package com.cloud.satelliteapi.service.impl;

import com.cloud.satelliteapi.model.Satellite;
import com.cloud.satelliteapi.model.Status;
import com.cloud.satelliteapi.repository.SatelliteRepository;
import com.cloud.satelliteapi.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Override
    public int addConstellation(Long satelliteID) {
        return satelliteRepository.addConstellation(satelliteID, Status.ATTACHED.getValue());
    }

    @Override
    public int decommissionConstellation(Long satelliteID) {
        return satelliteRepository.decommissionConstellation(satelliteID, Status.DETACHED.getValue());
    }

    @Override
    public Optional<Satellite> getSatelliteHealth(Long satelliteID) {
        return satelliteRepository.findById(satelliteID);
    }

    @Override
    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }
}
