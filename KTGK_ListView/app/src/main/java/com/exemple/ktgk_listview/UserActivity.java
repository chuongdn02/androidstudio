package com.exemple.ktgk_listview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.exemple.ktgk_listview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent =this.getIntent();

        if(intent != null){
            String name = intent.getStringExtra("name");
//            String clb = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            String dob = intent.getStringExtra("dob");
            String hei = intent.getStringExtra("hei");
            String wei = intent.getStringExtra("wei");
            String year = intent.getStringExtra("year");
            String team = intent.getStringExtra("team");
            String match = intent.getStringExtra("match");
            String goal = intent.getStringExtra("goal");

            int imageid = intent.getIntExtra("imageid",R.drawable.gi);

            binding.nameProfile.setText(name);
//            binding.phoneProfile.setText(phone);
            binding.dob.setText(dob);
            binding.Nation.setText(country);
            binding.weight.setText(wei);
            binding.height.setText(hei);
            binding.year.setText(year);
            binding.team.setText(team);
            binding.match.setText(match);
            binding.goal.setText(goal);

            binding.profileImage.setImageResource(imageid);

        }

    }
}
