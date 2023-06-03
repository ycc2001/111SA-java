package com.example.sajava.model;

import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class CrossroadsModel {
    @Id
    private String intersectionId;
    @Id
    private String roadId;

    public String getIntersectionId() {
        return intersectionId;
    }
    public String getRoadId() {
        return roadId;
    }

    public void setIntersectionId(String intersectionId) {
        this.intersectionId = intersectionId;
    }
    public void setRoadId(String roadId) {
        this.roadId = roadId;
    }
}
