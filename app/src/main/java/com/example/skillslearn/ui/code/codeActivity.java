package com.example.skillslearn.ui.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.skillslearn.R;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class codeActivity extends AppCompatActivity {

    CodeView codeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        codeView = findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.ANDROIDSTUDIO);
        loadProgram();
    }

    private void loadProgram() {
        String code = null;
        switch (getIntent().getStringExtra("position")){
            case "chapter1":
                code= ProgramExample.ex1;
                break;
            case "chapter2":
                code= ProgramExample.ex2;
                break;
            case "chapter3":
                code= ProgramExample.ex3;
                break;
            case "chapter4":
                code= ProgramExample.ex4;
                break;
        }
        codeView.showCode(code);
    }
}