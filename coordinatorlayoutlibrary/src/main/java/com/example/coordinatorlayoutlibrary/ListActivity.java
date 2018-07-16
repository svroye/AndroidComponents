package com.example.coordinatorlayoutlibrary;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    public void clickImage(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ImageView imageView = findViewById(R.id.image);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    imageView,
                    imageView.getTransitionName() )
                    .toBundle();
            startActivity(new Intent(ListActivity.this, DetailActivity.class),
                    bundle);
        }
    }
}
