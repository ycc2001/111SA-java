package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import com.example.sajava.service.IntersectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@ResponseStatus(HttpStatus.ACCEPTED)
@RestController
@RequestMapping(value = "intersection", produces = "application/json")
public class IntersectionController {
    final String statusCode = "statusCode", response = "response";


    @Autowired
    IntersectionModel intersectionModel;

    @Autowired
    IntersectionService intersectionService;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody IntersectionModel intModel){
        Data data = new Data(200, "insert success");

        intersectionModel = new IntersectionModel();
        intersectionModel.setRoadId(intModel.getRoadId());
        intersectionModel.setLocationX(intModel.getLocationX());
        intersectionModel.setLocationY(intModel.getLocationY());

        intersectionService.add(intModel);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam int id){
        Data data = new Data(200, intersectionService.search(id));

        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        Data data = new Data(200, intersectionService.all());

        return data.getResponse();
    }
}
