package com.example.a571j.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a571j.Models.Feed;
import com.example.a571j.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Feed> items;

    public FeedAdapter(Context context, ArrayList<Feed> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.videos, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Feed feed = items.get(position);

        if (holder instanceof FeedViewHolder){
            Glide.with(context).load(feed.profile).into(((FeedViewHolder) holder).iv_profile);
            Glide.with(context).load(feed.photo).into(((FeedViewHolder) holder).photo);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FeedViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView iv_profile;
        ImageView photo;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_profile = itemView.findViewById(R.id.iv_profile);
            photo = itemView.findViewById(R.id.iv_video);
        }
    }
}
