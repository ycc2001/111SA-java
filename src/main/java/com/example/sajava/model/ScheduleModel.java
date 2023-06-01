package com.example.sajava.model;

import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

@Component
public class ScheduleModel {
    @Id
    private int scheduleId;
    private int semaphoreId;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;
    private Timestamp switchingTime;

    public int getScheduleId() {
        return scheduleId;
    }
    public int getSemaphoreId() {
        return semaphoreId;
    }
    public Timestamp getStartTime() {
        return startTime;
    }
    public Timestamp getEndTime() {
        return endTime;
    }
    public String getStatus() {
        return status;
    }
    public Timestamp getSwitchingTime() {
        return switchingTime;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
    public void setSemaphoreId(int semaphoreId) {
        this.semaphoreId = semaphoreId;
    }
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setSwitchingTime(Timestamp switchingTime) {
        this.switchingTime = switchingTime;
    }
}
