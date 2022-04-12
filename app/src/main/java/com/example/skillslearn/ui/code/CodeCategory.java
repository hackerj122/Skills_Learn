package com.example.skillslearn.ui.code;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.skillslearn.R;

public class CodeCategory extends AppCompatActivity {

    ListView programs;
    String [] list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_category);

        loadcategory();
        
        programs = findViewById(R.id.Programs);
        customAdapter adapter = new customAdapter();
        programs.setAdapter(adapter);
        programs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CodeCategory.this,codeActivity.class);
                intent.putExtra("position",list[position]);
                startActivity(intent);
            }
        });
    }

    private void loadcategory() {

        final String chap1[]= {"chapter1","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap2[]= {"chapter2","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap3[]= {"chapter3","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap4[]= {"chapter4","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap5[]= {"chapter5","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap6[]= {"chapter6","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap7[]= {"chapter7","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap8[]= {"chapter8","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};
        final String chap9[]= {"chapter9","wap to add 2 numbers.","wap to swap 2 number using 3 variable.","wap to swap 2 number without using 3third variable",
                "wap to read and display n numbers using an array."};


        String category = getIntent().getStringExtra("codeCategory");

        switch (category){
            case "chapter1":
                list = chap1;
                break;
            case "chapter2":
                list = chap2;
                break;
            case "chapter3":
                list = chap3;
                break;
            case "chapter4":
                list = chap4;
                break;
            case "chapter5":
                list = chap5;
                break;
            case "chapter6":
                list = chap6;
                break;
            case "chapter7":
                list = chap7;
                break;
            case "chapter8":
                list = chap8;
                break;
            case "chapter9":
                list = chap9;
                break;
        }
    }

    class customAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.code_category_item,null);
            TextView textView = convertView.findViewById(R.id.codeTitle);
            textView.setText(list[position]);
            return convertView;
        }
    }
}