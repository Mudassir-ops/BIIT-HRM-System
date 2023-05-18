package com.example.biithrmsystem.ui.fragments.experience_edit;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.Education;
import com.example.biithrmsystem.api.datamodel.Experience;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentEducationEditBinding;
import com.example.biithrmsystem.databinding.FragmentExperienceEditBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public class ExperienceEditFragment extends Fragment {

    private FragmentExperienceEditBinding binding;
    private Repository repository;

    final Calendar myCalendar1 = Calendar.getInstance();
    final Calendar myCalendar2 = Calendar.getInstance();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExperienceEditBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DatePickerDialog.OnDateSetListener date = (view1, year, month, day) -> {
            myCalendar1.set(Calendar.YEAR, year);
            myCalendar1.set(Calendar.MONTH, month);
            myCalendar1.set(Calendar.DAY_OF_MONTH, day);
            updateLabel1();
        };
        DatePickerDialog.OnDateSetListener date1 = (view1, year, month, day) -> {
            myCalendar2.set(Calendar.YEAR, year);
            myCalendar2.set(Calendar.MONTH, month);
            myCalendar2.set(Calendar.DAY_OF_MONTH, day);
            updateLabel2();

        };

        binding.etStartDate.setOnClickListener(v -> new DatePickerDialog(requireContext(), date, myCalendar1.get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH), myCalendar1.get(Calendar.DAY_OF_MONTH)).show());
        binding.etEndDate.setOnClickListener(v -> new DatePickerDialog(requireContext(), date1, myCalendar2.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH), myCalendar2.get(Calendar.DAY_OF_MONTH)).show());

        binding.btnSave.setOnClickListener(v -> {
            Experience experience = new Experience();
            experience.setUid(SharedPreferences.GetLogInUserId());
            experience.setCompany(Objects.requireNonNull(binding.etInstitiute.getText()).toString());
            experience.setStartdate(Objects.requireNonNull(binding.etStartDate.getText()).toString());
            experience.setEnddate(Objects.requireNonNull(binding.etEndDate.getText()).toString());
            experience.setTitle(Objects.requireNonNull(binding.etBoard.getText()).toString());
            String workingNow = "";
            if (binding.checkbox.isChecked()) {
                workingNow = "YES";
            } else {
                workingNow = "NO";
            }
            experience.setCurrentwork(workingNow);
            experience.setOtherskill(Objects.requireNonNull(binding.etAnyOtherSkill.getText()).toString());
            repository.postExperience(experience);
        });

        repository.postExperienceModelMutableLiveData.observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(requireContext(), "Posted" + s, Toast.LENGTH_LONG).show();
            Navigation.findNavController(view).navigateUp();

        });
    }

    private void updateLabel1() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        dateFormat.format(myCalendar1.getTime());
        binding.etStartDate.setText(dateFormat.format(myCalendar1.getTime()));

    }

    private void updateLabel2() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        dateFormat.format(myCalendar2.getTime());
        binding.etEndDate.setText(dateFormat.format(myCalendar2.getTime()));
    }
}