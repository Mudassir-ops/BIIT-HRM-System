package com.example.biithrmsystem.ui.fragments.home.home_bottom_navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.AllJobsAdapter;
import com.example.biithrmsystem.api.datamodel.JobResponse;
import com.example.biithrmsystem.commons.Appconstants;
import com.example.biithrmsystem.databinding.FragmentHomeInnerBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;


public class HomeInnerFragment extends Fragment implements AllJobsAdapter.ItemClickListener {
    AllJobsAdapter adapter;
    private FragmentHomeInnerBinding binding;
    private Repository repository;
    private ArrayList<JobResponse> listOfAllJobResponses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        listOfAllJobResponses = new ArrayList<>();
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
            repository.jobGet();
        });

        repository.getAllJobsReponseMutableLiveData().observe(getViewLifecycleOwner(), allJobsReponse -> {
            Log.e("mudassir", "onViewCreated: " + allJobsReponse);
            if (allJobsReponse != null) {
                listOfAllJobResponses.clear();
                listOfAllJobResponses.addAll(allJobsReponse);
                binding.progressCircular.setVisibility(View.INVISIBLE);
                initRecyclerView(listOfAllJobResponses);
            }

        });
        binding.jobSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//              if (searchView.isExpanded() && TextUtils.isEmpty(newText)) {
                callSearch(newText);
//              }
                return true;
            }

            public void callSearch(String query) {
                filter(query);
            }

        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Appconstants.JOB_ID, position);
        Navigation.findNavController(view).navigate(R.id.home_inner_to_job_detail, bundle);
    }

    void initRecyclerView(ArrayList<JobResponse> jobResponseArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllJobsAdapter(requireContext(), jobResponseArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    private void filter(String text) {
        ArrayList<JobResponse> filteredlist = new ArrayList<JobResponse>();
        for (JobResponse item : listOfAllJobResponses) {
            if (item.title.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            //--       Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }


}