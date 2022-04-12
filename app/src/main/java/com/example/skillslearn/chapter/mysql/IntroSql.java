package com.example.skillslearn.chapter.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.skillslearn.R;

public class IntroSql extends AppCompatActivity {

    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_sql);

        desc = findViewById(R.id.desc);
        desc.setText(R.string.SqlDesc);
    }
}