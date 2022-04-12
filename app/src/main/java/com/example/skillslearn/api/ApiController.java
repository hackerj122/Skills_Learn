package com.example.skillslearn.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static final String URL = "https://android-database-api.000webhostapp.com/";
    private static ApiController  controller;
    private static Retrofit retrofit;

    ApiController(){
        retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiController getInstance(){
        if(controller == null)
            controller = new ApiController();

        return controller;
    }

    public apiset getapi(){
        return retrofit.create(apiset.class);
    }
}
