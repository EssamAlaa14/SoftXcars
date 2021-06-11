package com.example.carsrestful.model;

import com.google.gson.annotations.SerializedName;

//Car model properties as listed inside api response object
public class Cars {
    @SerializedName("id")
    private int id;
    @SerializedName("brand")
    private String brand;
    @SerializedName("constructionYear")
    private String constructionYear;
    @SerializedName("isUsed")
    private Boolean isUsed;
    @SerializedName("imageUrl")
    private String imageUrl;

    public Cars(int id, String brand, String constructionYear, Boolean isUsed, String imageUrl) {
        this.id = id;
        this.brand = brand;
        this.constructionYear = constructionYear;
        this.isUsed = isUsed;
        this.imageUrl = imageUrl;
    }

    //Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
