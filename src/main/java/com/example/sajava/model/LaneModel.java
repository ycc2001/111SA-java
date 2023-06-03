package com.example.sajava.model;

import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class LaneModel {
    @Id
    private String laneId;
    private String laneType;
    public String getLaneId(){ return laneId;}
    public String getLaneType(){ return laneType;}
    public void setLaneId(String laneId){ this.laneId = laneId;}
    public void setLaneType(String laneType){ this.laneType = laneType;}
}
