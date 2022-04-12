package com.example.skillslearn.ui.code;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.skillslearn.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CodeFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CodeFragment newInstance(String param1, String param2) {
        CodeFragment fragment = new CodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    CircleImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code, container, false);

        image1 = view.findViewById(R.id.chapter1);
        image2 = view.findViewById(R.id.chapter2);
        image3 = view.findViewById(R.id.chapter3);
        image4 = view.findViewById(R.id.chapter4);
        image5 = view.findViewById(R.id.chapter5);
        image6 = view.findViewById(R.id.chapter6);
        image7 = view.findViewById(R.id.chapter7);
        image8 = view.findViewById(R.id.chapter8);
        image9 = view.findViewById(R.id.chapter9);

        loadimage();

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);
        image7.setOnClickListener(this);
        image8.setOnClickListener(this);
        image9.setOnClickListener(this);

        return view;
    }
    private void loadimage() {

        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image1);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image2);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image3);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image4);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image5);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image6);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image7);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image8);
        Glide.with(getContext()).
                load("https://firebasestorage.googleapis.com/v0/b/skills-learn.appspot.com/o/logoa.jpg?alt=media&token=6f1443d2-ea25-42b3-b303-778948edf1dc")
                .into(image9);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),CodeCategory.class);
        switch(v.getId()){
            case R.id.chapter1:
                intent.putExtra("codeCategory","chapter1");
                startActivity(intent);
                break;
            case R.id.chapter2:
                intent.putExtra("codeCategory","chapter2");
                startActivity(intent);
                break;
            case R.id.chapter3:
                intent.putExtra("codeCategory","chapter3");
                startActivity(intent);
                break;
            case R.id.chapter4:
                intent.putExtra("codeCategory","chapter4");
                startActivity(intent);
                break;
            case R.id.chapter5:
                intent.putExtra("codeCategory","chapter5");
                startActivity(intent);
                break;
            case R.id.chapter6:
                intent.putExtra("codeCategory","chapter6");
                startActivity(intent);
                break;
            case R.id.chapter7:
                intent.putExtra("codeCategory","chapter7");
                startActivity(intent);
                break;
            case R.id.chapter8:
                intent.putExtra("codeCategory","chapter8");
                startActivity(intent);
                break;
            case R.id.chapter9:
                intent.putExtra("codeCategory","chapter9");
                startActivity(intent);
                break;
        }
    }
}
