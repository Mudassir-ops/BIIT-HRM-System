package com.example.biithrmsystem.ui.fragments.GuardHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.Employees;
import com.example.biithrmsystem.adapter.GuardHomeAdapter;
import com.example.biithrmsystem.databinding.FragmentGuardHomeBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;


public class GuardHomeFragment extends Fragment implements GuardHomeAdapter.ItemClickListener {
    private ArrayList<Employees> listOfAllJobs;
    GuardHomeAdapter adapter;
    private Repository repository;
    private FragmentGuardHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGuardHomeBinding.inflate(inflater, container, false);
        repository = new Repository();
        listOfAllJobs = new ArrayList<>();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listOfAllJobs.clear();
        listOfAllJobs.add(new Employees(R.drawable.dp_1, "Shahid Jamil"));
        listOfAllJobs.add(new Employees(R.drawable.dp_2, "Mr Hassan Nazeer"));
        listOfAllJobs.add(new Employees(R.drawable.dp_3, "Mr Umar Farooq"));
        listOfAllJobs.add(new Employees(R.drawable.dp_4, "Mr Muhammad Ahsan"));
        listOfAllJobs.add(new Employees(R.drawable.dp_5, "Mr Zahid Khan"));
        listOfAllJobs.add(new Employees(R.drawable.dp_6, "Mr Amir Rasheed "));
        listOfAllJobs.add(new Employees(R.drawable.dp_7, "Mr Azhar Jamil"));
        listOfAllJobs.add(new Employees(R.drawable.dp_8, "Mr Muhammad Ihsan"));
        initRecyclerView(listOfAllJobs);

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

    void initRecyclerView(ArrayList<Employees> jobArrayList) {
        binding.allJobRv.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        adapter = new GuardHomeAdapter(requireContext(), jobArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    private void filter(String text) {
        ArrayList<Employees> filteredlist = new ArrayList<Employees>();
        for (Employees item : listOfAllJobs) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}

