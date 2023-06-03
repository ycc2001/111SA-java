package com.example.sajava.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.Timestamp;

@Component
public class TrafficRecordModel {
    @Id
    private String trafficRecordId;
    private String laneId;
    private String intersectionId;
    private double trafficFlow;
    private int greenLightTime;
    private Timestamp startTime;
    private Boolean isEmergency;
    private Blob liveVideo;

    public String getTrafficRecordId() {
        return trafficRecordId;
    }

    public String getLaneId() {
        return laneId;
    }

    public String getIntersectionId() {
        return intersectionId;
    }

    public double getTrafficFlow() {
        return trafficFlow;
    }

    public int getGreenLightTime() {
        return greenLightTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Boolean getEmergency() {
        return isEmergency;
    }

    public Blob getLiveVideo() {
        return liveVideo;
    }

    public void setTrafficRecordId(String trafficRecordId) {
        this.trafficRecordId = trafficRecordId;
    }

    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public void setIntersectionId(String intersectionId) {
        this.intersectionId = intersectionId;
    }

    public void setTrafficFlow(double trafficFlow) {
        this.trafficFlow = trafficFlow;
    }

    public void setGreenLightTime(int greenLightTime) {
        this.greenLightTime = greenLightTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    public void setLiveVideo(Blob liveVideo) {
        this.liveVideo = liveVideo;
    }
}
