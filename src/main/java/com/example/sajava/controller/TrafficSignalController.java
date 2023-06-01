package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficSignalModel;
import com.example.sajava.service.TrafficSignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ResponseStatus(HttpStatus.ACCEPTED)
@RestController
@RequestMapping("trafficsignal")
public class TrafficSignalController {
    @Autowired
    TrafficSignalModel trafficSignalModel;
    @Autowired
    TrafficSignalService trafficSignalService;
    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody TrafficSignalModel tsModel){
        Data data = new Data(200, trafficSignalService.add(tsModel));

        return data.getResponse();
    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        Data data = new Data(200, trafficSignalService.all());

        return data.getResponse();
    }



}
