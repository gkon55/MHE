package com.mhe.mheinterviewapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by girish on 6/25/2018.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    public interface OnItemClicked {
        void onItemClick(int position);
    }

    private ArrayList<Post> postList;
    private OnItemClicked listener;

    public PostsAdapter(ArrayList<Post> postList){
        this.postList = postList;
    }
    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_row, parent, false);

        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, final int position) {
        Post post = postList.get(position);
        holder.getPostTitle().setText(post.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
    public void setOnClick(OnItemClicked onClick)
    {
        this.listener=onClick;
    }
    public class PostsViewHolder extends RecyclerView.ViewHolder {

        public TextView postTitle;

        public PostsViewHolder(View view) {
            super(view);
            postTitle = (TextView) view.findViewById(R.id.title_textView);
        }
        public TextView getPostTitle() {
            return postTitle;
        }

    }

}
