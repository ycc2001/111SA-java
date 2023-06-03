package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.RoadModel;
import com.example.sajava.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "road", produces = "application/json")
public class RoadController {
    @Autowired
    RoadModel roadModel;

    @Autowired
    RoadService roadService;

    private static Data data;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody RoadModel rModel){
        data = roadService.add(rModel);

        return data.getResponse();
    }

    @PostMapping("del")
    public ResponseEntity<Map<String, Object>> del(@RequestBody Map<String, Object> reqBody){
        data = roadService.del((String) reqBody.get("roadId"));

        return data.getResponse();
    }

    @PostMapping("update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Map<String, Object> reqBody){
        data = roadService.update(reqBody);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam String roadId){
        data = roadService.search(roadId);

        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        data = roadService.all();

        return data.getResponse();
    }
}
