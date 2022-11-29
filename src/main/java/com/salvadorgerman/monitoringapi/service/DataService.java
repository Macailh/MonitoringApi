package com.salvadorgerman.monitoringapi.service;

import com.salvadorgerman.monitoringapi.persistence.entity.Data;
import com.salvadorgerman.monitoringapi.persistence.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    private final DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public List findAll() {
        return this.repository.findAll();
    }

    public List<Data> findByDevice(int device) {
        return this.repository.findAllByDevice(device);
    }

    public List<Data> findByDeviceLimit(int device, int limit) {
        return this.repository.findByDeviceLimit(device, limit);
    }
}
