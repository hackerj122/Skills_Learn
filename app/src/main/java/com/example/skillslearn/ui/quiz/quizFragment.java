package com.example.skillslearn.ui.quiz;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.skillslearn.R;
import com.example.skillslearn.authentication.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class quizFragment extends Fragment {

    public quizFragment() {
        // Required empty public constructor
    }

    Button playQuiz;
    FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        playQuiz = root.findViewById(R.id.play_quiz);

        user = FirebaseAuth.getInstance().getCurrentUser();

        playQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user != null)
                {
                    startActivity(new Intent(getContext(),StartQuiz.class));
                }
                else{
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
            }
        });
        return root;
    }
}