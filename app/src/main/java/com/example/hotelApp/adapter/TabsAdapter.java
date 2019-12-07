package com.example.hotelApp.adapter;

import com.example.hotelApp.fragments.AddUserCommentFragment;
import com.example.hotelApp.fragments.HotelDetailsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                AddUserCommentFragment addUserCommentFragment = new AddUserCommentFragment();
                return addUserCommentFragment;
            case 1:
                HotelDetailsFragment hotelDetailsFragment = new HotelDetailsFragment();
                return hotelDetailsFragment;
            default:
                return null;
        }
    }
}
