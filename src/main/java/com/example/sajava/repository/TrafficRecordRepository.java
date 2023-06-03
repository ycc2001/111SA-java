package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficRecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class TrafficRecordRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Data data;
    public Data insertTrafficRecord(TrafficRecordModel trafficRecordModel){
        System.out.println("add Traffic record");

        String sql = "INSERT INTO traffic_record(traffic_record_id,intersection_id,traffic_flow,greenlight_time,start_time,is_emergency,live_video) VALUES(?, ?, ?, ?, ?, ?, ? )";
        Object[]value = {trafficRecordModel.getTrafficRecordId(),trafficRecordModel.getIntersectionId(),trafficRecordModel.getTrafficFlow(),trafficRecordModel.getGreenLightTime(),trafficRecordModel.getStartTime(),trafficRecordModel.getEmergency(),trafficRecordModel.getLiveVideo()};
        try{
            jdbcTemplate.update(sql, value);
            data = new Data(200, "insert success");
            return data;
        }catch (Exception e){
            data = new Data(400, e.toString());
            return data;
        }
    }

    public Data delTrafficRecord(String trafficRecordId) {
        System.out.println("delete traffic_record");
        String sql = "DELETE FROM traffic_record WHERE traffic_record_id = ?";

        try {
            jdbcTemplate.update(sql, trafficRecordId);
            data = new Data(200, "delete success");
            return data;
        } catch (Exception e) {
            data = new Data(400, e.toString());
            return data;
        }
    }

    public Data updateTrafficRecord(Map<String, Object> reqBody) {
        System.out.println("update traffic_record");
        final String jsonKey[] = {"intersectionId", "trafficFlow", "greenLightTime", "startTime", "isEmergency", "liveVideo"};
        final String sqlAttribute[] = {"intersection_id", "traffic_flow", "greenlight_time", "start_time", "is_emergency", "live_video"};

        String sql;
        String id = (String) reqBody.get("trafficRecordId");

        for (int i = 0; i < jsonKey.length; i++) {
            String s = jsonKey[i];
            if (reqBody.get(s) != null) {
                System.out.println(String.format("update %s", jsonKey[i]));
                sql = "UPDATE traffic_record SET " + sqlAttribute[i] + " = ? WHERE traffic_record_id = ?";
                try{
                    jdbcTemplate.update(sql, reqBody.get(s), id);
                }catch (Exception e){
                    data = new Data(400, e.toString());
                }

            }
        }

        data = new Data(200, jdbcTemplate.queryForMap("SELECT * FROM traffic_record WHERE traffic_record_id = ?", id));
        return data;
    }

    public Data selectTrafficRecord(String trafficRecordId) {
        System.out.println("search intersection");
        String sql = "SELECT * FROM traffic_record WHERE traffic_record_id = ?";

        data = new Data(200, jdbcTemplate.queryForMap(sql, trafficRecordId));
        return data;
    }

    public Data selectAllTrafficRecord(){
        String sql = "SELECT * FROM traffic_record";


        data = new Data(200, jdbcTemplate.queryForList(sql));

        return data;
    }


}
