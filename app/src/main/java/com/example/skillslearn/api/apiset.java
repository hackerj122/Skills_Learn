package com.example.skillslearn.api;

import com.example.skillslearn.DAO_Adapter.Category;
import com.example.skillslearn.DAO_Adapter.Subject;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {

    @GET("json.php")
    Call<List<Category>> getData();
    @POST("subject_json.php")
    Call<List<Subject>> getSub(@Field("category") String category);
}
