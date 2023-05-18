package com.example.biithrmsystem.ui.fragments.signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSignUpBinding.inflate(inflater, container, false);

        binding.tvAlreadyAccount.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.signup_to_login);

        });

        return binding.getRoot();
    }


}