package com.example.biithrmsystem.ui.fragments.GuardHome;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.Employees;
import com.example.biithrmsystem.adapter.GuardHomeAdapter;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentGuardHomeBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;
import java.util.Objects;


public class GuardHomeFragment extends Fragment implements GuardHomeAdapter.ItemClickListener {
    private ArrayList<Employees> listOfAllJobs;
    private ArrayList<Employees> updatedList;
    GuardHomeAdapter adapter;
    private Repository repository;
    private FragmentGuardHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGuardHomeBinding.inflate(inflater, container, false);
        repository = new Repository();
        listOfAllJobs = new ArrayList<>();
        updatedList = new ArrayList<>();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view1, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view1, savedInstanceState);

        binding.headerLayout.tvHeader.setText("Welcome to Guard Section");
        binding.headerLayout.ivMenu.setOnClickListener(v -> {

            binding.drawerLayoutInner.tvPostedJob.setOnClickListener(v1 -> {

            });

        });


        binding.jobSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
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
        Bundle bundle = new Bundle();
        bundle.putInt("IMAGE_ID", listOfAllJobs.get(position).getSrcImg());
        bundle.putString("TITLE", listOfAllJobs.get(position).getTitle());
        bundle.putString("PHON_NO", listOfAllJobs.get(position).getPh0neNO());
        bundle.putInt("POSITION", position);
        if (adapter.mData.get(position).getCheckedIn()) {
            bundle.putBoolean("TYPE", false);
        } else {
            bundle.putBoolean("TYPE", true);
        }
        Navigation.findNavController(view).navigate(R.id.guard_home_to_checkin, bundle);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("testValue", "onResume: " + SharedPreferences.GetCheckedInUser0());
        listOfAllJobs.clear();
        updatedList.clear();
        listOfAllJobs.add(new Employees(R.drawable.muhammad_ahsan, "Muhammad Ahsan", false, "0332456361"));
        listOfAllJobs.add(new Employees(R.drawable.munir, "Dr.Munir", false, "0334466361"));
        listOfAllJobs.add(new Employees(R.drawable.zerafshan, "Ms.ZerAfshan", false, "033245f636"));
        listOfAllJobs.add(new Employees(R.drawable.hassan_nazeer, "Mr.Hassan Nazeer", false, "03432456361"));
        listOfAllJobs.add(new Employees(R.drawable.ihsan, "Mr Ihsan", false, "0322456361"));
        listOfAllJobs.add(new Employees(R.drawable.umer_farooq, "Mr Azhar Jamil", false, "03324563610"));
        listOfAllJobs.add(new Employees(R.drawable.waqar, "Mr.Waqar", false, "0342456369"));
        listOfAllJobs.add(new Employees(R.drawable.amir_rasheed, "Mr.Amir Rasheed", false, "0332456368"));
        listOfAllJobs.add(new Employees(R.drawable.tahir, "Mr.Tahir", false, "0332456367"));
        listOfAllJobs.add(new Employees(R.drawable.shahid_abid, "Mr.Shahid Abid", false, "03232456364"));
        listOfAllJobs.add(new Employees(R.drawable.shahid_jameil, "Mr.Shahid Jamil", false, "03122456363"));
        ArrayList<String> stringArrayList = getAllCheckedIn();
        Log.e("List_OF_ALL_Checked_IN", "onResume: " + stringArrayList);
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (!Objects.equals(stringArrayList.get(i), "")) {
                updatedList.add(i, new Employees(listOfAllJobs.get(i).getSrcImg(), listOfAllJobs.get(i).getTitle(), true, listOfAllJobs.get(i).getPh0neNO()));
            } else {
                updatedList.add(i, new Employees(listOfAllJobs.get(i).getSrcImg(), listOfAllJobs.get(i).getTitle(), false, listOfAllJobs.get(i).getPh0neNO()));
            }
        }

        initRecyclerView(updatedList);


    }

    ArrayList<String> getAllCheckedIn() {
        ArrayList<String> dataList = new ArrayList<>();
        dataList.add(SharedPreferences.GetCheckedInUser0());
        dataList.add(SharedPreferences.GetCheckedInUser1());
        dataList.add(SharedPreferences.GetCheckedInUser2());
        dataList.add(SharedPreferences.GetCheckedInUser3());
        dataList.add(SharedPreferences.GetCheckedInUser4());
        dataList.add(SharedPreferences.GetCheckedInUser5());
        dataList.add(SharedPreferences.GetCheckedInUser6());
        dataList.add(SharedPreferences.GetCheckedInUser7());
        dataList.add(SharedPreferences.GetCheckedInUser8());
        dataList.add(SharedPreferences.GetCheckedInUser9());
        dataList.add(SharedPreferences.GetCheckedInUser10());

        return dataList;
    }

}

