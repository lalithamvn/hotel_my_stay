package com.example.hotelApp.models;


import com.google.gson.annotations.SerializedName;

public class Hotel {
    @SerializedName("name")
    private String hotelName;
    @SerializedName("description")
    private String description;
    @SerializedName("location")
    private String location;
    @SerializedName("rating")
    private String rating;
    @SerializedName("numberOfReviews")
    private String numberOfReviews;
    @SerializedName("cost")
    private String cost;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(String numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
