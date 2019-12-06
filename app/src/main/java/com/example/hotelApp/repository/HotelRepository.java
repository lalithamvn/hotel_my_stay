package com.example.hotelApp.repository;

import com.example.hotelApp.models.CommentsSection;
import com.example.hotelApp.models.Hotel;
import com.example.hotelApp.reposervice.ApiService;
import com.example.hotelApp.retrofit.RetroClient;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelRepository{

    private static HotelRepository hotelRepository;

    public static HotelRepository getInstance(){
        if (hotelRepository == null){
            hotelRepository = new HotelRepository();
        }
        return hotelRepository;
    }

    private ApiService newsApi;

    public HotelRepository(){
        newsApi = RetroClient.getApiService();
    }


    public MutableLiveData<Hotel> loadHotel() {
        Call<Hotel> call = newsApi.getHotel();
        final MutableLiveData<Hotel> hotelMutableLiveData = new MutableLiveData<>();
        call.enqueue(new Callback<Hotel>() {
            @Override
            public void onResponse(Call<Hotel> call, Response<Hotel> response) {
                hotelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Hotel> call, Throwable t) {

            }
        });
        return hotelMutableLiveData;
    }



    public MutableLiveData<List<CommentsSection>> loadComments() {
        Call<List<CommentsSection>> call = newsApi.getComments();
        final MutableLiveData<List<CommentsSection>> commentsMutableList = new MutableLiveData<>();
        call.enqueue(new Callback<List<CommentsSection>>() {
            @Override
            public void onResponse(Call<List<CommentsSection>> call, Response<List<CommentsSection>> response) {
                commentsMutableList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentsSection>> call, Throwable t) {

            }
        });
        return commentsMutableList;
    }


}