package com.example.hotelApp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotelApp.R;
import com.example.hotelApp.adapter.CommentsAdapter;
import com.example.hotelApp.models.CommentsSection;
import com.example.hotelApp.models.Hotel;
import com.example.hotelApp.utils.InternetConnection;
import com.example.hotelApp.utils.SharedPreferencesUtil;
import com.example.hotelApp.viewModel.CommentViewModel;
import com.example.hotelApp.viewModel.HotelViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HotelDetailsFragment extends Fragment {
    private TextView hotelName;
    private TextView hotelLocation;
    private TextView hotelDescription;
    private TextView hotelRating;
    private TextView hotelCustomer;
    private RecyclerView recyclerContacts;
    private SharedPreferencesUtil sharedPreferencesUtil;
    private HotelViewModel model;
    private ProgressDialog dialog;
    private List<CommentsSection> commentsSectionList;
    private View view;
    private CommentsAdapter adapter;
    private CommentViewModel cmodel;
    private String username;
    private String comments;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hotel_details_fragment, container, false);
        loadFragment(view);
        return view;

    }

    private void loadFragment(View view) {
        hotelName = (TextView)view. findViewById(R.id.hotel_name);
        hotelLocation = (TextView) view.findViewById(R.id.hotel_location);
        hotelDescription = (TextView) view.findViewById(R.id.hotel_description);
        hotelRating = (TextView) view.findViewById(R.id.hotel_rating) ;
        hotelCustomer = (TextView) view.findViewById(R.id.hotel_customers) ;
        recyclerContacts = (RecyclerView) view.findViewById(R.id.recyclerContacts);
        loadContactsData();
    }

    private CommentsSection loadComment() {
        cmodel = ViewModelProviders.of(getActivity()).get(CommentViewModel.class);;
        cmodel.getUsername().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                username = s;
            }
        });
        cmodel.getComments().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                comments = s;
            }
        });
        CommentsSection commentsSection = new CommentsSection(username,comments);
        return commentsSection;
    }


    protected void loadContactsData() {
        sharedPreferencesUtil = new SharedPreferencesUtil(getContext());
        if (InternetConnection.checkConnection(getContext())) {
            dialog = new ProgressDialog(getContext());
            dialog.setTitle("Getting JSON data");
            dialog.setMessage("Please wait...");
            dialog.show();
            model = ViewModelProviders.of(this).get(HotelViewModel.class);
            model.init();
            loadHotel();
            loadCommentSection();
        } else {
            Snackbar.make(view.findViewById(R.id.layoutMain), "Check your internet connection!", Snackbar.LENGTH_LONG).show();
        }
    }

    private void loadCommentSection() {
        model.getComments().observe(this, new Observer<List<CommentsSection>>() {
            @Override
            public void onChanged(List<CommentsSection> commentsSections) {
                dialog.dismiss();
                commentsSectionList = commentsSections;
                adapter = new CommentsAdapter(commentsSectionList, getContext());
                recyclerContacts.setAdapter(adapter);
                recyclerContacts.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });

    }

    private void loadHotel() {
        model.getHotel().observe(this, new Observer<Hotel>() {
            @Override
            public void onChanged(@Nullable Hotel hotel) {
                dialog.dismiss();
                hotelName.setText( hotel.getHotelName());
                hotelLocation.setText( hotel.getLocation());
                hotelDescription.setText( hotel.getDescription());
                hotelRating.setText( hotel.getRating());
                hotelCustomer.setText( hotel.getNumberOfReviews());

            }
        });
    }
    public void displayReceivedData(String user, String message)
    {
        username = user;
        comments = message;
    }
    @Override
    public void onResume() {
        super.onResume();
        if(loadComment() != null && commentsSectionList != null){
            adapter.notifyDataSetChanged();
        }
    }
}
