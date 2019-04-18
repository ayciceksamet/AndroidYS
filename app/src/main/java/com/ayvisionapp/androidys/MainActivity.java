package com.ayvisionapp.androidys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ayvisionapp.androidys.Model.UserModel;
import com.ayvisionapp.androidys.Service.ApiService;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView ;
    String TAG = "MainActivity";
    ArrayList<UserModel> dummyData =new ArrayList<>();
    static CustomListAdapter customListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Make a server call and get data
        getdata();

        listView = (ListView)findViewById(R.id.listShowJSONData);

        listView.setFocusable(false);

        // ListView on item selected listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object getrow = customListAdapter.getItem(position);
                LinkedTreeMap<Object, Object> rowmap = (LinkedTreeMap) getrow;
                String TempListViewClickedValue = rowmap.get("id").toString();

                Intent intent = new Intent("com.ayvisionapp.androidys.UserDetails");

                // Sending value to another activity using intent.
                intent.putExtra("ListViewClickedValue", TempListViewClickedValue);

                startActivity(intent);

            }
        });


    }


    public void getdata() {
        try {

            new ApiService().getUserList( new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                    Log.d(TAG, "onResponse: response..."+response);


                    //This will get result part from dummy JSON response
                    dummyData = response.body().getResults();
                    createListView();
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


    public  void createListView(){
        //Send JSON object list to custom BaseAdapter
        customListAdapter = new CustomListAdapter(getApplicationContext(), dummyData);
        listView = (ListView) findViewById(R.id.listShowJSONData);
        listView.setAdapter(customListAdapter);
    }

}
