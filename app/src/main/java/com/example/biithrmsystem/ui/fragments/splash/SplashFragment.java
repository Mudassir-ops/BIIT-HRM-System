package com.example.biithrmsystem.ui.fragments.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;
    private SplashViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(SplashViewModel.class);


        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() ->
        {
            if (SharedPreferences.GetLogInUserId() == 0) {
                Navigation.findNavController(view).navigate(R.id.spalsh_to_login);
            } else {

                if (SharedPreferences.GetUserType().equals("hr")) {
                    Navigation.findNavController(view).navigate(R.id.login_to_add_job);
                } else if (SharedPreferences.GetUserType().equals("guard")) {
                    Navigation.findNavController(view).navigate(R.id.login_to_guard);
                } else {
                    Navigation.findNavController(view).navigate(R.id.spalsh_to_home);
                }

            }


        }, 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}