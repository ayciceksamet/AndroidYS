package com.ayvisionapp.androidys.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

    public class UserModel {

        @SerializedName("results")
        @Expose
        private ArrayList results;

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("surname")
        @Expose
        private String surname;

        @SerializedName("dateofbirth")
        @Expose
        private String dateofbirth;

        @SerializedName("phoneNumber")
        @Expose
        private String phoneNumber;

        @SerializedName("address")
        @Expose
        private String address;


        public ArrayList getResults() {
            return results;
        }

        public void setResults(ArrayList results) {
            this.results = results;
        }


        public String getName() {
            return name;
        }

        public void setName(String phone) {
            this.name = name;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getSurName() {
            return surname;
        }

        public void setSurName(String name) {
            this.surname = surname;
        }


        public String getDateofbirth() {
            return dateofbirth;
        }

        public void setDateofbirth(String dateofbirth) {
            this.dateofbirth = dateofbirth;
        }


        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


    }

