package com.example.hotelApp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hotelApp.adapter.CommentsAdapter;
import com.example.hotelApp.models.CommentsSection;
import com.example.hotelApp.models.Hotel;
import com.example.hotelApp.utils.InternetConnection;
import com.example.hotelApp.utils.SharedPreferencesUtil;
import com.example.hotelApp.viewModel.HotelViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private TextView hotelName;
    private TextView hotelLocation;
    private TextView hotelDescription;
    private TextView hotelRating;
    private TextView hotelCustomer;
    private RecyclerView recyclerContacts;
    private  SharedPreferencesUtil sharedPreferencesUtil;
    private HotelViewModel model;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hotelName = (TextView) findViewById(R.id.hotel_name);
        hotelLocation = (TextView) findViewById(R.id.hotel_location);
        hotelDescription = (TextView) findViewById(R.id.hotel_description);
        hotelRating = (TextView) findViewById(R.id.hotel_rating) ;
        hotelCustomer = (TextView) findViewById(R.id.hotel_customers) ;
        recyclerContacts = (RecyclerView) findViewById(R.id.recyclerContacts);
        loadContactsData();
    }

    protected void loadContactsData() {
        sharedPreferencesUtil = new SharedPreferencesUtil(getApplicationContext());
        if (InternetConnection.checkConnection(getApplicationContext())) {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Getting JSON data");
            dialog.setMessage("Please wait...");
            dialog.show();
            model = ViewModelProviders.of(this).get(HotelViewModel.class);
            model.init();
            loadHotel();
            loadCommentSection();
        } else {
            Snackbar.make(findViewById(R.id.layoutMain), "Check your internet connection!", Snackbar.LENGTH_LONG).show();
        }
    }

    private void loadCommentSection() {
        model.getComments().observe(this, new Observer<List<CommentsSection>>() {
            @Override
            public void onChanged(List<CommentsSection> commentsSections) {
                dialog.dismiss();
                CommentsAdapter adapter = new CommentsAdapter(commentsSections, MainActivity.this);
                recyclerContacts.setAdapter(adapter);
                recyclerContacts.setLayoutManager(new LinearLayoutManager(MainActivity.this));
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
}
