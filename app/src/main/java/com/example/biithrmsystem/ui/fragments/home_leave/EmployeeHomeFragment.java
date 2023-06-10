package com.example.biithrmsystem.ui.fragments.home_leave;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentEmployeeHomeBinding;
import com.example.biithrmsystem.repositories.Repository;


public class EmployeeHomeFragment extends Fragment {

    private FragmentEmployeeHomeBinding binding;
    private Repository repository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEmployeeHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cardviewPerson.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.navigation_employee_home_to_apply_leave_fragment);
        });
        binding.cardviewEducation.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.navigation_employee_home_to_leave_application);
        });
        binding.cardviewExperience.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.navigation_employee_home_to_attendence_fragment);
        });

    }


}