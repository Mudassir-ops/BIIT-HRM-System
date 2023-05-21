package com.example.biithrmsystem.ui.fragments.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.biithrmsystem.R;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentCompleteProfileBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.Calendar;

public class CompleteProfileFragment extends Fragment {

    final Calendar myCalendar = Calendar.getInstance();
    private Repository repository = null;
    private FragmentCompleteProfileBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCompleteProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);
        binding.headerLayout.tvHeader.setText("Complete your Profile");
        repository.getUser(SharedPreferences.GetLogInUserId());
        binding.cardviewPerson.setOnClickListener(v -> {
            binding.cardviewPerson.setVisibility(View.INVISIBLE);
            binding.cardviewEducation.setVisibility(View.INVISIBLE);
            binding.cardviewExperience.setVisibility(View.INVISIBLE);
            binding.applicaitonProfile.setVisibility(View.VISIBLE);

        });
        binding.cardviewEducation.setOnClickListener(v -> {
            binding.cardviewPerson.setVisibility(View.INVISIBLE);
            binding.cardviewEducation.setVisibility(View.INVISIBLE);
            binding.cardviewExperience.setVisibility(View.INVISIBLE);

            Navigation.findNavController(view).navigate(R.id.complete_to_edit_education);

        });
        binding.cardviewExperience.setOnClickListener(v -> {
            binding.cardviewPerson.setVisibility(View.INVISIBLE);
            binding.cardviewEducation.setVisibility(View.INVISIBLE);
            binding.cardviewExperience.setVisibility(View.INVISIBLE);

            Navigation.findNavController(view).navigate(R.id.complete_to_edit_experience);

        });
        repository.getUser.observe(getViewLifecycleOwner(), userSignInResponses -> {
            Glide.with(requireView()).load(userSignInResponses.get(0).image).placeholder(R.drawable.admin).into(binding.ivApplicantDp);

            if (userSignInResponses.get(0).fname == null) {
                binding.tvNameValue.setText("null");
            } else {
                binding.tvNameValue.setText(userSignInResponses.get(0).fname);
            }
            if (userSignInResponses.get(0).mobile == null) {
                binding.tvNumberValue.setText("");
            } else {
                binding.tvNumberValue.setText(userSignInResponses.get(0).mobile);
            }
            if (userSignInResponses.get(0).cnic == null) {
                binding.tvCnicValue.setText("");
            } else {
                binding.tvCnicValue.setText(userSignInResponses.get(0).cnic);
            }
            if (userSignInResponses.get(0).dob == null) {
                binding.tvDateOfBirthValue.setText("");
            } else {
                binding.tvDateOfBirthValue.setText(userSignInResponses.get(0).dob);
            }
            if (userSignInResponses.get(0).gender == null) {
                binding.tvGenderValue.setText("");
            } else {
                binding.tvGenderValue.setText(userSignInResponses.get(0).gender);
            }
            if (userSignInResponses.get(0).address == null) {
                binding.tvAddressValue.setText("");
            } else {
                binding.tvAddressValue.setText(userSignInResponses.get(0).address);
            }
            binding.tvAddressValue.setSelected(true);

        });
        binding.btnEdit.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.complete_to_edit_profile);
        });

    }
}