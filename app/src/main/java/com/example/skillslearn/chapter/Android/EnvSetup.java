package com.example.skillslearn.chapter.Android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.skillslearn.R;

public class EnvSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_env_setup);

        WebView and_env;

        and_env = findViewById(R.id.and_env);
        and_env.getSettings().setJavaScriptEnabled(true);

        and_env.loadUrl("http://docs.google.com/gview?embedded=true&url="+"https://dducollegedu.ac.in/Datafiles/cms/ecourse%20content/Android%20-%20Environment%20Setup.pdfs");

        and_env.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}