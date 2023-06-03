package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.IntersectionModel;
import com.example.sajava.service.IntersectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "intersection", produces = "application/json")
public class IntersectionController {
    @Autowired
    IntersectionModel intersectionModel;

    @Autowired
    IntersectionService intersectionService;

    private static Data data;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody IntersectionModel intModel){
        data = intersectionService.add(intModel);

        return data.getResponse();
    }

    @PostMapping("del")
    public ResponseEntity<Map<String, Object>> del(@RequestBody Map<String, Object> reqBody){
        data = intersectionService.del((String) reqBody.get("roadId"));

        return data.getResponse();
    }

    @PostMapping("update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Map<String, Object> reqBody){
        data = intersectionService.update(reqBody);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam String roadId){
        data = intersectionService.search(roadId);

        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        data = intersectionService.all();

        return data.getResponse();
    }
}
