package com.example.hotelApp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hotelApp.R;
import com.example.hotelApp.viewModel.CommentViewModel;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class AddUserCommentFragment  extends Fragment {
    private View view;
    private EditText user;
    private EditText comment;
    private Button submit;
    private CommentViewModel model;
    SendMessage sendMessage;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.add_comment_fragment, container, false);
        user = (EditText) view.findViewById(R.id.user_name);
        comment = (EditText) view.findViewById(R.id.user_comment);
        submit = (Button) view.findViewById(R.id.submit_button);
        model = ViewModelProviders.of(getActivity()).get(CommentViewModel.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setUsername(user.getText().toString());
                model.setComments(comment.getText().toString());
            }
        });

        return view;
    }

    public interface SendMessage{
        void sendData ( String name,String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
