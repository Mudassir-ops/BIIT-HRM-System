package com.example.biithrmsystem.ui.fragments.ApplicantDetail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.ComitteeBaseResponseModel;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentApplicatnDetailBinding;
import com.example.biithrmsystem.repositories.Repository;

public class ApplicatnDetailFragment extends Fragment {

    private FragmentApplicatnDetailBinding binding;
    private Repository repository;
    String[] ratingArray = new String[5];
    String rating = "0";
    private ComitteeBaseResponseModel comitteeBaseResponseModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        comitteeBaseResponseModel = new ComitteeBaseResponseModel();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentApplicatnDetailBinding.inflate(inflater, container, false);
        repository.getUser(SharedPreferences.GetLogInUserId());
        repository.EducationGet(SharedPreferences.GetLogInUserId());
        repository.ExperienceGet(SharedPreferences.GetLogInUserId());
        ratingArray = getResources().getStringArray(R.array.rate_us_array);
        comitteeBaseResponseModel = getArguments() != null ? getArguments().getParcelable("MODEL") : null;
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.headerLayout.tvHeader.setText("Applicant Detail");
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);


        repository.getUser.observe(getViewLifecycleOwner(), userSignInResponses -> {
            //----------Personal Detail
            binding.employeePersonlaLayout.tvNameValue.setText("" + userSignInResponses.get(0).fname + " " + userSignInResponses.get(0).lname);
            binding.employeePersonlaLayout.tvNumberValue.setText("" + userSignInResponses.get(0).email);
            binding.employeePersonlaLayout.tvCnicValue.setText("" + userSignInResponses.get(0).gender);
            binding.employeePersonlaLayout.tvApplyValueValue.setText("" + userSignInResponses.get(0).mobile);
            binding.employeePersonlaLayout.tvContactValue.setText("" + userSignInResponses.get(0).dob);
            binding.employeePersonlaLayout.tvAddressValue.setText("" + userSignInResponses.get(0).address);
        });

        repository.educationList.observe(getViewLifecycleOwner(), educations -> {
            //----------Educational Detail
            if (educations.size() > 0) {
                binding.employeeEducationLayout.tvNameValue.setText("" + educations.get(0).getDegree());
                binding.employeeEducationLayout.tvNumberValue.setText("" + educations.get(0).getInstitute());
                binding.employeeEducationLayout.tvCnicValue.setText("" + educations.get(0).getBoard());
                binding.employeeEducationLayout.tvApplyValueValue.setText("" + educations.get(0).getStartdate());
                binding.employeeEducationLayout.tvContactValue.setText("" + educations.get(0).getEnddate());
            }
        });

        repository.experienceGet.observe(getViewLifecycleOwner(), experiences -> {
            //----------Applicant Detail
            if (experiences.size() > 0) {
                binding.employeeExperienceLayout.tvNameValue.setText("" + experiences.get(0).getCompany());
                binding.employeeExperienceLayout.tvNumberValue.setText("" + experiences.get(0).getTitle());
                binding.employeeExperienceLayout.tvCnicValue.setText("" + experiences.get(0).getStartdate());
                binding.employeeExperienceLayout.tvApplyValueValue.setText("" + experiences.get(0).getCurrentwork());
                binding.employeeExperienceLayout.tvContactValue.setText("" + experiences.get(0).getOtherskill());
            }
        });
        binding.spinnerDegree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rating = ratingArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.btnSubmit.setOnClickListener(v -> repository.RemarkPost(comitteeBaseResponseModel.CommitteeImemberId, 35, Integer.parseInt(rating)));
        repository.REMARKS.observe(getViewLifecycleOwner(), s -> Navigation.findNavController(view).navigateUp());

    }
}