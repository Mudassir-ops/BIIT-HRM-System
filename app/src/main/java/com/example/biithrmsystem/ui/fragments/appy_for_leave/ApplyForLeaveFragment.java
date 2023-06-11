package com.example.biithrmsystem.ui.fragments.appy_for_leave;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
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
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentApplyForLeaveBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public class ApplyForLeaveFragment extends Fragment {

    final Calendar myCalendar1 = Calendar.getInstance();
    final Calendar myCalendar2 = Calendar.getInstance();
    String[] leaveTypeArray = new String[5];
    String leaveType = "";
    private FragmentApplyForLeaveBinding binding;
    private Repository repository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentApplyForLeaveBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leaveTypeArray = getResources().getStringArray(R.array.leave_type_array);
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


        binding.spinnerLeave.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                leaveType = leaveTypeArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.btnSave.setOnClickListener(v -> repository.LeavePost(SharedPreferences.GetLogInUserId(), leaveType, Objects.requireNonNull(binding.etStartDate.getText()).toString(), Objects.requireNonNull(binding.etEndDate.getText()).toString(), Objects.requireNonNull(binding.etBoard.getText()).toString(), leaveType));
        repository.leavePost.observe(getViewLifecycleOwner(), s -> {
            Toast.makeText(requireContext(), "" + s, Toast.LENGTH_LONG).show();
            Log.e("mudassir", "onChanged: " + s);
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