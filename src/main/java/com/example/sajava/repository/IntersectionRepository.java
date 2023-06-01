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

    public String delIntersection(int roadId){
        System.out.println("delet intersection");
        String sql = "DELETE FROM intersection WHERE road_id = ?";

        try {
            jdbcTemplate.update(sql, roadId);
            return "delete success";
        }catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }

    public Map<String, Object> updateIntersection(Map<String, Object> reqBody){
        final String jsonKey[] = {"locationX", "locationY"};
        final String sqlAttribute[] = {"location_x", "location_y"};

        String sql;
        int id = (int)reqBody.get("roadId");

        for(int i = 0; i < jsonKey.length; i++){
            String s = jsonKey[i];
            if(reqBody.get(s) != null){
                sql = "UPDATE intersection SET " + sqlAttribute[i] + " = ? WHERE road_id = ?";
                jdbcTemplate.update(sql, reqBody.get(s), id);
            }
        }

        return jdbcTemplate.queryForMap("SELECT * FROM intersection WHERE road_id = ?", id);
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
