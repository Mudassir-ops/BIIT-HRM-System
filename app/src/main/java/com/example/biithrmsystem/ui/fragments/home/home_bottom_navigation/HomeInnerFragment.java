package com.example.biithrmsystem.ui.fragments.home.home_bottom_navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentHomeBinding;
import com.example.biithrmsystem.databinding.FragmentHomeInnerBinding;
import com.example.biithrmsystem.databinding.FragmentLoginBinding;


public class HomeInnerFragment extends Fragment {

    private FragmentHomeInnerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeInnerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}