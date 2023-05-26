package com.example.sajava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "the_test")
public class TestModel{

    @Id
    private Long id;
    private String testString;

    public TestModel(Long id, String testSting){
        this.id = id;
        this.testString = testSting;
    }

    public TestModel() {

    }

    public Long getId() {
        return id;
    }
    public String getTestString(){
        return  testString;
    }
}
