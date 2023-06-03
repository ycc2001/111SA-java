package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.LaneModel;
import com.example.sajava.repository.LaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LaneService {
    @Autowired
    LaneRepository laneRepository;

    public Data add(LaneModel laneModel){
        return laneRepository.insertLane(laneModel);
    }
    public Data del(String laneId){
        return laneRepository.delLane(laneId);
    }

    public Data update(Map<String, Object> reqBody){
        return laneRepository.updateLane(reqBody);
    }

    public Data search(String laneId) {
        return laneRepository.selectLane(laneId);
    }

    public Data all(){
        return laneRepository.selectAllLane();
    }
}
