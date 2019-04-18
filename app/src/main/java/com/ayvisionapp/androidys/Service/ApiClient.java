package com.ayvisionapp.androidys.Service;


import com.ayvisionapp.androidys.Model.UserModel;

import org.json.JSONArray;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


    public interface ApiClient {

        @GET("userinfo")
        Call<UserModel> getUserData();

        @GET("userdetailedinfo")
        Call<UserModel> getUserDetails();

/*
        @GET("/v2/5cb69847320000b30dcd44db")
        Call<UserModel> getUserData();

        @GET("/v2/5cb69faf320000b40dcd44e8") //Idealinde username veya id parametresi eklenerek cekilmelidir. Asagida ornek bir servis vardir.
        Call<UserModel> getUserDetails();
*/
       // @GET("/v2/{id}")
       // Call<UserModel> getUserDetails(@Path("id") String id);

    }

