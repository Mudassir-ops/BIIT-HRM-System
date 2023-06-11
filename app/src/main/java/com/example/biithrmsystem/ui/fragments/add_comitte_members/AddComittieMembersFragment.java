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
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.adapter.ComitteAddedMembersAdapter;
import com.example.biithrmsystem.api.datamodel.ComitteReponseParcableModel;
import com.example.biithrmsystem.api.datamodel.MemberOfComittieReponse;
import com.example.biithrmsystem.databinding.FragmentAddComittieMembersBinding;
import com.example.biithrmsystem.repositories.Repository;

import java.util.ArrayList;

public class AddComittieMembersFragment extends Fragment implements ComitteAddedMembersAdapter.ItemClickListener {

    ComitteAddedMembersAdapter adapter;
    private ComitteReponseParcableModel comitteReponseParcableModel;
    private FragmentAddComittieMembersBinding binding;
    private Repository repository = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new Repository();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddComittieMembersBinding.inflate(inflater, container, false);
        comitteReponseParcableModel = new ComitteReponseParcableModel();
        assert getArguments() != null;
        comitteReponseParcableModel = getArguments().getParcelable("MODEL");
        Log.e("mahziab", "onViewCreated: " + comitteReponseParcableModel.committeeTitle);
        repository.JobappWithCommitteeGet(comitteReponseParcableModel.committeeId);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvLabelComitteValue.setText("" + comitteReponseParcableModel.committeeTitle);

        binding.addMembers.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("COmiite_ID", comitteReponseParcableModel.committeeId);
            Navigation.findNavController(view).navigate(R.id.action_navigation_add_comittie_members_to_navigation_comitte_head, bundle);

        });

        repository.comittieMembers.observe(getViewLifecycleOwner(), memberOfComittieReponses -> {
            for (int i = 0; i < memberOfComittieReponses.size(); i++) {
                Log.e("USER_ID", "onViewCreated: " + memberOfComittieReponses.get(i).uid);
                repository.getUser(memberOfComittieReponses.get(i).uid);
            }
            initRecyclerView((ArrayList<MemberOfComittieReponse>) memberOfComittieReponses);
        });


        repository.getUser.observe(getViewLifecycleOwner(), userSignInResponses -> {

            for (int i = 0; i < userSignInResponses.size(); i++) {
                Log.e("userTitle", "onChanged: " + userSignInResponses.get(i).fname + " " + userSignInResponses.get(i).lname);
            }

        });

    }


    void initRecyclerView(ArrayList<MemberOfComittieReponse> jobArrayList) {
        binding.rvMembers.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        adapter = new ComitteAddedMembersAdapter(requireContext(), jobArrayList);
        adapter.setClickListener(this);
        binding.rvMembers.setAdapter(adapter);
    }


    @Override
    public void onItemClick(View view, int position) {

    }
}