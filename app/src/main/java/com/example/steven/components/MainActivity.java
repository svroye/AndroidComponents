package com.example.steven.components;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnListItemClickClistener {

    private RecyclerView recyclerView;
    private String[] components;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        components = getResources().getStringArray(R.array.components_names);

        recyclerView = findViewById(R.id.activityMain_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(components, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(int position) {
        if (components[position] == "CollapsingToolbarLayoutFragment") {
            startActivity(new Intent(MainActivity.this,
                    com.example.coordinatorlayoutlibrary.ListActivity.class));
        } else {
            Intent intent = new Intent(MainActivity.this, ComponentInfoActivity.class);
            intent.putExtra(getString(R.string.key_component_name), components[position]);
            startActivity(intent);
        }
    }
}
