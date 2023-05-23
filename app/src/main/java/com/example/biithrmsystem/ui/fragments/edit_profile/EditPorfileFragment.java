package com.example.biithrmsystem.ui.fragments.edit_profile;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.SignupUserModel;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentEditPorfileBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public class EditPorfileFragment extends Fragment {
    final Calendar myCalendar = Calendar.getInstance();
    static String imagePath = "";
    Repository repository;
    String[] genderArray = new String[5];
    private FragmentEditPorfileBinding binding;
    private String mGender = "";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEditPorfileBinding.inflate(inflater, container, false);
        repository = new Repository();
        genderArray = getResources().getStringArray(R.array.gender_array);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    imagePath = uri.toString();
                    Log.e("mudassir", "onViewCreated: $" + uri);
                    Glide.with(requireContext()).load(uri).into(binding.profilePick);
                });

        DatePickerDialog.OnDateSetListener date = (view1, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };

        binding.layoutDob.etEmail.setOnClickListener(view12 -> new DatePickerDialog(requireContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        binding.headerLayout.tvHeader.setText("Edit Profile");
        binding.headerLayout.ivMenu.setVisibility(View.INVISIBLE);


        binding.layoutFirstName.etEmail.setHint("First Name");
        binding.layoutFirstName.name.setText("First Name");

        binding.layoutLastName.etEmail.setHint("Last Name");
        binding.layoutLastName.name.setText("Last Name");

        binding.layoutContactNo.etEmail.setHint("Contact No ");
        binding.layoutContactNo.name.setText("Contact No");

        binding.layoutCnic.etEmail.setHint("CNIC");
        binding.layoutCnic.name.setText("CNIC");

        binding.layoutDob.etEmail.setHint("Date of Birth");
        binding.layoutDob.name.setText("Date of Birth");

        binding.layoutAddress.etEmail.setHint("Address");
        binding.layoutAddress.name.setText("Address");



        binding.layoutCnic.etEmail.setInputType(InputType.TYPE_CLASS_NUMBER);
        binding.layoutContactNo.etEmail.setInputType(InputType.TYPE_CLASS_NUMBER);

        binding.profilePick.setOnClickListener(v -> {
            mGetContent.launch("image/*");
        });

        binding.etGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mGender = genderArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.btnPost.setOnClickListener(v -> {
            SignupUserModel signupUserModel = new SignupUserModel();
            signupUserModel.setUid(SharedPreferences.GetLogInUserId());
            signupUserModel.setFname(Objects.requireNonNull(binding.layoutFirstName.etEmail.getText()).toString());
            signupUserModel.setLname(Objects.requireNonNull(binding.layoutLastName.etEmail.getText()).toString());
            signupUserModel.setMobile(Objects.requireNonNull(binding.layoutContactNo.etEmail.getText()).toString());
            signupUserModel.setCnic(Objects.requireNonNull(binding.layoutCnic.etEmail.getText()).toString());
            signupUserModel.setDob(Objects.requireNonNull(binding.layoutDob.etEmail.getText()).toString());
            signupUserModel.setGender(Objects.requireNonNull(mGender));
            signupUserModel.setAddress(Objects.requireNonNull(binding.layoutAddress.etEmail.getText()).toString());
            signupUserModel.setImage(imagePath);

            Log.e("asdsadsd", "onViewCreated: "+imagePath);
            Log.e("asdsadsd", "onViewCreated: "+signupUserModel.getImage());
            repository.updateUser(
                    SharedPreferences.GetLogInUserId(),
                    signupUserModel.getFname(),
                    signupUserModel.getLname(),
                    signupUserModel.getMobile(),
                    signupUserModel.getCnic(),
                    signupUserModel.getGender(),
                    signupUserModel.getDob(),
                    SharedPreferences.GetEmailId(),
                    SharedPreferences.GetPassword(),
                    signupUserModel.getAddress(),
                    signupUserModel.getImage(),
                    "applicant"


            );
        });
        repository.getUpdateUser().observe(getViewLifecycleOwner(), s -> {
            Navigation.findNavController(view).navigateUp();
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        binding.layoutDob.etEmail.setText(dateFormat.format(myCalendar.getTime()));
    }
}