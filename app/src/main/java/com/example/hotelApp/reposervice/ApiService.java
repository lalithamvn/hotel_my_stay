package com.example.hotelApp.reposervice;

import java.util.List;

import com.example.hotelApp.models.CommentsSection;
import com.example.hotelApp.models.Hotel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/workshop/hotel")
    Call<Hotel> getHotel();

    @GET("api/workshop/comments")
    Call<List<CommentsSection>> getComments();
}
