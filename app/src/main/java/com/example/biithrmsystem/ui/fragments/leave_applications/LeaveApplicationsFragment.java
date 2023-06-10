package com.example.biithrmsystem.ui.fragments.leave_applications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.adapter.EmployeeLeavesAdapter;
import com.example.biithrmsystem.api.datamodel.LeaveModel;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentLeaveApplications2Binding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;
import java.util.List;


public class LeaveApplicationsFragment extends Fragment implements EmployeeLeavesAdapter.ItemClickListener {


    EmployeeLeavesAdapter adapter;

    private FragmentLeaveApplications2Binding binding;
    private Repository repository;

    private ArrayList<LeaveModel> arrayList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        arrayList = new ArrayList<>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLeaveApplications2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository.leaveLists.observe(getViewLifecycleOwner(), new Observer<List<LeaveModel>>() {
            @Override
            public void onChanged(List<LeaveModel> leaveModels) {
                arrayList.clear();
                arrayList.addAll(leaveModels);
                initRecyclerView(arrayList);
            }
        });

        binding.btnPending.setOnClickListener(v -> {
            repository.PendingLeaveGet(SharedPreferences.GetLogInUserId());

        });

        binding.btnApproved.setOnClickListener(v -> {
            repository.ApprovedLeaveGet(SharedPreferences.GetLogInUserId());
        });

        binding.btnRejected.setOnClickListener(v -> {
            repository.RejectedLeaveGet(SharedPreferences.GetLogInUserId());
        });

    }

    ///-----here init method to show data in recyclerview
    void initRecyclerView(List<LeaveModel> jobResponseArrayList) {
        binding.rvDataList.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new EmployeeLeavesAdapter(requireContext(), jobResponseArrayList);
        adapter.setClickListener(this);
        binding.rvDataList.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {
        Log.e("TAG", "onItemClick: " + position);
    }
}