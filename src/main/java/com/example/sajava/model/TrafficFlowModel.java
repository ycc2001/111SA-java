package com.example.sajava.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class TrafficFlowModel {
    @Id
    private int vehicleId;
}
