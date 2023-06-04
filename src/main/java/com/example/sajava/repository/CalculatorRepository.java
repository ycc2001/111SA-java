package com.example.sajava.repository;

import com.example.sajava.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CalculatorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static Data data;
    public List<Map<String, Object>> crossroadsData(String intersectionId){
        String sql = "SELECT * FROM crossroads WHERE intersection_id = ?";

        return jdbcTemplate.queryForList(sql, intersectionId);
    }

    public String roadLane(String roadId){
        String sql = "SELECT lane_id FROM road WHERE road_id = ?";

        return (String)jdbcTemplate.queryForMap(sql, roadId).get("lane_id");
    }

}
