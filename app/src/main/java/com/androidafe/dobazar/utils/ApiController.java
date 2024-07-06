package com.androidafe.dobazar.utils;

import com.androidafe.dobazar.interfaces.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    static final String url = "https://romitp4l-ecommerce.000webhostapp.com/api/";
    private static ApiController clientObject;
    private static Retrofit retrofit;

    ApiController() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized ApiController getInstance(){
        if (clientObject == null){
            clientObject = new ApiController();
        }return clientObject;
    }

    public RetrofitClient getApi(){
        return retrofit.create(RetrofitClient.class);
    }
}
