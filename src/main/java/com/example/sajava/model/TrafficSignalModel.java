package com.example.sajava.model;


import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class TrafficSignalModel {
    @Id
    private int lightId;
    private int intersectionBlongs;
    private String typeOfLight;
    private String currentState;

    public int getLightId() {
        return lightId;
    }

    public int getIntersectionBlongs() {
        return intersectionBlongs;
    }

    public String getTypeOfLight() {
        return typeOfLight;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    public void setIntersectionBlongs(int intersectionBlongs) {
        this.intersectionBlongs = intersectionBlongs;
    }

    public void setTypeOfLight(String typeOfLight) {
        this.typeOfLight = typeOfLight;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
