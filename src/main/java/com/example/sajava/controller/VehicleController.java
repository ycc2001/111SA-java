package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.VehicleModel;
import com.example.sajava.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ResponseStatus(HttpStatus.ACCEPTED)
@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    VehicleModel vehicleModel;
    @Autowired
    VehicleService vehicleService;
    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody VehicleModel vehModel){
        Data data = new Data(200, vehicleService.add(vehModel));

        return data.getResponse();
    }
}
