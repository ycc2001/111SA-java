package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.LaneModel;
import com.example.sajava.service.LaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ResponseStatus(HttpStatus.ACCEPTED)
@RestController
@RequestMapping(value = "lane", produces = "application/json")
public class LaneController {
    @Autowired
    LaneModel laneModel;

    @Autowired
    LaneService laneService;

    private static Data data;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody LaneModel lModel){
        data = laneService.add(lModel);

        return data.getResponse();
    }

    @PostMapping("del")
    public ResponseEntity<Map<String, Object>> del(@RequestBody Map<String, Object> reqBody){
        data = laneService.del((String) reqBody.get("laneId"));

        return data.getResponse();
    }

    @PostMapping("update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Map<String, Object> reqBody){
        data = laneService.update(reqBody);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam String laneId){
        data = laneService.search(laneId);

        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        data = laneService.all();

        return data.getResponse();
    }
}
