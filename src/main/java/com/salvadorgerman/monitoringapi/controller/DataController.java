package com.salvadorgerman.monitoringapi.controller;

import com.salvadorgerman.monitoringapi.persistence.entity.Data;
import com.salvadorgerman.monitoringapi.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final DataService dataService;


    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/{device}")
    public List<Data> findAllByDevice(@PathVariable("device") int device) {
        return this.dataService.findByDevice(device);
    }

    @GetMapping("/all")
    public List findAll() {
        return this.dataService.findAll();
    }

    @GetMapping("/{device}/{limit}")
    public List<Data> findByDeviceLimit(@PathVariable("device") int device, @PathVariable("limit") int limit) {
        return this.dataService.findByDeviceLimit(device, limit);
    }
}
