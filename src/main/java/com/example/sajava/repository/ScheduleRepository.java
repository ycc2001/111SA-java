package com.example.sajava.repository;

import com.example.sajava.Data;
import com.example.sajava.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Data data;

    public Data insertSchedule(ScheduleModel scheduleModel){
        System.out.println("add schedule");

        String sql = "INSERT INTO schedule(schedule_id, semaphore_id, start_time, end_time, status, switching_time) VALUES(?, ?, ?, ?, ?, ?)";
        Object[] value = {scheduleModel.getScheduleId(), scheduleModel.getSemaphoreId(), scheduleModel.getStartTime(), scheduleModel.getEndTime(), scheduleModel.getStatus(), scheduleModel.getSwitchingTime()};

        try{
            jdbcTemplate.update(sql, value);
            data = new Data(200, "insert success");
            return data;
        }catch (Exception e){
            System.out.println(e);
            data = new Data(400, e.toString());
            return data;
        }

    }

    public Data selectAllSchedule(){
        String sql = "SELECT * FROM schedule";


        data = new Data(200, jdbcTemplate.queryForList(sql));

        return data;
    }
}
