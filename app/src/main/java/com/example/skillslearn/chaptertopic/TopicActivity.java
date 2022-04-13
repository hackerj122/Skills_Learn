package com.example.skillslearn.chaptertopic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.skillslearn.R;
import com.example.skillslearn.chapter.Android.EnvSetup;
import com.example.skillslearn.chapter.mysql.IntroSql;
import com.example.skillslearn.chapter.mysql.SqlOperator;
import com.example.skillslearn.chapter.mysql.SqlQuery;
import com.example.skillslearn.chapter.mysql.Sqldatatype;
import com.example.skillslearn.chapter.mysql.Sqlsyntax;

public class TopicActivity extends AppCompatActivity {

    Toolbar toolbar;
    ExtendableHeightGridview gridView;
    String chapterName,url;
    TopicAdapter adapter;
    String[] arr =null;
    ImageView chapterImg;



    String[] mysql ={"Introduction to Sql","SQL Syntax","SQL Data Types","SQL Operators","SQL Queries"};

    String[] WebDev ={"Introduction to WebDev","HTML","CSS","JavaScript", "Road Map"};

    String[] PostMan ={"Introduction to Postman","Making requests","Testing APIs","Building and managing APIs"};

    String[] Android ={"Introduction to Android","Environment Setup","Activity Life Cycle","UI Design"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        toolbar = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.TopicsName);
        gridView.setExpended(true);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!= null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chapterName = getIntent().getStringExtra("chapterName");
        url = getIntent().getStringExtra("url");
        chapterImg = findViewById(R.id.chapterImg);
        compareAndOpen();


    }

    private void compareAndOpen() {

        switch (chapterName) {
            case "mysql":
                arr = mysql;
                //chapterImg.setImageResource(R.drawable.kitten);
                Glide.with(TopicActivity.this).
                        load(url)
                        .into(chapterImg);
                getSupportActionBar().setTitle(chapterName);
                break;
            case "Web Dev":
                arr = WebDev;
                //chapterImg.setImageResource(R.drawable.logo);
                Glide.with(TopicActivity.this).
                        load(url)
                        .into(chapterImg);
                getSupportActionBar().setTitle(chapterName);
                break;
            case "Postman":
                arr = PostMan;
                //chapterImg.setImageResource(R.drawable.kitten);
                Glide.with(TopicActivity.this).
                        load(url)
                        .into(chapterImg);
                getSupportActionBar().setTitle(chapterName);
                break;
            case "Android Devlopement":
                arr = Android;
                //chapterImg.setImageResource(R.drawable.kitten);
                Glide.with(TopicActivity.this).
                        load(url)
                        .into(chapterImg);
                getSupportActionBar().setTitle(chapterName);
                break;
            default:
                arr = null;
                break;
        }
        adapter = new TopicAdapter(arr,TopicActivity.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivity(arr[position]);
            }
        });


    }

    private void openActivity(String s) {
        switch (s){
            //Mysql
            case "Introduction to Sql":
                startActivity(new Intent(TopicActivity.this, IntroSql.class));
                break;
            case "SQL Syntax":
                startActivity(new Intent(TopicActivity.this, Sqlsyntax.class));
                break;
            case "SQL Data Types":
                startActivity(new Intent(TopicActivity.this, Sqldatatype.class));
                break;
            case "SQL Operators":
                startActivity(new Intent(TopicActivity.this, SqlOperator.class));
                break;
            case "SQL Queries":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
                //Web Dev
            case "Introduction to WebDev":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "HTML":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "CSS":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "JavaScript":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "Road Map":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
                //Postman
            case "Introduction to Postman":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "Making requests":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "Testing APIs":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "Building and managing APIs":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
                //Android
            case "Introduction to Android":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "Environment Setup":
                startActivity(new Intent(TopicActivity.this, EnvSetup.class));
                break;
            case "Activity Life Cycle":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
            case "UI Design":
                startActivity(new Intent(TopicActivity.this, SqlQuery.class));
                break;
        }
    }
}