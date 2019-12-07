package com.example.hotelApp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommentViewModel extends ViewModel {
    private MutableLiveData<String> username = new MutableLiveData<String>();
    private MutableLiveData<String> comments = new MutableLiveData<String>();

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username.setValue( username);
    }

    public MutableLiveData<String> getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments.setValue(comments);
    }
}
