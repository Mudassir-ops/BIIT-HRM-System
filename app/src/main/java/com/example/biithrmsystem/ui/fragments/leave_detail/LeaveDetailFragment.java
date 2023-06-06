package com.example.biithrmsystem.ui.fragments.leave_detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.biithrmsystem.api.datamodel.LeaveDetailResponse;
import com.example.biithrmsystem.databinding.FragmentLeaveDetailBinding;
import com.example.biithrmsystem.repositories.Repository;


public class LeaveDetailFragment extends Fragment {
    private FragmentLeaveDetailBinding binding;
    private Repository repository;

    private int applicationId = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLeaveDetailBinding.inflate(inflater, container, false);
        assert getArguments() != null;
        applicationId = getArguments().getInt("ApplicationId");
        Log.e("ApplicationID", "onCreateView: " + applicationId);
        repository.LeaveWithIDGet(applicationId);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);
        binding.headerLayout.tvHeader.setText("Leave Detail");
        repository.leaveDetailResponse.observe(getViewLifecycleOwner(), leaveModels -> {
            Log.e("leaveModels", "onChanged: " + leaveModels);
            setVleus(leaveModels.get(0));

        });
        binding.btDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        binding.btDetail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }


    void setVleus(LeaveDetailResponse leaveDetailResponse) {

        if (leaveDetailResponse.fname != null) {
            if (leaveDetailResponse.lname != null) {
                binding.tvNameValue.setText("" + leaveDetailResponse.fname + " " + leaveDetailResponse.lname);
            } else {
                binding.tvNameValue.setText("" + leaveDetailResponse.fname);
            }
        }

        if (leaveDetailResponse.leavetype != null) {
            binding.tvNumberValue.setText("" + leaveDetailResponse.leavetype);
        } else {
            binding.tvNumberValue.setText("Nill");
        }

        if (leaveDetailResponse.startdate != null) {
            binding.tvCnicValue.setText("" + leaveDetailResponse.startdate);
        } else {
            binding.tvCnicValue.setText("Nill");
        }

        if (leaveDetailResponse.enddate != null) {
            binding.tvApplyValueValue.setText("" + leaveDetailResponse.enddate);
        } else {
            binding.tvApplyValueValue.setText("Nill");
        }

        if (leaveDetailResponse.reason != null) {
            binding.tvApplyValueValue2.setText("" + leaveDetailResponse.reason);
        } else {
            binding.tvApplyValueValue2.setText("Nill");
        }
    }
}