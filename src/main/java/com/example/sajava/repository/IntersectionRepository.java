package com.example.sajava.repository;

import com.example.sajava.model.IntersectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IntersectionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String insertIntersection(IntersectionModel intersectionModel) {
        System.out.println("add intersection");
        String sql = "INSERT  INTO intersection(road_id, location_x, location_y) VALUES(?, ?, ?)";
        try{
            jdbcTemplate.update(sql, intersectionModel.getRoadId(), intersectionModel.getLocationX(), intersectionModel.getLocationY());
            return  "insert success";
        }catch (Exception e){
            System.out.println(e);
            return e.toString();
        }

    }

    public Map<String, Object> selectIntersection(int id){
        System.out.println("search intersection");
        String sql = "SELECT * FROM intersection WHERE road_id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }
    public List<Map<String, Object>> selectAllIntersection() {
        System.out.println("all intersection");

        return jdbcTemplate.queryForList("SELECT * FROM intersection");
    }

}
