package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficRecordModel;
import com.example.sajava.repository.TrafficRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrafficRecordService {
    @Autowired
    TrafficRecordRepository trafficRecordRepository;

    public Data add(TrafficRecordModel trafficRecordModel){
        return trafficRecordRepository.insertTrafficRecord(trafficRecordModel);
    }
    public Data del(String trafficRecordId){
        return trafficRecordRepository.delTrafficRecord(trafficRecordId);
    }

    public Data update(Map<String, Object> reqBody){
        return trafficRecordRepository.updateTrafficRecord(reqBody);
    }

    public Data search(String trafficRecordId) {
        return trafficRecordRepository.selectTrafficRecord(trafficRecordId);
    }

    public Data all(){
        return trafficRecordRepository.selectAllTrafficRecord();
    }



}
