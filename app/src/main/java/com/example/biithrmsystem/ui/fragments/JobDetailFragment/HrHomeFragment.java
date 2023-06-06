package com.example.biithrmsystem.ui.fragments.JobDetailFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentHrHomeBinding;


public class HrHomeFragment extends Fragment {

    private FragmentHrHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHrHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);
        binding.headerLayout.tvHeader.setText("Hr Home");

        binding.layoutJobApplication.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.hr_home_to_view_job_fragment));
        binding.layoutLeaveApplication.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.hr_home_to_leave_application_fragment));
        binding.layoutAttendece.setOnClickListener(v -> {

        });


        binding.jobPost.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.hr_home_to_add_job));
    }
}