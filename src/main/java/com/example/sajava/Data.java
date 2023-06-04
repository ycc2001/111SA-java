package com.example.sajava;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    final String s = "statusCode", r = "response";
    private int code;
    private Object data;
    private Map<String, Object> response;

    public Data(){
        this(404, null);
    }
    public Data(int code, Object data){
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }
    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public ResponseEntity<Map<String, Object>> getResponse(){
        response = new LinkedHashMap<>();
        response.put(s, code);


        if(code/100 == 2) {
            response.put(r, data);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (code/100 == 4) {
            response.put(r, data);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            response.put(r, "failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    public Object getResult(){
        return this.data;
    }
}
