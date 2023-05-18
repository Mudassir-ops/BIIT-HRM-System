package com.example.biithrmsystem.ui.fragments.educaiton;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.FragmentCompleteProfileBinding;
import com.example.biithrmsystem.databinding.FragmentEditPorfileBinding;
import com.example.biithrmsystem.databinding.FragmentEducationEditBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class EducationEditFragment extends Fragment {

    private FragmentEducationEditBinding binding;
    final Calendar myCalendar1 = Calendar.getInstance();
    final Calendar myCalendar2 = Calendar.getInstance();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        binding.etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(requireContext(), date, myCalendar1.get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH), myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        binding.etEndDate.setOnClickListener(v -> new DatePickerDialog(requireContext(), date1, myCalendar2.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH), myCalendar2.get(Calendar.DAY_OF_MONTH)).show());
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