package com.example.biithrmsystem.ui.fragments.attendence_report;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.biithrmsystem.api.datamodel.AttendanceRecord;
import com.example.biithrmsystem.databinding.FragmentAttendencedetailBinding;


public class AttendencedetailFragment extends Fragment {

    private FragmentAttendencedetailBinding binding;
    private AttendanceRecord dataModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataModel = new AttendanceRecord();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAttendencedetailBinding.inflate(inflater, container, false);
        dataModel = requireArguments().getParcelable("RECORD");
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.date.setText("" + dataModel.date);
        binding.timeIn.setText("" + dataModel.records.get(0).checkin);
        binding.timeOut.setText("" + dataModel.records.get(0).checkout);
    }


}