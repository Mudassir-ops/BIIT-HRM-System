package com.example.biithrmsystem.ui.fragments.application_applicant;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.adapter.AllApllicationAdapter;
import com.example.biithrmsystem.api.datamodel.AllJobsReponse;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentApplicantApplicationBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;
import java.util.List;


public class ApplicantApplicationFragment extends Fragment implements AllApllicationAdapter.ItemClickListener {

    Repository repository;
    AllApllicationAdapter adapter;
    private ArrayList<AllJobsReponse> listOfAllJobs;
    private FragmentApplicantApplicationBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        listOfAllJobs = new ArrayList<>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentApplicantApplicationBinding.inflate(inflater, container, false);
        repository = new Repository();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository.AllJobApplicationGet();

        repository.allApplicantJob.observe(getViewLifecycleOwner(), allJobsReponses -> {
            Log.e("All_JOb_Response", "onViewCreated: " + allJobsReponses);

            for (int i = 0; i < allJobsReponses.size(); i++) {
                if (allJobsReponses.get(i).getUid() == SharedPreferences.GetLogInUserId()) {
                    listOfAllJobs.add(allJobsReponses.get(i));
                }
            }

            initRecyclerView(listOfAllJobs);
        });
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);
        binding.headerLayout.tvHeader.setText("Job Applications");
    }

    //---applyeidnjob
    void initRecyclerView(List<AllJobsReponse> jobArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllApllicationAdapter(requireContext(), jobArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}