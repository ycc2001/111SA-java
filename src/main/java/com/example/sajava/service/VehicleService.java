package com.example.sajava.service;

import com.example.sajava.model.VehicleModel;
import com.example.sajava.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public String add(VehicleModel vehicleModel){
        return vehicleRepository.insertVehicle(vehicleModel);
    }
}
