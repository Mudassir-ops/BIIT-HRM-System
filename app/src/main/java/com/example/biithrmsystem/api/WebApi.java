package com.example.biithrmsystem.api;

import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface WebApi {

    @GET("User/Login")
    Call<UserSignInResponse> userSignIn(@Query("email") String email, @Query("password") String password);

    @POST("Job/JobPost")
    Call<String> postJob(@Body PostJobModel postJobModel);

    @GET("User/UserGet/{id}")
    Call<List<UserSignInResponse>> getUser(@Path(value = "id", encoded = true) int userId);


//    @POST("Education/EducationPost")
//    Call<List<UserSignInResponse>> postEducation(@Path(value = "id", encoded = true) int userId);


}






