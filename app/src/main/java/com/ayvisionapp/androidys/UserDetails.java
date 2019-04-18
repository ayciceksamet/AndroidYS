package com.ayvisionapp.androidys;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ayvisionapp.androidys.Model.UserModel;
import com.ayvisionapp.androidys.Service.ApiService;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetails extends AppCompatActivity {

    String TAG = "UserDetails";
    ArrayList<UserModel> userDetailData =new ArrayList<>();
    Button saveButton;
    EditText editTextAddress;
    EditText mobileNumber;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetailsactivity);
        saveButton = (Button) findViewById(R.id.buttonSave);
        getUserDetailData();

        // Receiving value into activity using intent.
        String TempHolder = getIntent().getStringExtra("ListViewClickedValue");

        setIndex(Integer.parseInt(TempHolder));


    }

    public void getUserDetailData() {
        try {

            new ApiService().getUserDetails(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                    Log.d(TAG, "onResponse: response..."+response);

                    //This will get result part from dummy JSON response
                    userDetailData = response.body().getResults();

                    setUserDetailData();

                }
                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {

                    Log.d(TAG, "onFailure: response...");
                    Log.d(TAG, t.getMessage());
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void setUserDetailData(){

        TextView detailedUsername = (TextView) findViewById(R.id.namedetailed);
        TextView detailedDateofBirth = (TextView) findViewById(R.id.detailedDateofBirth);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        mobileNumber = (EditText) findViewById(R.id.mobileNumber);

        Object getrow = userDetailData.get(getIndex() - 1);

        LinkedTreeMap<Object, Object> rowmap = (LinkedTreeMap) getrow;

        String name = rowmap.get("name").toString();
        String dateofbirth = rowmap.get("dateofbirth").toString();
        String address = rowmap.get("address").toString();
        String phoneNumber = rowmap.get("phoneNumber").toString();

        detailedUsername.setText(name);
        detailedDateofBirth.setText(dateofbirth);
        editTextAddress.setText(address);
        mobileNumber.setText(phoneNumber);

        SharedPreferences prefs = getSharedPreferences("yemsep", MODE_PRIVATE);
        if (prefs != null) {
            address = prefs.getString("address", address);//"No name defined" is the default value.
            phoneNumber = prefs.getString("phoneNumber", phoneNumber); //0 is the default value.
            editTextAddress.setText(address);
            mobileNumber.setText(phoneNumber);
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void onSaveDetails(View view) {
        Toast.makeText(this, "Just to show update operation !", Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = getSharedPreferences("yemseppref", MODE_PRIVATE).edit();
        editor.putString("address", editTextAddress.getText().toString());
        editor.putString("phoneNumber",mobileNumber.getText().toString());
        editor.apply();

    }

}