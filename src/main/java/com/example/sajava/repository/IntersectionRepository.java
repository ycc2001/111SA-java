package com.example.sajava.repository;

import com.example.sajava.Data;
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

    Data data;

    public Data insertIntersection(IntersectionModel intersectionModel) {
        System.out.println("add intersection");
        String sql = "INSERT  INTO intersection(road_id, location_x, location_y) VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, intersectionModel.getRoadId(), intersectionModel.getLocationX(), intersectionModel.getLocationY());
            data = new Data(200, "insert success");
            return data;
        } catch (Exception e) {
            data = new Data(400, e.toString());
            return data;
        }

    }

    public Data delIntersection(int roadId) {
        System.out.println("delete intersection");
        String sql = "DELETE FROM intersection WHERE road_id = ?";

        try {
            jdbcTemplate.update(sql, roadId);
            data = new Data(200, "delete success");
            return data;
        } catch (Exception e) {
            data = new Data(400, e.toString());
            return data;
        }
    }

    public Data updateIntersection(Map<String, Object> reqBody) {
        System.out.println("update intersection");
        final String jsonKey[] = {"locationX", "locationY"};
        final String sqlAttribute[] = {"location_x", "location_y"};

        String sql;
        int id = (int) reqBody.get("roadId");

        for (int i = 0; i < jsonKey.length; i++) {
            String s = jsonKey[i];
            if (reqBody.get(s) != null) {
                System.out.println(String.format("update %s", jsonKey[i]));
                sql = "UPDATE intersection SET " + sqlAttribute[i] + " = ? WHERE road_id = ?";
                try{
                    jdbcTemplate.update(sql, reqBody.get(s), id);
                }catch (Exception e){
                    data = new Data(400, e.toString());
                }

            }
        }

        data = new Data(200, jdbcTemplate.queryForMap("SELECT * FROM intersection WHERE road_id = ?", id));
        return data;
    }

    public Data selectIntersection(int id) {
        System.out.println("search intersection");
        String sql = "SELECT * FROM intersection WHERE road_id = ?";

        data = new Data(200, jdbcTemplate.queryForMap(sql, id));
        return data;
    }

    public Data selectAllIntersection() {
        System.out.println("all intersection");

        data = new Data(200, jdbcTemplate.queryForList("SELECT * FROM intersection"));

        return data;
    }

}
