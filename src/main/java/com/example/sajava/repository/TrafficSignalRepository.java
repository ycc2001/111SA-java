package com.example.sajava.repository;

import com.example.sajava.model.TrafficSignalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TrafficSignalRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String insertTrafficSignal(TrafficSignalModel trafficSignalModel){
        System.out.println("add TrafficSignal");
        String sql = "INSERT INTO trafficsignal(light_id, intersection_blongs, type_of_light, current_state)VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql,trafficSignalModel.getLightId(),trafficSignalModel.getIntersectionBlongs(),trafficSignalModel.getTypeOfLight(),trafficSignalModel.getCurrentState());
        return "insert success";
    }

    public List<Map<String, Object>> selectAllTrafficsignal() {
        System.out.println("all Trafficsignal");

        return jdbcTemplate.queryForList("SELECT * FROM trafficsignal");
    }


}
