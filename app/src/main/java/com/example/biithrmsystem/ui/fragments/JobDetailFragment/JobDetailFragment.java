package com.example.biithrmsystem.ui.fragments.JobDetailFragment;

import static com.example.biithrmsystem.commons.Appconstants.JOB_ID;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.ApplyJobModel;
import com.example.biithrmsystem.commons.Function;
import com.example.biithrmsystem.commons.SharedPreferences;
import com.example.biithrmsystem.databinding.FragmentJobDetailBinding;
import com.example.biithrmsystem.repositories.Repository;


public class JobDetailFragment extends Fragment {
    Repository repository;
    private Intent requestFileIntent;
    private ParcelFileDescriptor inputPFD;
    private Uri uriOfDocument = null;
    private int jobId = 0;
    private FragmentJobDetailBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestFileIntent = new Intent(Intent.ACTION_PICK);
        requestFileIntent.setType("image/jpg");
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentJobDetailBinding.inflate(inflater, container, false);
        repository = new Repository();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jobId = requireArguments().getInt(JOB_ID, 0);
        repository.jobDetail(jobId);

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    uriOfDocument = uri;
                    Log.e("Uri", "onActivityResult: " + uri);
                });

        repository.jobDetailLiveData.observe(getViewLifecycleOwner(), jobs -> {
            Log.e("JObs", "onViewCreated: " + jobs.toString());
            initValue(binding.tvNameValue, jobs.get(0).getTitle());
            initValue(binding.tvNumberValue, jobs.get(0).getSalary());
            initValue(binding.tvCnicValue, jobs.get(0).getLocation());
            initValue(binding.tvDateOfBirthValue, jobs.get(0).getLastDateOfApply());
            initValue(binding.tvGenderValue, jobs.get(0).getDescription());
        });

        binding.btnEdit.setOnClickListener(v -> {
            requireActivity().overridePendingTransition(R.anim.slide_in_top, R.anim.slide_in_bottom);

            binding.cvLayout.setVisibility(View.VISIBLE);
            binding.applicaitonProfile.setVisibility(View.GONE);
        });
        binding.btnUploadCv.setOnClickListener(v -> mGetContent.launch("application/pdf"));
        binding.btnSubmit.setOnClickListener(v -> {


            if (uriOfDocument != null) {
                repository.JobFileApplicationPost(jobId, SharedPreferences.GetLogInUserId(), uriOfDocument.toString());
            } else {
                repository.JobFileApplicationPost(jobId, SharedPreferences.GetLogInUserId(), "no cv selected");
                Function.showToast("Select Your Cv First", requireContext());
            }
        });

        repository.appyJob.observe(getViewLifecycleOwner(), s -> {
            if (s != null) {
                Function.showToast("" + s, requireContext());
            }
            Navigation.findNavController(view).navigateUp();
        });
    }

    @SuppressLint("SetTextI18n")
    void initValue(AppCompatTextView tvNameValue, String value) {
        try {
            if (value != null) {
                tvNameValue.setText("" + value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}