package com.example.biithrmsystem.ui.fragments.attendence_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.AttendenceReportAdapter;
import com.example.biithrmsystem.api.datamodel.AttendanceRecord;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentAttendenceReport2Binding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;

public class AttendenceReportFragment extends Fragment implements AttendenceReportAdapter.ItemClickListener {

    AttendenceReportAdapter adapter;
    private FragmentAttendenceReport2Binding binding;
    private Repository repository;

    private ArrayList<AttendanceRecord> arrayList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
        arrayList = new ArrayList<AttendanceRecord>();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAttendenceReport2Binding.inflate(inflater, container, false);
        repository.AlldatewithidAttendanceGet(SharedPreferences.GetLogInUserId());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repository.listMutableLiveData.observe(getViewLifecycleOwner(), leaveModels -> {

            if (leaveModels != null) {
                arrayList.clear();
                arrayList.addAll(leaveModels.attendanceRecords);
                initRecyclerView(arrayList);
            }

        });

    }

    ///-----here init method to show data in recyclerview
    void initRecyclerView(ArrayList<AttendanceRecord> jobResponseArrayList) {
        binding.rvDataList.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AttendenceReportAdapter(requireContext(), jobResponseArrayList);
        adapter.setClickListener(this);
        binding.rvDataList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, AttendanceRecord attendanceRecord) {
        Log.e("TAG", "onItemClick: " + attendanceRecord);
        Bundle bundle = new Bundle();
        bundle.putParcelable("RECORD", attendanceRecord);
        Navigation.findNavController(view).navigate(R.id.navigation_attende_report_to_detail_attendecne, bundle);
    }
}