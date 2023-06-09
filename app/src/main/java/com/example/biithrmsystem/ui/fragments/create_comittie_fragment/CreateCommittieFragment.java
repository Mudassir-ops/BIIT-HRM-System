package com.example.biithrmsystem.ui.fragments.create_comittie_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
    private String from = "";
    private int comittieId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateCommittieBinding.inflate(inflater, container, false);
        assert getArguments() != null;
        userId = getArguments().getInt("USER_ID");
        from = getArguments().getString("FROM");
        comittieId = getArguments().getInt("Comiite_ID");
        repository.getUser(userId);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (from.equals("CREATE_COMMITIEE")) {
            binding.btnEdit.setText("Create Committee");
            binding.etEmail.setVisibility(View.VISIBLE);
            binding.etLabel.setVisibility(View.VISIBLE);
        } else {
            binding.btnEdit.setText("Add Member");
            binding.etEmail.setVisibility(View.GONE);
            binding.etLabel.setVisibility(View.GONE);
        }
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

        binding.btnEdit.setOnClickListener(v -> {
            if (from.equals("CREATE_COMMITIEE")) {
                repository.Createcommitte(Objects.requireNonNull(binding.etEmail.getText()).toString(), userId);
            } else {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(requireContext());
                builder1.setMessage("Do You Want to Add Member");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Yes",
                        (dialog, id) -> {
                            repository.CreateCommitteMember(comittieId, userId);
                            dialog.cancel();
                        });

                builder1.setNegativeButton(
                        "No",
                        (dialog, id) -> dialog.cancel());

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        repository.deleteComitte.observe(getViewLifecycleOwner(), s -> {
            Navigation.findNavController(view).navigate(R.id.action_navigation_create_committiee_to_navigation_comitte_home);
        });

        repository.addMemebr.observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(requireContext(), "" + s, Toast.LENGTH_LONG).show();
//

        });
    }
}