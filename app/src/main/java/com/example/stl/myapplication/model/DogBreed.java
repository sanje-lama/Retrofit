package com.example.stl.myapplication.model;

import java.util.List;

public class DogBreed {

    private String status;
    private List<String> message;

    DogBreed() {}


    public String getStatus() {
        return status;
    }

    public List<String> getUrl() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


