package com.example.biithrmsystem.ui.fragments.commite;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.ComitteHeadAdapter;
import com.example.biithrmsystem.api.datamodel.UserRoleResponse;
import com.example.biithrmsystem.databinding.FragmentComitteHeadBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ComiiteHeadFragment extends Fragment implements ComitteHeadAdapter.ItemClickListener {
    private FragmentComitteHeadBinding binding;
    private Repository repository;
    private ArrayList<UserRoleResponse> updatedList;
    ComitteHeadAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        updatedList = new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentComitteHeadBinding.inflate(inflater, container, false);
        repository = new Repository();
        repository.UserroleGet();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository.userRoleGet.observe(getViewLifecycleOwner(), new Observer<List<UserRoleResponse>>() {
            @Override
            public void onChanged(List<UserRoleResponse> userRoleResponses) {
                updatedList.addAll(userRoleResponses);
                initRecyclerView(updatedList);
                Log.e("mudassir_satti", "onChanged: " + userRoleResponses);

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
                callSearch(newText);
                return true;
            }

            public void callSearch(String query) {
                filter(query);
            }

        });

    }

    @Override
    public void onItemClick(View view, int position) {

        Bundle bundle=new Bundle();
        bundle.putInt("USER_ID",position);
        Navigation.findNavController(view).navigate(R.id.comitte_head_to_create_commitie,bundle);

    }

    void initRecyclerView(ArrayList<UserRoleResponse> jobArrayList) {
        binding.allJobRv.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        adapter = new ComitteHeadAdapter(requireContext(), jobArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    private void filter(String text) {
        ArrayList<UserRoleResponse> filteredlist = new ArrayList<UserRoleResponse>();
        for (UserRoleResponse item : updatedList) {
            if (item.fname.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            ///--  Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }
}