package com.example.sajava.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class IntersectionModel {
    @Id
    private int roadId;
    private double locationX;
    private double locationY;

    public int getRoadId() {
        return roadId;
    }
    public double getLocationX() {
        return locationX;
    }
    public double getLocationY() {
        return locationY;
    }

    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }
    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }
    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }
}

