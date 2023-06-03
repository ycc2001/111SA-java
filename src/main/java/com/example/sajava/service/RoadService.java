package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import com.example.sajava.model.RoadModel;
import com.example.sajava.repository.IntersectionRepository;
import com.example.sajava.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoadService {
    @Autowired
    RoadRepository roadRepository;

    public Data add(RoadModel roadModel) {
        return roadRepository.insertRoad(roadModel);
    }

    public Data del(String roadID){
        return roadRepository.delRoad(roadID);
    }

    public Data update(Map<String, Object> reqBody){
        return roadRepository.updateRoad(reqBody);
    }

    public Data search(String RoadId) {
        return roadRepository.selectRoad(RoadId);
    }

    public Data all() {
        return roadRepository.selectAllRoad();
    }
}
