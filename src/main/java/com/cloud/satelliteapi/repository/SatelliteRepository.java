package com.cloud.satelliteapi.repository;

import com.cloud.satelliteapi.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

    @Modifying
    @Transactional
    @Query("update Satellite sl set sl.status = :status where sl.id = :satelliteID")
    int addConstellation(Long satelliteID, String status);

    @Modifying
    @Transactional
    @Query("update Satellite sl set sl.status = :status where sl.id = :satelliteID")
    int decommissionConstellation(Long satelliteID, String status);

    Optional<Satellite> findById(Long satelliteID);

    List<Satellite> findAll();
}