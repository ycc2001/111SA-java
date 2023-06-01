package com.example.sajava.model;


import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class VehicleModel {
    @Id
    private int vehicleId;
    private String licensePlateNumber;
    private String vehicleType;
    private double locationX;
    private double locationY;
    private float speed;

    public int getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public float getSpeed() {
        return speed;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
