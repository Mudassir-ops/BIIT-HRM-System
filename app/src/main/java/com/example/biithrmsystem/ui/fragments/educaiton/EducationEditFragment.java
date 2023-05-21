package com.example.biithrmsystem.ui.fragments.educaiton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.Education;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentEducationEditBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public class EducationEditFragment extends Fragment {

    final Calendar myCalendar1 = Calendar.getInstance();
    final Calendar myCalendar2 = Calendar.getInstance();
    String[] degreArray = new String[5];
    private FragmentEducationEditBinding binding;
    private Repository repository;
    private String degree = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEducationEditBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.headerLayout.tvHeader.setText("Education");
        degreArray = getResources().getStringArray(R.array.degree_array);

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
        binding.spinnerDegree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                degree = degreArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Education education = new Education();
                education.setDegree(degree);
                education.setUid(SharedPreferences.GetLogInUserId());
                education.setInstitute(Objects.requireNonNull(binding.etInstitiute.getText()).toString());
                education.setBoard(Objects.requireNonNull(binding.etBoard.getText()).toString());
                education.setStartdate(Objects.requireNonNull(binding.etStartDate.getText()).toString());
                education.setEnddate(Objects.requireNonNull(binding.etEndDate.getText()).toString());
                repository.postEducation(education);
            }
        });
        repository.postEducationModelMutableLiveData.observe(getViewLifecycleOwner(), s -> {
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