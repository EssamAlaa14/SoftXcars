package com.example.carsrestful.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsResponse {
    //Status property inside api response object
    @SerializedName("status")
    private int status;
    //Data property inside api response object
    @SerializedName("data")
    private List<Cars> data;

    //Setters and Getters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Cars> getData() {
        return data;
    }

    public void setData(List<Cars> data) {
        this.data = data;
    }
}
