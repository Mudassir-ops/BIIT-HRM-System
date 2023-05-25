package com.example.biithrmsystem.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.biithrmsystem.api.WebService;
import com.example.biithrmsystem.api.datamodel.AllJobsReponse;
import com.example.biithrmsystem.api.datamodel.AttendenceModel;
import com.example.biithrmsystem.api.datamodel.Education;
import com.example.biithrmsystem.api.datamodel.Experience;
import com.example.biithrmsystem.api.datamodel.JobResponse;
import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.api.datamodel.SignupUserModel;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public MutableLiveData<UserSignInResponse> userSignInResponseLiveData = new MutableLiveData<>();
    public MutableLiveData<List<UserSignInResponse>> getUser = new MutableLiveData<List<UserSignInResponse>>();
    public MutableLiveData<List<AllJobsReponse>> allJobResponse = new MutableLiveData<List<AllJobsReponse>>();
    public MutableLiveData<String> postJobModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> postEducationModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> postExperienceModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> signupLiveData = new MutableLiveData<>();
    public MutableLiveData<String> updateUser = new MutableLiveData<>();
    public MutableLiveData<String> appyJob = new MutableLiveData<>();
    public MutableLiveData<String> attendeceModel = new MutableLiveData<>();
    public MutableLiveData<List<JobResponse>> allJobsReponseMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<AllJobsReponse>> allApplicantJob = new MutableLiveData<>();
    public MutableLiveData<List<JobResponse>> jobDetailLiveData = new MutableLiveData<>();

    public Repository() {
    }


    public MutableLiveData<String> getSignupLiveData() {
        return signupLiveData;
    }

    public MutableLiveData<String> getPostJobModelMutableLiveData() {
        return postJobModelMutableLiveData;
    }

    public MutableLiveData<List<UserSignInResponse>> getGetUser() {
        return getUser;
    }

    public MutableLiveData<UserSignInResponse> getUserSignInResponseLiveData() {
        return userSignInResponseLiveData;
    }

    public MutableLiveData<String> getUpdateUser() {
        return updateUser;
    }

    public MutableLiveData<String> getPostEducationModelMutableLiveData() {
        return postEducationModelMutableLiveData;
    }

    public MutableLiveData<String> getPostExperienceModelMutableLiveData() {
        return postExperienceModelMutableLiveData;
    }

    public MutableLiveData<List<JobResponse>> getAllJobsReponseMutableLiveData() {
        return allJobsReponseMutableLiveData;
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
                getUser.postValue(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<List<UserSignInResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }

    public void postEducation(Education education) {
        WebService.getWebApi().postEducation(education).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response);
                postEducationModelMutableLiveData.postValue(response.message());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }

    public void postExperience(Experience experience) {
        WebService.getWebApi().ExperiencePost(experience).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response);
                postExperienceModelMutableLiveData.postValue(response.message());

            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }

    public void AllJobApplicationGet() {
        WebService.getWebApi().AllJobApplicationGet().enqueue(new Callback<List<AllJobsReponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<AllJobsReponse>> call, @NonNull Response<List<AllJobsReponse>> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                allApplicantJob.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<AllJobsReponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);
//                userSignInResponseLiveData.postValue(null);
            }
        });
    }


    public void singUp(SignupUserModel signupUserModel) {
        WebService.getWebApi().signup(signupUserModel).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                signupLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

//                userSignInResponseLiveData.postValue(null);
            }
        });
    }


    public void jobGet() {
        WebService.getWebApi().jobGet().enqueue(new Callback<List<JobResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<JobResponse>> call, @NonNull Response<List<JobResponse>> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                allJobsReponseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<JobResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

            }
        });
    }

    public void jobDetail(int jid) {
        WebService.getWebApi().JobDetailGet(jid).enqueue(new Callback<List<JobResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<JobResponse>> call, @NonNull Response<List<JobResponse>> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                jobDetailLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<JobResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

            }
        });
    }

    public void updateUser(int uId, String fname, String lname, String mobile, String cnic, String gender, String dob, String email, String password, String address, String image, String role) {
        WebService.getWebApi().updateUser(uId, fname, lname, mobile, cnic, gender, dob, email, password, address, image, role).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                updateUser.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

            }
        });
    }


    public void JobFileApplicationPost(int jId, int Uid, String documentPath) {
        WebService.getWebApi().JobFileApplicationPost(jId, Uid, documentPath).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                appyJob.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

            }
        });
    }

    public void AttendancePost(AttendenceModel attendenceModel) {
        WebService.getWebApi().AttendancePost(attendenceModel).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponse: asdsa" + response.body());
                attendeceModel.postValue(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponse: asdsa" + t);

            }
        });
    }


}