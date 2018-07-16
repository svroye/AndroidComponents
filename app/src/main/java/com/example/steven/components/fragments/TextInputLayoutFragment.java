package com.example.steven.components.fragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.steven.components.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextInputLayoutFragment extends Fragment {


    public TextInputLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_input_layout, container, false);

        final TextInputLayout passwordLayout = view.findViewById(R.id.textInputLayout);
        final EditText passwordEditText = view.findViewById(R.id.pasword);

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String pasword = passwordEditText.getText().toString().trim();
                int l = pasword.length();
                if (l < 10) {
                    passwordLayout.setError("Still " + (10-l) + " characters to type!");
                } else {
                    passwordLayout.setErrorEnabled(false);
                }
            }
        });
        return view;
    }

}
