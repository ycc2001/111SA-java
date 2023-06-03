package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficRecordModel;
import com.example.sajava.service.TrafficRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "traffic_record", produces = "application/json")
public class TrafficRecordController {
    @Autowired
    TrafficRecordModel trafficRecordModel;

    @Autowired
    TrafficRecordService trafficRecordService;

    private static Data data;
    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody TrafficRecordModel trModel){
        data = trafficRecordService.add(trModel);
        return data.getResponse();
    }
    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        data = trafficRecordService.all();

        return data.getResponse();
    }



}
