package com.example.skillslearn.chapter.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.skillslearn.R;

public class SqlOperator extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_operator);
        webView = findViewById(R.id.OperatorWeb);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://dbms-sql-syntax.blogspot.com/p/sql-operators-every-database.html");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}