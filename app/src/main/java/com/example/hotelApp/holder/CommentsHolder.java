package com.example.hotelApp.holder;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hotelApp.R;

public class CommentsHolder extends RecyclerView.ViewHolder {

    public CardView cardContact;
    public TextView user;
    public TextView comment;

    public CommentsHolder(View itemView) {
        super(itemView);
        cardContact = (CardView) itemView.findViewById(R.id.cardContact);
        user = (TextView) itemView.findViewById(R.id.user);
        comment = (TextView) itemView.findViewById(R.id.comment);

    }
}
