package com.example.sajava.trafficSystem;

import com.example.sajava.Data;
import com.example.sajava.model.request.TimeRequest;
import com.example.sajava.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "time", produces = "application/json")
public class TimeCalculator {
    @Autowired
    TimeRequest timeRequest;
    @Autowired
    CalculatorService calculatorService;

    private static Data data;
    @PostMapping("calculator")
    private ResponseEntity<Map<String, Object>> calculator(@RequestBody TimeRequest tRequest){
        final String[] lane = {"L01", "L02", "L03", "L04"};
        final List<String> laneList = Arrays.stream(lane).toList();
        final int[] cArray = {3, 3, 10, 10};
        final int[] upperArray = {130, 90, 60, 50};
        final int[] lowerArray = {90, 50, 20, 10};

        Map<String, Object> roadInfo = calculatorService.roadInfo(tRequest);
        IdentifyTraffic identifyTraffic = new IdentifyTraffic();

        int lightTime = 0;
        String laneId = (String) roadInfo.get("laneId");
        String roadId = (String)roadInfo.get("roadId");
        int roadLength = (int)roadInfo.get("roadLength");
        int laneIndex = laneList.indexOf(laneId);
        int upperValue = upperArray[laneIndex];
        int lowerValue = lowerArray[laneIndex];

        int c = cArray[laneIndex];

        Map<String, Object> carNumberRequest = new LinkedHashMap<>();
        carNumberRequest.put("roadId", roadId);
        int carNum = (int)((Map<String, Object>)(identifyTraffic.carNumber(carNumberRequest).getResult())).get("carno");

        lightTime = (int)Math.round(((((double) carNum * (double) carNum) * (double) c) + (15.0 * (double) carNum)) / (500 * (double)roadLength));

        if(lightTime >= upperValue) lightTime = upperValue;
        else if (lightTime <= lowerValue) lightTime = lowerValue;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("trafficFlow", carNum);
        response.put("lightTime", lightTime);
        data = new Data(200, response);
        return data.getResponse();
    }

    @PostMapping("tool")
    private ResponseEntity<Map<String, Object>> tool(@RequestBody Map<String, Object> request){
        String intersectionId = (String)request.get("intersectionId");
        int isNS = (int)request.get("isNS");
        int carNum = (int)request.get("carNum");

        TimeRequest tRequest = new TimeRequest();
        tRequest.setIntersectionId(intersectionId);
        tRequest.setIsNS(isNS);

        final String[] lane = {"L01", "L02", "L03", "L04"};
        final List<String> laneList = Arrays.stream(lane).toList();
        final int[] cArray = {30, 30, 10, 10};
        final int[] upperArray = {130, 90, 60, 50};
        final int[] lowerArray = {90, 50, 20, 10};

        Map<String, Object> roadInfo = calculatorService.roadInfo(tRequest);
        IdentifyTraffic identifyTraffic = new IdentifyTraffic();

        double lightTime = 0;
        String laneId = (String) roadInfo.get("laneId");
        String roadId = (String)roadInfo.get("roadId");
        int roadLength = (int)roadInfo.get("roadLength");
        int laneIndex = laneList.indexOf(laneId);
        int upperValue = upperArray[laneIndex];
        int lowerValue = lowerArray[laneIndex];

        int c = cArray[laneIndex];

        lightTime = ((((double) carNum * (double) carNum) * (double) c) + (15.0 * (double) carNum)) / (500 * (double)roadLength);
        System.out.println(c);
        System.out.println(carNum);
        System.out.println(roadLength);
        System.out.println(lightTime);

        if(lightTime >= upperValue) lightTime = upperValue;
        else if (lightTime <= lowerValue) lightTime = lowerValue;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("trafficFlow", carNum);
        response.put("lightTime", lightTime);
        data = new Data(200, response);
        return data.getResponse();
    }

}
