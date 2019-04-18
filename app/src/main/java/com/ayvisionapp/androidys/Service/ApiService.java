package com.ayvisionapp.androidys.Service;

import com.ayvisionapp.androidys.Model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;

public class ApiService {

    public void getUserList(Callback<UserModel> callback) {
        ApiClient service = ApiClientBuilder.getMGClient();
        Call<UserModel> result =  service.getUserData();
        result.enqueue(callback);
    }

    public void getUserDetails(Callback<UserModel> callback) {
        ApiClient service = ApiClientBuilder.getMGClient();
        Call<UserModel> resultdetails =  service.getUserDetails();
        resultdetails.enqueue(callback);
    }
}
