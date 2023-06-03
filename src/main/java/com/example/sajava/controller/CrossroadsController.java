package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.CrossroadsModel;
import com.example.sajava.service.CrossroadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "crossroads", produces = "application/json")
public class CrossroadsController {
    @Autowired
    CrossroadsModel crossroadsModel;

    @Autowired
    CrossroadsService crossroadsService;

    private static Data data;

    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody CrossroadsModel croModel) {
        data = crossroadsService.add(croModel);

        return data.getResponse();
    }

    @PostMapping("del")
    public ResponseEntity<Map<String, Object>> del(@RequestBody CrossroadsModel croModel) {
        data = crossroadsService.del(croModel);

        return data.getResponse();
    }

    @GetMapping("search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam(required = false) String intersectionId, String roadId ) {
        Map<String, Object> reqBody = new LinkedHashMap<>();
        reqBody.put("intersectionId", intersectionId);
        reqBody.put("roadId", roadId);

        data = crossroadsService.search(reqBody);
        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all() {

        data = crossroadsService.all();

        return data.getResponse();
    }
}
