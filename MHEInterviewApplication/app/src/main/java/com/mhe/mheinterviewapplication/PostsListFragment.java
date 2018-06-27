package com.mhe.mheinterviewapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by girish on 6/25/2018.
 */

public class PostsListFragment extends Fragment implements PostsAdapter.OnItemClicked {
    Context mContext;
    private ArrayList<Post> postList = new ArrayList<>();
    RecyclerView mRecyclerView;
    PostsAdapter mPostAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Context
        mContext = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_post_list, container, false);
        Bundle extras =  this.getArguments();
        if(extras != null) {
           postList.addAll ((ArrayList<Post>) extras.getSerializable("posts"));
            Log.d("GKON2", "onCreateView222: "+postList.size());
          mPostAdapter = new PostsAdapter(postList);
        }
        // Views
        mPostAdapter.setOnClick(this);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.post_list_recyclerView);
        mRecyclerView.setAdapter(mPostAdapter);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration divider = new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(rootView.getContext(), R.drawable.custom_divider));
        mRecyclerView.addItemDecoration(divider);

        return rootView;
    }

    @Override
    public void onItemClick(int position) {

        PostDetailFragment postDetailFragment = new PostDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("title", postList.get(position).getTitle());
        bundle.putSerializable("userId", postList.get(position).getUserId());
        bundle.putSerializable("body", postList.get(position).getBody());
        postDetailFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.frame_layout, postDetailFragment);
        fragmentTransaction.commit();

    }
}
