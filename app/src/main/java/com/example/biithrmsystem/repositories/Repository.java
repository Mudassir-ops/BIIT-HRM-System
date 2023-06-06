package com.example.biithrmsystem.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.biithrmsystem.api.WebService;
import com.example.biithrmsystem.api.datamodel.AllJobsReponse;
import com.example.biithrmsystem.api.datamodel.AttendenceModel;
import com.example.biithrmsystem.api.datamodel.ComitteeBaseResponseModel;
import com.example.biithrmsystem.api.datamodel.Education;
import com.example.biithrmsystem.api.datamodel.Experience;
import com.example.biithrmsystem.api.datamodel.JobApplciantResponse;
import com.example.biithrmsystem.api.datamodel.JobResponse;
import com.example.biithrmsystem.api.datamodel.LeaveDetailResponse;
import com.example.biithrmsystem.api.datamodel.LeaveModel;
import com.example.biithrmsystem.api.datamodel.MemberOfComittieReponse;
import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.api.datamodel.SignupUserModel;
import com.example.biithrmsystem.api.datamodel.UserRoleResponse;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public MutableLiveData<UserSignInResponse> userSignInResponseLiveData = new MutableLiveData<>();
    public MutableLiveData<List<UserSignInResponse>> getUser = new MutableLiveData<List<UserSignInResponse>>();
    public MutableLiveData<List<AllJobsReponse>> allJobResponse = new MutableLiveData<List<AllJobsReponse>>();


    public MutableLiveData<List<JobApplciantResponse>> allJobApplicantLivedata = new MutableLiveData<List<JobApplciantResponse>>();
    public MutableLiveData<List<ComitteeBaseResponseModel>> allCOmittereponse = new MutableLiveData<List<ComitteeBaseResponseModel>>();
    public MutableLiveData<List<UserRoleResponse>> userRoleGet = new MutableLiveData<List<UserRoleResponse>>();
    public MutableLiveData<List<MemberOfComittieReponse>> comittieMembers = new MutableLiveData<List<MemberOfComittieReponse>>();
    public MutableLiveData<List<LeaveDetailResponse>> leaveDetailResponse = new MutableLiveData<List<LeaveDetailResponse>>();
    public MutableLiveData<List<LeaveModel>> leaveApplications = new MutableLiveData<List<LeaveModel>>();
    public MutableLiveData<String> postJobModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> postEducationModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> postExperienceModelMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> signupLiveData = new MutableLiveData<>();
    public MutableLiveData<String> updateUser = new MutableLiveData<>();
    public MutableLiveData<String> appyJob = new MutableLiveData<>();
    public MutableLiveData<String> deleteComitte = new MutableLiveData<>();
    public MutableLiveData<String> addMemebr = new MutableLiveData<>();
    public MutableLiveData<String> attendeceModel = new MutableLiveData<>();
    public MutableLiveData<List<JobResponse>> allJobsReponseMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<AllJobsReponse>> allApplicantJob = new MutableLiveData<>();
    public MutableLiveData<List<JobResponse>> jobDetailLiveData = new MutableLiveData<>();

    public Repository() {
    }

    public MutableLiveData<List<JobApplciantResponse>> getAllJobApplicantLivedata() {
        return allJobApplicantLivedata;
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
                assert response.body() != null;
                Log.e("sadsad", "onResponse: asdsa" + response.body().get(0).title);


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

    public void JobFileApplicationPost(int jId, int Uid, String documentPath, String name) {
        WebService.getWebApi().JobApplicationPost(jId, Uid, documentPath, name).enqueue(new Callback<String>() {
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

    public void JoinJobApplicationwithidGet(int appid) {
        WebService.getWebApi().JoinJobApplicationwithidGet(appid).enqueue(new Callback<List<JobApplciantResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<JobApplciantResponse>> call, @NonNull Response<List<JobApplciantResponse>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                allJobApplicantLivedata.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<JobApplciantResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }

    public void AllCommitteeGet() {
        WebService.getWebApi().AllCommitteeGet().enqueue(new Callback<List<ComitteeBaseResponseModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ComitteeBaseResponseModel>> call, @NonNull Response<List<ComitteeBaseResponseModel>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                allCOmittereponse.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<ComitteeBaseResponseModel>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }


    public void deleteCommittee(int id) {
        WebService.getWebApi().deleteCommittee(id).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                deleteComitte.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }

    public void UserroleGet() {
        WebService.getWebApi().UserroleGet().enqueue(new Callback<List<UserRoleResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<UserRoleResponse>> call, @NonNull Response<List<UserRoleResponse>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                userRoleGet.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<UserRoleResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }


    public void Createcommitte(String comittieTitle, int commitieHead) {
        WebService.getWebApi().Createcommitte(comittieTitle, commitieHead).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                deleteComitte.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }

    public void CreateCommitteMember(int comittieId, int userId) {
        WebService.getWebApi().Createcommittemember(comittieId, userId).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                addMemebr.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }


    public void JobappWithCommitteeGet(int commitId) {
        WebService.getWebApi().JobappWithCommitteeGet(commitId).enqueue(new Callback<List<MemberOfComittieReponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<MemberOfComittieReponse>> call, @NonNull Response<List<MemberOfComittieReponse>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                comittieMembers.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<MemberOfComittieReponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }

    public void AllLeaveGet() {
        WebService.getWebApi().AllLeaveGet().enqueue(new Callback<List<LeaveModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<LeaveModel>> call, @NonNull Response<List<LeaveModel>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                leaveApplications.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<LeaveModel>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }


    public void LeaveWithIDGet(int id) {
        WebService.getWebApi().LeaveWithIDGet(id).enqueue(new Callback<List<LeaveDetailResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<LeaveDetailResponse>> call, @NonNull Response<List<LeaveDetailResponse>> response) {
                Log.e("sadsad", "onResponseNew: asdsa" + response.body());
                leaveDetailResponse.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<LeaveDetailResponse>> call, @NonNull Throwable t) {
                Log.e("sadsad", "onResponseNew: asdsa" + t);

            }
        });
    }
}