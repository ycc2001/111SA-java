package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class IntersectionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Data data;

    public Data insertIntersection(IntersectionModel intersectionModel) {
        System.out.println("add intersection");
        String sql = "INSERT  INTO intersection(intersection_id, location_x, location_y) VALUES(?, ?, ?)";

        try {
            jdbcTemplate.update(sql, intersectionModel.getIntersectionId(), intersectionModel.getLocationX(), intersectionModel.getLocationY());
            data = new Data(200, "insert success");
        } catch (Exception e) {
            data = new Data(400, e.toString());
        }
        return data;
    }

    public Data delIntersection(String intersectionId) {
        System.out.println("delete intersection");
        String sql = "DELETE FROM intersection WHERE intersection_id = ?";

        try {
            jdbcTemplate.update(sql, intersectionId);
            data = new Data(200, "delete success");
        } catch (Exception e) {
            data = new Data(400, e.toString());
        }

        return data;
    }

    public Data updateIntersection(Map<String, Object> reqBody) {
        System.out.println("update intersection");
        final String jsonKey[] = {"locationX", "locationY"};
        final String sqlAttribute[] = {"location_x", "location_y"};

        String sql;
        String id = (String) reqBody.get("intersectionId");

        for (int i = 0; i < jsonKey.length; i++) {
            String s = jsonKey[i];
            if (reqBody.get(s) != null) {
                System.out.println(String.format("update %s", jsonKey[i]));
                sql = "UPDATE intersection SET " + sqlAttribute[i] + " = ? WHERE intersection_id = ?";

                try{
                    jdbcTemplate.update(sql, reqBody.get(s), id);
                }catch (Exception e){
                    data = new Data(400, e.toString());
                }

            }
        }

        try {
            data = new Data(200, jdbcTemplate.queryForMap("SELECT * FROM intersection WHERE intersection_id = ?", id));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }

    public Data selectIntersection(String intersectionId) {
        System.out.println("search intersection");
        String sql = "SELECT * FROM intersection WHERE intersection_id = ?";

        try{
            data = new Data(200, jdbcTemplate.queryForMap(sql, intersectionId));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }

    public Data selectAllIntersection() {
        System.out.println("all intersection");

        try{
            data = new Data(200, jdbcTemplate.queryForList("SELECT * FROM intersection"));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }

}
