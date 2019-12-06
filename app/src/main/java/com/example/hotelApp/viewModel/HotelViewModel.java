package com.example.hotelApp.viewModel;

import com.example.hotelApp.models.CommentsSection;
import com.example.hotelApp.models.Hotel;
import com.example.hotelApp.repository.HotelRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HotelViewModel extends ViewModel {

    private MutableLiveData<List<CommentsSection>> commentsList;
    private MutableLiveData<Hotel> hotel;
    private HotelRepository hotelRepository;


    public void init(){

        hotelRepository = HotelRepository.getInstance();
        getHotel();
        getComments();

    }



    public LiveData<Hotel> getHotel() {
        if (hotel == null) {
            hotel = new MutableLiveData<Hotel>();
            hotel = hotelRepository.loadHotel();
        }
        return hotel;
    }



    public LiveData<List<CommentsSection>> getComments() {
        if (commentsList == null) {
            commentsList = new MutableLiveData<List<CommentsSection>>();
            commentsList = hotelRepository.loadComments();
        }
        return commentsList;
    }


}