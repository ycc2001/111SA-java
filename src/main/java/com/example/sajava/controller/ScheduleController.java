package com.example.sajava.controller;

import com.example.sajava.Data;
import com.example.sajava.model.ScheduleModel;
import com.example.sajava.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    ScheduleModel scheduleModel;

    @Autowired
    ScheduleService scheduleService;

    Data data;
    @PostMapping("add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody ScheduleModel schModel){
        data = scheduleService.add(schModel);
        return data.getResponse();
    }

    @GetMapping("all")
    public ResponseEntity<Map<String, Object>> all(){
        data = scheduleService.all();

        return data.getResponse();
    }
}
