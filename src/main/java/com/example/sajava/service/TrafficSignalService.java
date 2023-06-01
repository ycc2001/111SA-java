package com.example.sajava.service;

import com.example.sajava.model.TrafficSignalModel;
import com.example.sajava.repository.TrafficSignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrafficSignalService {
    @Autowired
    TrafficSignalRepository trafficSignalRepository;

    public String add(TrafficSignalModel trafficSignalModel){
        return trafficSignalRepository.insertTrafficSignal(trafficSignalModel);
    }


    public List<Map<String, Object>> all() {

        return trafficSignalRepository.selectAllTrafficsignal();
    }


}
