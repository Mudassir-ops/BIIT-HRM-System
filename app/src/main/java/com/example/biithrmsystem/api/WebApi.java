package com.example.biithrmsystem.api;

import com.example.biithrmsystem.api.datamodel.AllJobApplicant;
import com.example.biithrmsystem.api.datamodel.AllJobsReponse;
import com.example.biithrmsystem.api.datamodel.Education;
import com.example.biithrmsystem.api.datamodel.Experience;
import com.example.biithrmsystem.api.datamodel.Job;
import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.api.datamodel.SignupUserModel;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebApi {

    @GET("User/Login")
    Call<UserSignInResponse> userSignIn(@Query("email") String email, @Query("password") String password);

    @POST("Job/JobPost")
    Call<String> postJob(@Body PostJobModel postJobModel);

    @GET("User/UserGet/{id}")
    Call<List<UserSignInResponse>> getUser(@Path(value = "id", encoded = true) int userId);

    @POST("Education/EducationPost")
    Call<String> postEducation(@Body Education education);

    @POST("Expereince/ExperiencePost")
    Call<String> ExperiencePost(@Body Experience experience);

    @GET("JobApplication/AllJobApplicationGet")
    Call<List<AllJobsReponse>> AllJobApplicationGet();

    @POST("User/Signup")
    Call<String> signup(@Body SignupUserModel signupUserModel);

    @FormUrlEncoded
    @PUT("User/UpdateUser")
    Call<String> updateUser(@Field("Uid") int Uid, @Field("fname") String fname, @Field("lname") String lname, @Field("mobile") String mobile, @Field("cnic") String cnic, @Field("gender") String gender, @Field("dob") String dob, @Field("email") String email, @Field("password") String password, @Field("address") String address, @Field("image") String image);

    @GET("Job/JobGet")
    Call<List<Job>> jobGet();

    @GET("Job/JobDetailGet")
    Call<List<Job>> JobDetailGet(@Query("jid") int jid);

//    @GET("JobApplication/AllJobApplicationGet")
//    Call<List<AllJobApplicant>> AllJobApplicationGet();

    @FormUrlEncoded
    @POST("JobApplication/JobFileApplicationPost")
    Call<String> JobFileApplicationPost(@Field("Jid") int Jid, @Field("Uid") int Uid, @Field("DocumentPath") String DocumentPath);


}






