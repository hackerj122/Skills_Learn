package com.example.skillslearn.chapter.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.skillslearn.R;

public class Sqldatatype extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldatatype);

        webView = findViewById(R.id.DatatypeWebView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+"https://www.mysqltutorial.org/wp-content/uploads/2018/03/MySQL-Data-Types.pdf");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}