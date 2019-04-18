package com.ayvisionapp.androidys;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ayvisionapp.androidys.Model.UserModel;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {


    Context c;
    ArrayList<UserModel> users;

    public CustomListAdapter(Context c, ArrayList<UserModel> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return this.users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.json_data_list, viewGroup, false);
        }

        TextView mUserName = (TextView) view.findViewById(R.id.userName);
        TextView mUserSurname = (TextView) view.findViewById(R.id.userSurname);
        TextView mUserDateofBirth = (TextView) view.findViewById(R.id.userDateofBirth);


        Object getrow = this.users.get(i);
        LinkedTreeMap<Object, Object> rowmap = (LinkedTreeMap) getrow;
        String name = rowmap.get("name").toString();
        String surname = rowmap.get("surname").toString();
        String dateofbirth = rowmap.get("dateofbirth").toString();

        mUserName.setText(name);
        mUserSurname.setText(surname);
        mUserDateofBirth.setText(dateofbirth);

        return view;
    }

}
