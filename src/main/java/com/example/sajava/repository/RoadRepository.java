package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import com.example.sajava.model.RoadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RoadRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Data data;

    public Data insertRoad(RoadModel roadModel) {
        System.out.println("add road");
        String sql = "INSERT  INTO road(road_id, lane_id, road_name) VALUES(?, ?, ?)";
        try {
            jdbcTemplate.update(sql, roadModel.getRoadId(), roadModel.getLaneId(), roadModel.getRoadName());
            data = new Data(200, "road success");
            return data;
        } catch (Exception e) {
            data = new Data(400, e.toString());
            return data;
        }

    }

    public Data delRoad(String roadId) {
        System.out.println("delete road");
        String sql = "DELETE FROM road WHERE road_id = ?";

        try {
            jdbcTemplate.update(sql, roadId);
            data = new Data(200, "delete success");
            return data;
        } catch (Exception e) {
            data = new Data(400, e.toString());
            return data;
        }
    }

    public Data updateRoad(Map<String, Object> reqBody) {
        System.out.println("update road");
        final String jsonKey[] = {"laneId", "roadName"};
        final String sqlAttribute[] = {"lane_id", "road_name"};

        String sql;
        String id = (String) reqBody.get("roadId");

        for (int i = 0; i < jsonKey.length; i++) {
            String s = jsonKey[i];
            if (reqBody.get(s) != null) {
                System.out.println(String.format("update %s", jsonKey[i]));
                sql = "UPDATE road SET " + sqlAttribute[i] + " = ? WHERE road_id = ?";
                try{
                    jdbcTemplate.update(sql, reqBody.get(s), id);
                }catch (Exception e){
                    data = new Data(400, e.toString());
                }

            }
        }

        data = new Data(200, jdbcTemplate.queryForMap("SELECT * FROM road WHERE road_id = ?", id));
        return data;
    }

    public Data selectRoad(String roadId) {
        System.out.println("search road");
        String sql = "SELECT * FROM road WHERE road_id = ?";

        data = new Data(200, jdbcTemplate.queryForMap(sql, roadId));
        return data;
    }

    public Data selectAllRoad() {
        System.out.println("all road");

        data = new Data(200, jdbcTemplate.queryForList("SELECT * FROM road"));

        return data;
    }
}
