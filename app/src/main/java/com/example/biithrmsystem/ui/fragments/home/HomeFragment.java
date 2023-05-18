package com.example.biithrmsystem.ui.fragments.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentHomeBinding;
import com.example.biithrmsystem.repositories.Repository;


import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private Repository repository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.tvHeader.setText("Welcome");
        binding.headerLayout.ivMenu.setOnClickListener(v -> binding.drawerLayout.openDrawer(GravityCompat.START));
        binding.drawerLayoutInner.tvProfile.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.home_to_complete_profile);
        });
        repository.getUser(SharedPreferences.GetLogInUserId());
        repository.getGetUser().observe(getViewLifecycleOwner(), new Observer<List<UserSignInResponse>>() {
            @Override
            public void onChanged(List<UserSignInResponse> userSignInResponses) {
                if (userSignInResponses.get(0).fname == null) {
                    binding.drawerLayoutInner.tvName.setText("null");
                } else {
                    binding.drawerLayoutInner.tvName.setText(userSignInResponses.get(0).fname);
                }
                if (userSignInResponses.get(0).email == null) {
                    binding.drawerLayoutInner.tvEmail.setText("");
                } else {
                    binding.drawerLayoutInner.tvEmail.setText(userSignInResponses.get(0).email);
                }
                if (userSignInResponses.get(0).image == null) {
                    Glide.with(requireContext()).load(R.drawable.admin).into(binding.drawerLayoutInner.ivDrawerProfile);
                } else {
                    Glide.with(requireContext()).load(userSignInResponses.get(0).image).into(binding.drawerLayoutInner.ivDrawerProfile);
                }
                Log.e("fullName", "onChanged: $" + userSignInResponses.get(0).fname);
                //    binding.drawerLayoutInner.tvName.setText("" + userSignInResponses.get(0).fname + " " + userSignInResponses.get(0).lname.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}