package com.example.hotelApp.models;

import com.google.gson.annotations.SerializedName;

public class CommentsSection {
    @SerializedName("id")
    private String id;
    @SerializedName("comment")
    private String comments;
    @SerializedName("user")
    private String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
