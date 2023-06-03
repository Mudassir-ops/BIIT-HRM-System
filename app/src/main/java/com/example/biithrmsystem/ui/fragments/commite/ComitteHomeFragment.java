package com.example.biithrmsystem.ui.fragments.commite;

import android.os.Bundle;
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
import com.example.biithrmsystem.commons.Function;
import com.example.biithrmsystem.databinding.FragmentComitteHomeBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.List;


public class ComitteHomeFragment extends Fragment implements AllComittesdAdapter.ItemClickListener {
    private FragmentComitteHomeBinding binding;
    private Repository repository;
    AllComittesdAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentComitteHomeBinding.inflate(inflater, container, false);
        repository = new Repository();

        repository.AllCommitteeGet();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository.allCOmittereponse.observe(getViewLifecycleOwner(), this::initRecyclerView);
        repository.deleteComitte.observe(getViewLifecycleOwner(), s -> {
            Function.showToast("" + s, requireContext());
            repository.AllCommitteeGet();
        });
        binding.fab.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.comitte_home_to_comitte_head);
        });
    }
    void initRecyclerView(List<ComitteeBaseResponseModel> jobResponseArrayList) {
        binding.allJobRv.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AllComittesdAdapter(requireContext(), jobResponseArrayList);
        adapter.setClickListener(this);
        binding.allJobRv.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onDeleteClick(View view, int position) {
        repository.deleteCommittee(position);
    }
}