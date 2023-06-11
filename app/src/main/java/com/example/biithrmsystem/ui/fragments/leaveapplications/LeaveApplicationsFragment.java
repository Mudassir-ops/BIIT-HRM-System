package com.example.biithrmsystem.ui.fragments.leaveapplications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.AllLeaveApplicationsAdapter;
import com.example.biithrmsystem.api.datamodel.LeaveModel;
import com.example.biithrmsystem.databinding.FragmentLeaveApplicationsBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LeaveApplicationsFragment extends Fragment implements AllLeaveApplicationsAdapter.ItemClickListener {

    AllLeaveApplicationsAdapter adapter;
    String[] leaveStatusType = new String[3];
    private FragmentLeaveApplicationsBinding binding;
    private Repository repository;
    private String leaveStatus = "";
    private ArrayList<LeaveModel> leaveModelArrayList;
    private ArrayList<LeaveModel> filterList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLeaveApplicationsBinding.inflate(inflater, container, false);
        repository.AllLeaveGet();
        leaveModelArrayList = new ArrayList<>();
        adapter = new AllLeaveApplicationsAdapter(requireContext(), new ArrayList<>());

        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);
        binding.headerLayout.tvHeader.setText("Leave Applications ");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        leaveStatusType = getResources().getStringArray(R.array.leave_array);
        filterList = new ArrayList<>();

        repository.leaveApplications.observe(getViewLifecycleOwner(), leaveModels -> {
            leaveModelArrayList.clear();
            leaveModelArrayList.addAll(leaveModels);

            for (int i = 0; i < leaveModelArrayList.size(); i++) {
                if (Objects.equals(leaveModelArrayList.get(i).status.toLowerCase(), "Pending".toLowerCase())) {
                    filterList.add(leaveModelArrayList.get(i));
                }
            }

            initRecyclerView(filterList);
            Log.e("leaveModels", "onChanged: " + leaveModels);
        });

        binding.spinnerQualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                leaveStatus = leaveStatusType[position];
                if (filterList != null) {
                    filterList.clear();
                    for (int i = 0; i < leaveModelArrayList.size(); i++) {
                        if (Objects.equals(leaveModelArrayList.get(i).status.toLowerCase(), leaveStatus.toLowerCase())) {
                            filterList.add(leaveModelArrayList.get(i));
                        }
                    }
                    adapter.filterList(filterList);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }

    void initRecyclerView(List<LeaveModel> jobResponseArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllLeaveApplicationsAdapter(requireContext(), jobResponseArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("ApplicationId", id);
        Navigation.findNavController(view).navigate(R.id.leave_application_to_job_leave_detail_fragment, bundle);

    }

    @Override
    public void onDeleteClick(View view, int position) {

    }
}