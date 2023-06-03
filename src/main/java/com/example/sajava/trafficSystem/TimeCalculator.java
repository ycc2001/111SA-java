package com.example.sajava.trafficSystem;

public class TimeCalculator {
    final int[] c = {0, 3, 3, 10, 10};
    final int[] upper = {0, 130, 90, 60, 50};
    final int[] downer = {0, 90, 50, 20, 10};
    private String intersectionId;
    private String roadIdX;
    private String roadIdY;
    private int xLane;
    private int yLane;
    private int lightTime;

    public TimeCalculator(String intersectionId){
        this.intersectionId = intersectionId;


    };
}
