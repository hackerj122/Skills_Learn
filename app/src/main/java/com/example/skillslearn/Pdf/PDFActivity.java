package com.example.skillslearn.Pdf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skillslearn.R;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;

import java.io.File;

public class PDFActivity extends AppCompatActivity implements OnLoadCompleteListener, OnPageErrorListener {

    ProgressBar pdfViewProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        final WebView pdfView= findViewById(R.id.pdfView);
        pdfViewProgressBar=findViewById(R.id.pdfViewProgressBar);

        pdfViewProgressBar.setVisibility(View.VISIBLE);

        //UNPACK OUR DATA FROM INTENT
        Intent i=this.getIntent();
        final String path=i.getExtras().getString("PATH");
        pdfView.getSettings().setJavaScriptEnabled(true);

        pdfView.loadUrl("https://docs.google.com/gview?embedded=true&url="+path);
        pdfView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
    @Override
    public void loadComplete(int nbPages) {
        pdfViewProgressBar.setVisibility(View.GONE);
        Toast.makeText(PDFActivity.this, String.valueOf(nbPages), Toast.LENGTH_LONG).show();
    }
    @Override
    public void onPageError(int page, Throwable t) {
        pdfViewProgressBar.setVisibility(View.GONE);
        Toast.makeText(PDFActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
    }
}
