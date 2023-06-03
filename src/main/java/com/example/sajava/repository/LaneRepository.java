package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.LaneModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class LaneRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Data data;

    public Data insertLane(LaneModel laneModel){
        System.out.println("add schedule");

        String sql = "INSERT INTO lane(lane_id, lane_type) VALUES(?, ?)";
        Object[] value = {laneModel.getLaneId(),laneModel.getLaneType()};

        try{
            jdbcTemplate.update(sql, value);
            data = new Data(200, "insert success");
        }catch (Exception e){
            System.out.println(e);
            data = new Data(400, e.toString());
        }

        return data;
    }
    public Data delLane(String laneId) {
        System.out.println("delete lane");
        String sql = "DELETE FROM lane WHERE lane_id = ?";

        try {
            jdbcTemplate.update(sql, laneId);
            data = new Data(200, "delete success");
        } catch (Exception e) {
            data = new Data(400, e.toString());
        }

        return data;
    }

    public Data updateLane(Map<String, Object> reqBody) {
        System.out.println("update lane");
        final String jsonKey[] = {"laneId", "laneType"};
        final String sqlAttribute[] = {"lane_id", "lane_type"};

        String sql;
        String id = (String) reqBody.get("laneId");

        for (int i = 0; i < jsonKey.length; i++) {
            String s = jsonKey[i];
            if (reqBody.get(s) != null) {
                System.out.println(String.format("update %s", jsonKey[i]));
                sql = "UPDATE lane SET " + sqlAttribute[i] + " = ? WHERE lane_id = ?";
                try{
                    jdbcTemplate.update(sql, reqBody.get(s), id);
                }catch (Exception e){
                    data = new Data(400, e.toString());
                }

            }
        }

        try {
            data = new Data(200, jdbcTemplate.queryForMap("SELECT * FROM lane WHERE lane_id = ?", id));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }

    public Data selectLane(String laneId) {
        System.out.println("search lane");
        String sql = "SELECT * FROM lane WHERE lane_id = ?";

        try{
            data = new Data(200, jdbcTemplate.queryForMap(sql, laneId));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }
    public Data selectAllLane(){
        String sql = "SELECT * FROM lane";

        try{
            data = new Data(200, jdbcTemplate.queryForList(sql));
        }catch (Exception e){
            data = new Data(400, e.toString());
        }

        return data;
    }
}
