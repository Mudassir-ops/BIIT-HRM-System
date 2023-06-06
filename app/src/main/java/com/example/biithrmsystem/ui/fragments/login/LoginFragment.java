package com.example.biithrmsystem.ui.fragments.login;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

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

                            if (Objects.equals(userSignInResponse.role, "guard")) {
                                Navigation.findNavController(v).navigate(R.id.login_to_guard);
                                SharedPreferences.setLogInUserId(userSignInResponse.uid);
                                SharedPreferences.setEmailId(userSignInResponse.email);
                                SharedPreferences.setPassword(userSignInResponse.password);
                                SharedPreferences.setUserType("guard");
                            } else if (Objects.equals(userSignInResponse.role, "hr")) {


                                Navigation.findNavController(v).navigate(R.id.login_to_hr_home);
                                SharedPreferences.setLogInUserId(userSignInResponse.uid);
                                SharedPreferences.setEmailId(userSignInResponse.email);
                                SharedPreferences.setUserType("hr");
                                SharedPreferences.setPassword(userSignInResponse.password);


                            } else {
                                Navigation.findNavController(v).navigate(R.id.login_to_home_screen);
                                SharedPreferences.setLogInUserId(userSignInResponse.uid);
                                SharedPreferences.setEmailId(userSignInResponse.email);
                                SharedPreferences.setPassword(userSignInResponse.password);
                                SharedPreferences.setUserType("else");
                            }
                            Log.e("mudassir", "onChanged: " + userSignInResponse.role);

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

            binding.drawerLayout.closeDrawers();
        });

        Animation animation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_out_top);
        binding.bottomSheet.setVisibility(View.VISIBLE);
        binding.bottomSheet.setAnimation(animation);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void slideFromBottomToTop(View view) {
        view.setVisibility(View.VISIBLE);
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY", 100f, 0f);
        animation.setDuration(1000);
        animation.start();
    }


    // slide the view from below itself to the current position
    public void slideUp(View view) {
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(5000);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view) {
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }
}