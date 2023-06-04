package com.example.sajava.trafficSystem;

import com.example.sajava.Data;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class IdentifyTraffic {
    private RestTemplate restTemplate = new RestTemplate();

    private static Data data;

    public Data carNumber(Map<String, Object> requestBody){
        String url = "http://localhost:3000/road-view";
        Map<String, Object> responseBody = restTemplate.postForObject(url, requestBody, Map.class );
        data = new Data(200, responseBody.get("response"));
        return data;
    }

    public boolean emergencyCar(){
        String url = "http://localhost:3000/road-view";
        boolean response = false;
        try{
            if(restTemplate.getForObject(url, boolean.class)) response = true;
        }catch (Exception e){
            response = false;
        }


        return response;
    }
}
