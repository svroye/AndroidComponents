package com.example.viewpagerlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewPagerHomeActivity extends AppCompatActivity
        implements ViewPagerOptionsAdapter.OnOptionSelectionListener{

    RecyclerView mRecyclerView;
    String[] options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_home);

        mRecyclerView = findViewById(R.id.viewpager_recylerview);

        options = getResources().getStringArray(R.array.viewpager_options);
        ViewPagerOptionsAdapter adapter = new ViewPagerOptionsAdapter(options, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setHasFixedSize(true);

    }

    @Override
    public void onViewPagerOptionSelected(int position) {
        if (options[position].equals("Swipe Views")) {
             startActivity(new Intent(ViewPagerHomeActivity.this,
                     ViewPagerSwipeViews.class));
        } else if(options[position].equals("Action Bar Tabs")) {

        } else {

        }
    }
}
