package com.example.biithrmsystem.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
//            if (destination.getId() == R.id.navigation_login) {
//                binding.headerLayout.headerLayout.setVisibility(View.VISIBLE);
//            } else {
//                binding.headerLayout.headerLayout.setVisibility(View.GONE);
//            }
        });

        binding.headerLayout.ivMenu.setOnClickListener(v -> binding.drawerLayout.openDrawer(GravityCompat.START));


    }

}