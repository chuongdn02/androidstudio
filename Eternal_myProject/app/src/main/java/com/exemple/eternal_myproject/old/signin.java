package com.exemple.eternal_myproject.old;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.exemple.eternal_myproject.MainActivity;
import com.exemple.eternal_myproject.R;
import com.exemple.eternal_myproject.UserAdapter;
import com.exemple.eternal_myproject.model.User;
import com.exemple.eternal_myproject.remote.APIUtils;
import com.exemple.eternal_myproject.remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signin  extends AppCompatActivity {
    UserService userService;
    RelativeLayout login;
    TextView newAcc;
    EditText username, password;


    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        login = findViewById(R.id.login);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        newAcc = findViewById(R.id.newAcc);
        userService = APIUtils.getUserService();
        getUsersList();
        mListUser = new ArrayList<>();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
                        Toast.makeText(signin.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();


                    } else
                        for (User user : mListUser) {
                        if ((username.getText().toString().trim().equals(user.getUsername()) && password.getText().toString().trim().equals(user.getPassword()))
                    ) {

                        Intent intent = new Intent(signin.this, MainActivity.class);
                        startActivity(intent);
                            username.setText("");
                            password.setText("");
                        break;

                    } }





            }
        });

        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, register.class);
                startActivity(intent);
            }
        });


    }

    public void getUsersList() {
        Call<List<User>> call = userService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    mListUser = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}
