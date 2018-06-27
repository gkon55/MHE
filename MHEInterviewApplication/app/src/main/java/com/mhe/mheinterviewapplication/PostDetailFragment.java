package com.mhe.mheinterviewapplication;

import android.support.v4.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by girish on 6/26/2018.
 */

public class PostDetailFragment extends Fragment {

    private TextView postTitleTextView;
    private TextView postUserIDTextView;
    private TextView postBodyTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_post_detail, container, false);
        postTitleTextView = (TextView)rootView.findViewById(R.id.post_title2_textView);
        postUserIDTextView = (TextView)rootView.findViewById(R.id.post_userId_textView);
        postBodyTextView = (TextView)rootView.findViewById(R.id.post_body_textView);

        Bundle extras =  this.getArguments();
        if(extras != null) {
            postTitleTextView.setText("Title: " + extras.get("title"));
            postUserIDTextView.setText("User ID: " + extras.get("userId"));
            postBodyTextView.setText(extras.get("body").toString());
        }

        return rootView;
    }

}
