package com.example.skillslearn.authentication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.skillslearn.PutData;
import com.example.skillslearn.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class RegisterActivity extends AppCompatActivity {

    EditText regName,regEmail,regPassword;
    Button reg_Button;
    private FirebaseAuth auth;
    ImageView userImage;
    static int REQUEST_CODE = 1;
    Uri pickedImageUri;
    ProgressBar progressBar;
    MotionLabel logRedirct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regName = findViewById(R.id.reg_name);
        regEmail = findViewById(R.id.reg_email);
        regPassword = findViewById(R.id.reg_password);
        reg_Button = findViewById(R.id.reg_button);
        userImage = findViewById(R.id.regimage);
        progressBar = findViewById(R.id.reg_progressBar);
        logRedirct =  findViewById(R.id.log_redirect);

        progressBar.setVisibility(View.GONE);
        auth = FirebaseAuth.getInstance();

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >=22) {
                    checkRequestPremission();
                }
                else{
                    openGalary();
                }
            }
        });
        reg_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        logRedirct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    private void checkRequestPremission() {
        if(ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(RegisterActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }
        else{
            openGalary();
        }
    }

    private void openGalary() {
        startActivityForResult(new Intent().setAction(Intent.ACTION_GET_CONTENT).setType("image/*"),REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if (data != null) {
                pickedImageUri = data.getData();
                userImage.setImageURI(pickedImageUri);
            }
        }
    }

    public void registerUser(){

        String name,email,password;

        name = regName.getText().toString().trim();
        email = regEmail.getText().toString().trim();
        password = regPassword.getText().toString().trim();
/*
        //by php regsiter
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Plz Fill the Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[2];
                    field[0] = "username";
                    field[1] = "password";
                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = email;
                    data[1] = password;
                    PutData putData;
                    putData = new PutData("http://192.168.0.110/androidDatabase/LogIn-SignUp/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            progressBar.setVisibility(View.GONE);
                            //End ProgressBar (Set visibility to GONE)
                            Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_SHORT).show();
                        }
                    }
                    //End Write and Read data with URL
                }
            });
        }
*/

        //by firebase
        if(name.isEmpty() || email.isEmpty() || TextUtils.isEmpty(password)|| pickedImageUri == null){
            Toast.makeText(this, "Plz Fill the Fields", Toast.LENGTH_SHORT).show();
        }
        else{
            progressBar.setVisibility(View.VISIBLE);
            auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                                updateUI(name,pickedImageUri,auth.getCurrentUser());
                                progressBar.setVisibility(View.GONE);
                            }
                            else{
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }

    }

    private void updateUI(String name, Uri pickedImageUri, FirebaseUser currentUser) {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("user_image");
        final StorageReference imagePath = storageReference.child(pickedImageUri.getLastPathSegment());
        imagePath.putFile(pickedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imagePath.getDownloadUrl().addOnSuccessListener(uri -> {
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .setPhotoUri(pickedImageUri)
                            .build();
                    currentUser.updateProfile(profileChangeRequest);
                });
            }
        });
    }
}