package com.example.sajava.service;

import com.example.sajava.Data;
import com.example.sajava.model.ScheduleModel;
import com.example.sajava.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public Data add(ScheduleModel scheduleModel){
        return scheduleRepository.insertSchedule(scheduleModel);
    }

    public Data all(){
        return scheduleRepository.selectAllSchedule();
    }
}
