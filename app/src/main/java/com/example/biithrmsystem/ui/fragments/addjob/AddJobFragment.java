package com.example.biithrmsystem.ui.fragments.addjob;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.PostJobModel;
import com.example.biithrmsystem.databinding.FragmentAddJobBinding;
import com.example.biithrmsystem.databinding.FragmentSignUpBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddJobFragment extends Fragment {
    final Calendar myCalendar = Calendar.getInstance();
    private FragmentAddJobBinding binding;
    private Repository repository;
    private String jobTitle = "";
    private String jobQualification = "";
    String[] jobArray = new String[5];
    String[] qualificationArray = new String[5];

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddJobBinding.inflate(inflater, container, false);
        repository = new Repository();
        jobArray = getResources().getStringArray(R.array.job_array);
        qualificationArray = getResources().getStringArray(R.array.job_array);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatePickerDialog.OnDateSetListener date = (view1, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };
        binding.headerLayout.tvHeader.setText("Post Job");
        binding.spinnerLastDateToApply.setOnClickListener(view12 -> new DatePickerDialog(requireContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
        binding.btnPost.setOnClickListener(v -> {
            PostJobModel postJobModel = new PostJobModel();
            postJobModel.setTitle(jobTitle);
            postJobModel.setSalary(Objects.requireNonNull(binding.spinnerSalary.getText()).toString().trim());
            String currentString = Objects.requireNonNull(binding.spinnerLastDateToApply.getText()).toString();
            String[] separated = currentString.split("/");
            postJobModel.setLastDateOfApply(Integer.parseInt(separated[1]));
            postJobModel.setLocation(Objects.requireNonNull(binding.spinnerLocation.getText()).toString().trim());
            postJobModel.setDescription(Objects.requireNonNull(binding.spinnerDescription.getText()).toString().trim());
            repository.postJob(postJobModel);

        });
        binding.spinnerJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                jobTitle = jobArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        binding.spinnerQualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                jobQualification = qualificationArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        repository.postJobModelMutableLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(), "" + s, Toast.LENGTH_LONG).show();
                Navigation.findNavController(view).navigateUp();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        binding.spinnerLastDateToApply.setText(dateFormat.format(myCalendar.getTime()));
    }
}