package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficRecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrafficRecordRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static Data data;
    public Data insertTrafficRecord(TrafficRecordModel trafficRecordModel){
        System.out.println("add Traffic record");

        String sql = "INSERT INTO traffic_record(traffic_record_id,lane_id,intersection_id,traffic_flow,greenlight_time,start_time,is_emergency,live_video) VALUES(?, ?, ?, ?, ?, ?, ?, ? )";
        Object[]value = {trafficRecordModel.getTrafficRecordId(),trafficRecordModel.getLaneId(),trafficRecordModel.getIntersectionId(),trafficRecordModel.getTrafficFlow(),trafficRecordModel.getGreenLightTime(),trafficRecordModel.getStartTime(),trafficRecordModel.getEmergency(),trafficRecordModel.getLiveVideo()};
        try{
            jdbcTemplate.update(sql, value);
            data = new Data(200, "insert success");
            return data;
        }catch (Exception e){
            data = new Data(400, e.toString());
            return data;
        }
    }
    public Data selectAllTrafficRecord(){
        String sql = "SELECT * FROM traffic_record";


        data = new Data(200, jdbcTemplate.queryForList(sql));

        return data;
    }


}
