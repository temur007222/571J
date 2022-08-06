package com.example.a571j.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a571j.Models.Filter;
import com.example.a571j.R;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Filter> list;

    int EXPLORE = 0, CONTENTS = 1;

    public FilterAdapter(Context context, ArrayList<Filter> list) {
        this.context = context;
        this.list = list;
    }

    boolean isHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) {
            return EXPLORE;
        }
        return CONTENTS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == EXPLORE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.explore, parent, false);
            return new ExploreViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content, parent, false);
        return new ContentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Filter main = list.get(position);
        if (holder instanceof ExploreViewHolder) {

        }
        if (holder instanceof ContentsViewHolder) {
            ((ContentsViewHolder) holder).contents.setText(main.title);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ExploreViewHolder extends RecyclerView.ViewHolder {
        public ExploreViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    public class ContentsViewHolder extends RecyclerView.ViewHolder {
        TextView contents;

        public ContentsViewHolder(@NonNull View itemView) {
            super(itemView);
            contents = itemView.findViewById(R.id.contents_text_id);
        }
    }
}
