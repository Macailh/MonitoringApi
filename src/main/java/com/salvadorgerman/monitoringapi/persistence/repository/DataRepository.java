package com.salvadorgerman.monitoringapi.persistence.repository;

import com.salvadorgerman.monitoringapi.persistence.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {
    public List<Data> findAllByDevice(int device);

//    public List<Data> findTopByDevice(int device, int top);

    @Query(value = "SELECT * FROM data WHERE device = :device ORDER BY id DESC LIMIT :limit", nativeQuery = true)
    public List<Data> findByDeviceLimit(@Param("device") int device, @Param("limit") int limit);
}
