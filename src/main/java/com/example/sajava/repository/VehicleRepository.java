package com.example.sajava.repository;

import com.example.sajava.model.VehicleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String insertVehicle(VehicleModel vehicleModel){
        System.out.println("insert vehicle");

        String sql = "INSERT INTO vehicle(vehicle_id, license_plate_number, vehicle_type, location_x, location_y, speed)VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, vehicleModel.getVehicleId(), vehicleModel.getLicensePlateNumber(), vehicleModel.getVehicleType(), vehicleModel.getLocationX(), vehicleModel.getLocationY(), vehicleModel.getSpeed());

        return "insert success";
    }
}
