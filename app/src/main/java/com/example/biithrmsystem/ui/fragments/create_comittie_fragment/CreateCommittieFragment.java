package com.example.biithrmsystem.ui.fragments.create_comittie_fragment;

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
import com.example.biithrmsystem.databinding.FragmentCreateCommittieBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.Objects;


public class CreateCommittieFragment extends Fragment {

    private Repository repository = null;
    private FragmentCreateCommittieBinding binding;
    private int userId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateCommittieBinding.inflate(inflater, container, false);
        assert getArguments() != null;
        userId = getArguments().getInt("USER_ID");
        repository.getUser(userId);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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

        binding.btnEdit.setOnClickListener(v -> repository.Createcommitte(Objects.requireNonNull(binding.etEmail.getText()).toString(), userId));
        repository.deleteComitte.observe(getViewLifecycleOwner(), s -> {
            Navigation.findNavController(view).navigate(R.id.action_navigation_create_committiee_to_navigation_comitte_home);
        });

    }


}