package com.example.skillslearn.chapter.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.skillslearn.R;

public class Sqlsyntax extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlsyntax);


        webView = findViewById(R.id.SyntexWebView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+"https://www.halvorsen.blog/documents/tutorials/resources/Structured%20Query%20Language.pdf");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}