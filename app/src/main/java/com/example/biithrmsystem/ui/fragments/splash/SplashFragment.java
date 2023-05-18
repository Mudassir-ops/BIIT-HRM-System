package com.example.biithrmsystem.ui.fragments.splash;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
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
        handler.postDelayed(() -> Navigation.findNavController(view).navigate(R.id.spalsh_to_login), 1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}