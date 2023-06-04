package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.TrafficRecordModel;
import com.example.sajava.service.TrafficRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping(value = "traffic_record", produces = "application/json")
public class TrafficRecordController {
    @Autowired
    TrafficRecordModel trafficRecordModel;

    @Autowired
    TrafficRecordService trafficRecordService;

    private static Data data;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody TrafficRecordModel trModel) {
        data = trafficRecordService.add(trModel);
        return data.getResponse();
    }

    @PostMapping("del")
    public ResponseEntity<Map<String, Object>> del(@RequestBody Map<String, Object> reqBody) {
        data = trafficRecordService.del((String) reqBody.get("trafficRecordId"));

        return data.getResponse();
    }

    @PostMapping("update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Map<String, Object> reqBody) {
        data = trafficRecordService.update(reqBody);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam String trafficRecordId) {
        data = trafficRecordService.search(trafficRecordId);

        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all() {
        data = trafficRecordService.all();

        return data.getResponse();
    }


}
