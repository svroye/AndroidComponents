package com.example.steven.components;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Steven on 27/06/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data;
    OnListItemClickClistener clickClistener;

    public interface OnListItemClickClistener {
        void onItemClick(int position);
    }

    public MyAdapter(String[] data, OnListItemClickClistener onListItemClickClistener) {
        this.data =  data;
        this.clickClistener = onListItemClickClistener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameTextView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        if ( null == data) return 0;
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.listItem_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickClistener.onItemClick(getAdapterPosition());
        }
    }
}
