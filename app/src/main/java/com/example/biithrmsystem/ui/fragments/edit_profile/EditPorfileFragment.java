package com.example.biithrmsystem.ui.fragments.edit_profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentEditPorfileBinding;
import com.example.biithrmsystem.databinding.FragmentHomeBinding;


public class EditPorfileFragment extends Fragment {

    private FragmentEditPorfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditPorfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.tvHeader.setText("Edit Profile");
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);


        binding.layoutFirstName.etEmail.setHint("First Name");
        binding.layoutFirstName.name.setText("First Name");

        binding.layoutLastName.etEmail.setHint("Last Name");
        binding.layoutFirstName.name.setText("Last Name");

        binding.layoutContactNo.etEmail.setHint("Contact No ");
        binding.layoutFirstName.name.setText("Contact No");

        binding.layoutCnic.etEmail.setHint("CNIC");
        binding.layoutFirstName.name.setText("CNIC");

        binding.layoutAddress.etEmail.setHint("Date of Birth");
        binding.layoutAddress.name.setText("Date of Birth");


        //------get all profile data

    }
}