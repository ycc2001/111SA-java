package com.example.sajava.model.request;

import org.springframework.stereotype.Component;

@Component
public class TimeRequest {
    private String intersectionId;
    private int isNS;

    public String getIntersectionId() {
        return intersectionId;
    }
    public int getIsNS() {
        return isNS;
    }

    public void setIntersectionId(String intersectionId) {
        this.intersectionId = intersectionId;
    }
    public void setIsNS(int isNS) {
        this.isNS = isNS;
    }
}
