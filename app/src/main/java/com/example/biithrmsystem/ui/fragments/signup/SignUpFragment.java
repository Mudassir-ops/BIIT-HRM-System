package com.example.biithrmsystem.ui.fragments.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.SignupUserModel;
import com.example.biithrmsystem.commons.Function;
import com.example.biithrmsystem.databinding.FragmentSignUpBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.Objects;

public class SignUpFragment extends Fragment {


    private Repository repository;
    private FragmentSignUpBinding binding;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btLogin.setOnClickListener(v -> {
            if (Function.isNetworkAvailable(requireContext())) {
                SignupUserModel signupUserModel = new SignupUserModel();
                signupUserModel.setFname(Objects.requireNonNull(binding.firstName.getText()).toString().trim());
                signupUserModel.setLname(Objects.requireNonNull(binding.lastName.getText()).toString().trim());
                signupUserModel.setMobile(Objects.requireNonNull(binding.etContactNo.getText()).toString().trim());
                signupUserModel.setPassword(Objects.requireNonNull(binding.etPassword.getText()).toString().trim());
                signupUserModel.setCnic(Objects.requireNonNull(binding.etCnic.getText()).toString().trim());
                signupUserModel.setEmail(Objects.requireNonNull(binding.etEmail.getText()).toString().trim());
                if (binding.checkboxIsApplicant.isChecked()) {
                    signupUserModel.setRole("applicant");
                }
                repository.singUp(signupUserModel);
            } else {
                Function.showToast("NO Internet", requireContext());
            }

        });
        repository.getSignupLiveData().observe(getViewLifecycleOwner(), s -> {
            Function.showToast(" " + s, requireContext());
            Navigation.findNavController(view).navigateUp();
        });
    }
}