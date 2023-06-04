package com.example.sajava.trafficSystem;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "emergency")
public class Emergency {
    @GetMapping("")
    public boolean isHappened(){
        System.out.println();
        IdentifyTraffic identifyTraffic = new IdentifyTraffic();

        return identifyTraffic.emergencyCar();
    }
}
