package com.example.biithrmsystem.ui.fragments.login;

import androidx.lifecycle.Observer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.UserSignInResponse;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentLoginBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.Objects;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private Repository repository;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        repository = new Repository();

        binding.btCreateAccount.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.login_to_signup);
        });
        binding.btLogin.setOnClickListener(v -> {
//            if (Objects.requireNonNull(Navigation.findNavController(v).getCurrentDestination()).getId() == R.id.navigation_login) {
//                Navigation.findNavController(v).navigate(R.id.login_to_home_screen);
//            }

            //"uznain@gmail.com679" ---"uznain@786"
            if (TextUtils.isEmpty(binding.etEmail.getText())) {
                binding.etEmail.setError("Email Required");
                return;
            }
            if (TextUtils.isEmpty(binding.etPassword.getText())) {
                binding.etPassword.setError("Password Required");
                return;
            }
            binding.btLogin.setText("");
            binding.progressbar.setVisibility(View.VISIBLE);
            repository.userSignIn(binding.etEmail.getText().toString().trim(), binding.etPassword.getText().toString().trim()).observe(getViewLifecycleOwner(), new Observer<UserSignInResponse>() {
                @Override
                public void onChanged(UserSignInResponse userSignInResponse) {
                    if (userSignInResponse != null) {
                        if (Objects.requireNonNull(Navigation.findNavController(v).getCurrentDestination()).getId() == R.id.navigation_login) {
                            Navigation.findNavController(v).navigate(R.id.login_to_home_screen);
                            SharedPreferences.setLogInUserId(userSignInResponse.uid);
                        }
                    } else {
                        binding.btLogin.setText("Login");
                        binding.progressbar.setVisibility(View.GONE);
                    }
                }
            });
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.drawerLayoutInner.tvAddJob.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.login_to_add_job);
            binding.drawerLayout.closeDrawers();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}