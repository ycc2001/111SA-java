package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import com.example.sajava.repository.IntersectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IntersectionService {
    @Autowired
    IntersectionRepository intersectionRepository;

    public Data add(IntersectionModel intersectionModel) {
        return intersectionRepository.insertIntersection(intersectionModel);
    }

    public Data del(int roadId){
        return intersectionRepository.delIntersection(roadId);
    }

    public Data update(Map<String, Object> reqBody){
        return intersectionRepository.updateIntersection(reqBody);
    }

    public Data search(int id) {
        return intersectionRepository.selectIntersection(id);
    }

    public Data all() {
        return intersectionRepository.selectAllIntersection();
    }
}
