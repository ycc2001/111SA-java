package com.example.sajava.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.Timestamp;

@Component
public class TrafficRecordModel {
    @Id
    private String trafficRecordId;
    private String intersectionId;
    private int trafficFlow;
    private double greenLightTime;
    private Timestamp startTime;
    private Boolean isEmergency;
    private String liveVideo;

    public String getTrafficRecordId() {
        return trafficRecordId;
    }

    public String getIntersectionId() {
        return intersectionId;
    }

    public int getTrafficFlow() {
        return trafficFlow;
    }

    public double getGreenLightTime() {
        return greenLightTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Boolean getEmergency() {
        return isEmergency;
    }

    public String getLiveVideo() {
        return liveVideo;
    }

    public void setTrafficRecordId(String trafficRecordId) {
        this.trafficRecordId = trafficRecordId;
    }

    public void setIntersectionId(String intersectionId) {
        this.intersectionId = intersectionId;
    }

    public void setTrafficFlow(int trafficFlow) {
        this.trafficFlow = trafficFlow;
    }

    public void setGreenLightTime(double greenLightTime) {
        this.greenLightTime = greenLightTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEmergency(Boolean emergency) {
        isEmergency = emergency;
    }

    public void setLiveVideo(String liveVideo) {
        this.liveVideo = liveVideo;
    }
}
