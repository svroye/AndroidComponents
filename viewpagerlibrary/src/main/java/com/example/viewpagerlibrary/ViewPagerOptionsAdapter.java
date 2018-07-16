package com.example.viewpagerlibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerOptionsAdapter extends RecyclerView.Adapter<ViewPagerOptionsAdapter.ViewPagerOptionsViewHolder> {

    String[] data;
    OnOptionSelectionListener optionListener;

    public interface OnOptionSelectionListener {
        void onViewPagerOptionSelected(int position);
    }

    public ViewPagerOptionsAdapter(String[] data, OnOptionSelectionListener listener) {
        this.data = data;
        this.optionListener = listener;
    }


    @NonNull
    @Override
    public ViewPagerOptionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_viewpager_option,
                parent, false);
        ViewPagerOptionsViewHolder viewHolder = new ViewPagerOptionsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerOptionsViewHolder holder, int position) {
        holder.textView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        if (null == data) return 0;
        return data.length;
    }

    public class ViewPagerOptionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;

        public ViewPagerOptionsViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_viewpagerOption);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            optionListener.onViewPagerOptionSelected(getAdapterPosition());
        }
    }
}
