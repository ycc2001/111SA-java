package com.example.sajava.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class RoadModel {
    @Id
    private String roadId;
    private String laneId;
    private String roadName;
    public String getRoadId(){ return roadId;}
    public String getLaneId(){ return laneId;}
    public String getRoadName(){ return roadName;}
    public void setRoadId(String roadId){ this.roadId = roadId;}
    public void setLaneId(String laneId){ this.laneId = laneId;}
    public void setRoadName(String roadName){ this.roadName = roadName;}
}
