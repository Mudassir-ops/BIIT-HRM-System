package com.example.biithrmsystem.ui.fragments.add_comitte_members;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.ComitteReponseParcableModel;
import com.example.biithrmsystem.databinding.FragmentAddComittieMembersBinding;

public class AddComittieMembersFragment extends Fragment {

    private ComitteReponseParcableModel comitteReponseParcableModel;
    private FragmentAddComittieMembersBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddComittieMembersBinding.inflate(inflater, container, false);
        comitteReponseParcableModel = new ComitteReponseParcableModel();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        comitteReponseParcableModel = getArguments().getParcelable("MODEL");
        Log.e("mahziab", "onViewCreated: " + comitteReponseParcableModel.committeeTitle);
        binding.tvLabelComitteValue.setText("" + comitteReponseParcableModel.committeeTitle);

        binding.addMembers.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("COmiite_ID", comitteReponseParcableModel.committeeId);
            Navigation.findNavController(view).navigate(R.id.action_navigation_add_comittie_members_to_navigation_comitte_head, bundle);

        });


    }
}