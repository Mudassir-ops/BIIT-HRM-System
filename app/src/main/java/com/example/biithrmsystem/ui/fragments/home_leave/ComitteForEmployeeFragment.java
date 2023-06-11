package com.example.biithrmsystem.ui.fragments.home_leave;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.AllComittesdAdapter;
import com.example.biithrmsystem.api.datamodel.ComitteeBaseResponseModel;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentComitteForEmployeeBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.List;


public class ComitteForEmployeeFragment extends Fragment implements AllComittesdAdapter.ItemClickListener {

    AllComittesdAdapter adapter;
    private FragmentComitteForEmployeeBinding binding;
    private Repository repository;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentComitteForEmployeeBinding.inflate(inflater, container, false);
        repository = new Repository();
        repository.CommitteeWithMemberGet(SharedPreferences.GetLogInUserId());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repository.comitteeBaseResponseModelMutableLiveData.observe(getViewLifecycleOwner(), this::initRecyclerView);


    }

    void initRecyclerView(List<ComitteeBaseResponseModel> jobResponseArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllComittesdAdapter(requireContext(), jobResponseArrayList, true);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, ComitteeBaseResponseModel comitteeBaseResponseModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("MODEL", comitteeBaseResponseModel);
        Navigation.findNavController(view).navigate(R.id.navigation_employee_comitte_to_applicant_detail, bundle);
        Log.e("mahzaib_click", "onItemClick: " + comitteeBaseResponseModel);
    }

    @Override
    public void onDeleteClick(View view, int position) {
        repository.deleteCommittee(position);
    }

}