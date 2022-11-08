package com.exemple.eternal_myproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.exemple.eternal_myproject.databinding.DetailActivityBinding;
import com.exemple.eternal_myproject.model.User;
import com.exemple.eternal_myproject.remote.APIUtils;
import com.exemple.eternal_myproject.remote.LapService;
import com.exemple.eternal_myproject.remote.UserService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {

    LapService lapService;

    TextView name_lap, price_lap, title_lap, manu_lap;
    ImageView img_lap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name_lap = (TextView) findViewById(R.id.name_lap);
        price_lap = (TextView) findViewById(R.id.price_lap);
        title_lap = (TextView) findViewById(R.id.title_lap);
        manu_lap = (TextView) findViewById(R.id.manu_lap);
        img_lap = (ImageView) findViewById(R.id.img_lap);


        lapService = APIUtils.getLapService();

        Bundle extras = getIntent().getExtras();
        String Name = extras.getString("lap_name");
        String Price = extras.getString("lap_price");
        String Title = extras.getString("lap_title");
        String Manu = extras.getString("lap_manu");
        String Pic = extras.getString("lap_pic");


        name_lap.setText(Name);
        price_lap.setText(Price);
        title_lap.setText(Title);
        manu_lap.setText(Manu);
        Picasso.get().load(Pic).into(img_lap);



//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                User u = new User();
//                u.setUsername(edtUsername.getText().toString());
//                if(userId != null && userId.trim().length() > 0){
//                    //update user
//                    updateUser(Integer.parseInt(userId), u);
//                } else {
//                    //add user
//                    addUser(u);
//                }
//            }
//        });

//        btnDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                deleteUser(Integer.parseInt(userId));
//
//                Intent intent = new Intent(UserAcivity.this, FragmentBag.class);
//                startActivity(intent);
//            }
//        });
//
//    }

//    public void addUser(User u){
//        Call<User> call = userService.addUser(u);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(UserAcivity.this, "User created successfully!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("ERROR: ", t.getMessage());
//            }
//        });
//    }
//
//    public void updateUser(int id, User u){
//        Call<User> call = userService.updateUser(id, u);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(UserAcivity.this, "User updated successfully!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("ERROR: ", t.getMessage());
//            }
//        });
//    }
//
//    public void deleteUser(int id){
//        Call<User> call = userService.deleteUser(id);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(UserAcivity.this, "User deleted successfully!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Log.e("ERROR: ", t.getMessage());
//            }
//        });
//    }
//
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);

    }
}