package com.example.sajava.service;

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

    public String add(IntersectionModel intersectionModel) {
        return intersectionRepository.insertIntersection(intersectionModel);
    }

    public String del(int roadId){
        return intersectionRepository.delIntersection(roadId);
    }

    public Map<String, Object> update(Map<String, Object> reqBody){
        return intersectionRepository.updateIntersection(reqBody);
    }

    public Map<String, Object> search(int id) {
        return intersectionRepository.selectIntersection(id);
    }

    public List<Map<String, Object>> all() {
        return intersectionRepository.selectAllIntersection();
    }
}
