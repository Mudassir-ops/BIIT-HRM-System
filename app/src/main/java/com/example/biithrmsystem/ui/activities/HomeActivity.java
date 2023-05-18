package com.example.biithrmsystem.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.databinding.ActivityHomeBinding;

import java.util.concurrent.Executor;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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