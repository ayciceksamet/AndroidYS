# Android Application User Information List :

- Login Screen
- UserList Screen
- Users Detailed Information Screen

## The RestAPI Paths :

BASE URL      : https://vrest.io/i/yemsep/m/SP/

The default username / password    : admin/admin

Web service A to auth login        : Call<AuthModel> login(@Path("username") String username, @Path("password") String password);
  
Web service B to get USER INFO     : Call<UserModel> getUserData();
  
Web service C to get USER DETALILS : Call<UserModel> getUserDetails();

The update operation of User details are implemented as dummy to sharedpreferences. The local DB or remote server will be triggered with rest call to updated these informations successfully.

You can download the apk from :

https://drive.google.com/open?id=1u99gneNpUkpaw1ACV1yrJf40yjWFibks


