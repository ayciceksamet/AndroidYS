package com.ayvisionapp.androidys.Service;

import com.ayvisionapp.androidys.Model.AuthModel;
import com.ayvisionapp.androidys.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoginService {


    @GET("{username}/{password}")
    Call<AuthModel> login(@Path("username") String username, @Path("password") String password);

}
