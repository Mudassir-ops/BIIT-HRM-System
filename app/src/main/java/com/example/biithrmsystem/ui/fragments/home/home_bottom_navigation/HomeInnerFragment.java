package com.example.biithrmsystem.ui.fragments.home.home_bottom_navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.adapter.AllJobsAdapter;
import com.example.biithrmsystem.api.datamodel.Job;
import com.example.biithrmsystem.databinding.FragmentHomeInnerBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;


public class HomeInnerFragment extends Fragment implements AllJobsAdapter.ItemClickListener {

    private FragmentHomeInnerBinding binding;
    private Repository repository;
    AllJobsAdapter adapter;
    private ArrayList<Job> listOfAllJobs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        listOfAllJobs = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeInnerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnGetStarted.setOnClickListener(v -> {
            binding.designLayout.setVisibility(View.INVISIBLE);
            binding.recylerviewLayout.setVisibility(View.VISIBLE);
            repository.AllJobApplicationGet();
        });

        repository.getAllJobsReponseMutableLiveData().observe(getViewLifecycleOwner(), allJobsReponse -> {
            listOfAllJobs.clear();
            for (int i = 0; i < allJobsReponse.size(); i++) {
                listOfAllJobs.add(allJobsReponse.get(i).getJob());
            }
            binding.progressCircular.setVisibility(View.INVISIBLE);
            initRecyclerView(listOfAllJobs);
        });
    }

    @Override
    public void onItemClick(View view, int position) {

    }


    void initRecyclerView(ArrayList<Job> jobArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllJobsAdapter(requireContext(), jobArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }
}