package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.trafficSystem.IdentifyTraffic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class HttpRequestController {
    private static Data data;
    IdentifyTraffic identifyTraffic = new IdentifyTraffic();
    @GetMapping("car-number")
    public ResponseEntity<Map<String, Object>> countCar(@RequestParam int id){
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("roadId", id);

        data = new Data(200, identifyTraffic.carNumber(requestBody));
        return data.getResponse();
    }

}
