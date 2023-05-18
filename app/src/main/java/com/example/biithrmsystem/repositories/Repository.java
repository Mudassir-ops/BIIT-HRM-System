package com.example.biithrmsystem.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.biithrmsystem.api.WebService;
import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public Repository() {
    }

    public MutableLiveData<UserSignInResponse> userSignInResponseLiveData = new MutableLiveData<>();
    public MutableLiveData<List<UserSignInResponse>> getUser = new MutableLiveData<List<UserSignInResponse>>();
    public MutableLiveData<String> postJobModelMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getPostJobModelMutableLiveData() {
        return postJobModelMutableLiveData;
    }

    public MutableLiveData<List<UserSignInResponse>> getGetUser() {
        return getUser;
    }

    public MutableLiveData<UserSignInResponse> getUserSignInResponseLiveData() {
        return userSignInResponseLiveData;
    }

    public LiveData<UserSignInResponse> userSignIn(String email, String password) {
        WebService.getWebApi().userSignIn(email, password).enqueue(new Callback<UserSignInResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserSignInResponse> call, @NonNull Response<UserSignInResponse> response) {
                if (response.isSuccessful()) {
                    userSignInResponseLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserSignInResponse> call, @NonNull Throwable t) {
                //    userSignInResponseLiveData.postValue(null);
            }
        });
        return userSignInResponseLiveData;
    }


    public void postJob(PostJobModel postJobModel) {
        WebService.getWebApi().postJob(postJobModel).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    postJobModelMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                //  postJobModelMutableLiveData.postValue(null);
            }
        });
    }

    public void getUser(int uid) {
        WebService.getWebApi().getUser(uid).enqueue(new Callback<List<UserSignInResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserSignInResponse>> call, @NonNull Response<List<UserSignInResponse>> response) {
                Log.e("sadsad", "onResponse: asdsa" + response);

                if (response.isSuccessful()) {
                    getUser.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<UserSignInResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }


    public void postEducation(int uid) {
        WebService.getWebApi().getUser(uid).enqueue(new Callback<List<UserSignInResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserSignInResponse>> call, @NonNull Response<List<UserSignInResponse>> response) {
                Log.e("sadsad", "onResponse: asdsa" + response);

                if (response.isSuccessful()) {
                    getUser.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<UserSignInResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }
}