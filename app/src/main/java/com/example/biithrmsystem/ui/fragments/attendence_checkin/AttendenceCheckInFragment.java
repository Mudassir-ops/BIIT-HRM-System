package com.example.biithrmsystem.ui.fragments.attendence_checkin;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.api.datamodel.AttendenceModel;
import com.example.biithrmsystem.api.datamodel.JobResponse;
import com.example.biithrmsystem.commons.Function;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentAttendenceCheckInBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AttendenceCheckInFragment extends Fragment {

    final Calendar myCalendar = Calendar.getInstance();
    private FragmentAttendenceCheckInBinding binding;
    private Repository repository;
    private ArrayList<JobResponse> listOfAllJobResponses;
    private int srcImage;
    private String title;
    private String mobileNO;

    private Boolean isCHeckIn = false;
    private int userPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAttendenceCheckInBinding.inflate(inflater, container, false);


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

        assert getArguments() != null;
        srcImage = getArguments().getInt("IMAGE_ID", 0);
        mobileNO = getArguments().getString("PHON_NO", "");
        title = getArguments().getString("TITLE", "");
        isCHeckIn = getArguments().getBoolean("TYPE", false);
        userPosition = getArguments().getInt("POSITION", 0);


        binding.layoutCehckOutInner.etEmail.setOnClickListener(v -> {
            Log.e("sadsads", "onViewCreated: ");
            new DatePickerDialog(requireContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        binding.layoutCehckInInner.etEmail.setOnClickListener(v -> timePickerDialog());
        binding.profilePick.setImageResource(srcImage);
        binding.tvNameValue.setText(title);
        binding.tvNumberValue.setText(mobileNO);
        if (isCHeckIn) {
            binding.layoutCehckInInner.name.setText("Check-in Time");
            binding.layoutCehckInInner.etEmail.setHint("Check Time");
            binding.layoutCehckOutInner.name.setText("Check-in Date");
            binding.layoutCehckOutInner.etEmail.setHint("Pick Date");
            binding.btnAction.setText("Check In");
        } else {
            binding.layoutCehckInInner.name.setText("Check-out Time");
            binding.layoutCehckInInner.etEmail.setHint("Check Time");
            binding.layoutCehckOutInner.name.setText("Check-out Date");
            binding.layoutCehckOutInner.etEmail.setHint("Pick Date");
            binding.btnAction.setText("Check Out");
        }
        binding.btnAction.setOnClickListener(v -> {
            AttendenceModel attendenceModel = new AttendenceModel();
            if (isCHeckIn) {
                Log.e("sadasd", "onViewCreated: " + "CHECKED_IN_" + userPosition);
                Log.e("sadasd", "onViewCreated: " + "CHECKED_IN_" + Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()));
                switch (userPosition) {
                    case 0:
                        SharedPreferences.setCheckedInUser0(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 1:
                        SharedPreferences.setCheckedInUser1(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 2:
                        SharedPreferences.setCheckedInUser2(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 3:
                        SharedPreferences.setCheckedInUser3(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 4:
                        SharedPreferences.setCheckedInUser4(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 5:
                        SharedPreferences.setCheckedInUser5(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 6:
                        SharedPreferences.setCheckedInUser6(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 7:
                        SharedPreferences.setCheckedInUser7(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 8:
                        SharedPreferences.setCheckedInUser8(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 9:
                        SharedPreferences.setCheckedInUser9(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    case 10:
                        SharedPreferences.setCheckedInUser10(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                        break;
                    default:
                        break;
                }

                Navigation.findNavController(view).navigateUp();
            } else {
                attendenceModel.setUid(String.valueOf(SharedPreferences.GetLogInUserId()));
                attendenceModel.setDate(Objects.requireNonNull(binding.layoutCehckOutInner.etEmail.getText()).toString());
                switch (userPosition) {
                    case 0: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser0());
                        break;
                    }
                    case 1: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser1());
                        break;
                    }
                    case 2: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser2());
                        break;
                    }
                    case 3: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser3());
                        break;
                    }
                    case 4: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser4());
                        break;
                    }
                    case 5: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser5());
                        break;
                    }
                    case 6: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser6());
                        break;
                    }
                    case 7: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser7());
                        break;
                    }
                    case 8: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser8());
                        break;
                    }
                    case 9: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser9());
                        break;
                    }
                    case 10: {
                        attendenceModel.setCheckin(SharedPreferences.GetCheckedInUser10());
                        break;
                    }
                    default:
                        break;

                }
                attendenceModel.setStatus("present");
                attendenceModel.setCheckout(Objects.requireNonNull(binding.layoutCehckInInner.etEmail.getText()).toString());
                repository.AttendancePost(attendenceModel);
            }

        });
        repository.attendeceModel.observe(getViewLifecycleOwner(), s -> {
            Function.showToast("" + s, requireContext());
            switch (userPosition) {
                case 0:
                    SharedPreferences.setCheckedInUser0("");
                    break;
                case 1:
                    SharedPreferences.setCheckedInUser1("");
                    break;
                case 2:
                    SharedPreferences.setCheckedInUser2("");
                    break;
                case 3:
                    SharedPreferences.setCheckedInUser3("");
                    break;
                case 4:
                    SharedPreferences.setCheckedInUser4("");
                    break;
                case 5:
                    SharedPreferences.setCheckedInUser5("");
                    break;
                case 6:
                    SharedPreferences.setCheckedInUser6("");
                    break;
                case 7:
                    SharedPreferences.setCheckedInUser7("");
                    break;
                case 8:
                    SharedPreferences.setCheckedInUser8("");
                    break;
                case 9:
                    SharedPreferences.setCheckedInUser9("");
                    break;
                case 10:
                    SharedPreferences.setCheckedInUser10("");
                    break;
                default:
                    break;
            }

            Navigation.findNavController(view).navigateUp();
        });

    }

    private void timePickerDialog() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(requireContext(), (timePicker, selectedHour, selectedMinute) -> {
            if (isCHeckIn) {
                binding.layoutCehckInInner.etEmail.setText(selectedHour + ":" + selectedMinute);
            } else {
                binding.layoutCehckInInner.etEmail.setText(selectedHour + ":" + selectedMinute);
            }

        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        if (isCHeckIn) {
            binding.layoutCehckOutInner.etEmail.setText(dateFormat.format(myCalendar.getTime()));
        } else {
            binding.layoutCehckOutInner.etEmail.setText(dateFormat.format(myCalendar.getTime()));
        }
    }
}