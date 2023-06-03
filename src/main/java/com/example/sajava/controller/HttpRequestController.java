package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.trafficSystem.IdentifyTraffic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "", produces = "application/json")
public class HttpRequestController {
    private static Data data;
    IdentifyTraffic identifyTraffic = new IdentifyTraffic();
    @GetMapping("car-number")
    public ResponseEntity<Map<String, Object>> countCar(@RequestParam int id){
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("roadId", id);

        data = identifyTraffic.carNumber(requestBody);
        return data.getResponse();
    }

}
