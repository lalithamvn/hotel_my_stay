package com.example.hotelApp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotelApp.R;
import com.example.hotelApp.holder.CommentsHolder;
import com.example.hotelApp.models.CommentsSection;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsHolder> {

    List<CommentsSection> list = new ArrayList<>();
    Context context;

    public CommentsAdapter(List<CommentsSection> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CommentsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_section_list, parent, false);

        return new CommentsHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsHolder holder, int position) {
        holder.user.setText(list.get(position).getUser());
        holder.comment.setText(list.get(position).getComments());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
