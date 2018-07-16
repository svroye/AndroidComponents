package com.example.steven.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.example.steven.components.fragments.CollapsingToolbarLayoutFragment;
import com.example.steven.components.fragments.FloatingActionButtonFragment;
import com.example.steven.components.fragments.SpinnerFragment;
import com.example.steven.components.fragments.TextInputLayoutFragment;

public class ComponentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component_info);
        if (savedInstanceState == null) {
            Intent intent = getIntent();

            if (null == intent) finish();
            if (intent.hasExtra(getString(R.string.key_component_name))) {
                String name = intent.getStringExtra(getString(R.string.key_component_name));
                setTitle(name);
                inflateFragment(name);
            } else {
                finish();
            }
        }

    }

    private void inflateFragment(String name) {
        Fragment fragment = null;
        switch (name) {
            case "Floating Action Button":
                fragment = new FloatingActionButtonFragment();
                break;
            case "Spinner":
                fragment = new SpinnerFragment();
                break;
            case "TextInputLayout":
                fragment = new TextInputLayoutFragment();
                break;
            case "CollapsingToolbarLayoutFragment":
                fragment = new CollapsingToolbarLayoutFragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.componentInfo_frameLayout, fragment)
                .commit();
    }


}
