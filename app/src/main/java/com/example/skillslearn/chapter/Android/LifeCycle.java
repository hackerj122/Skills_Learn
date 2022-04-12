package com.example.skillslearn.chapter.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.skillslearn.R;

public class LifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }
}