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

import com.exemple.eternal_myproject.R;
import com.exemple.eternal_myproject.UserAcivity;
import com.exemple.eternal_myproject.model.User;
import com.exemple.eternal_myproject.remote.APIUtils;
import com.exemple.eternal_myproject.remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register  extends AppCompatActivity {
    TextView textView;
    RelativeLayout signup;
    EditText edt_username,  edt_password, edt_confirm;
    TextView back;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        back = (TextView) findViewById(R.id.back);

        signup = findViewById(R.id.signup);

        edt_username = (EditText) findViewById(R.id.up_username);
        edt_password = (EditText) findViewById(R.id.up_pass);
        edt_confirm = (EditText) findViewById(R.id.up_confirm);

        userService = APIUtils.getUserService();

//        Bundle extras = getIntent().getExtras();
//        String userId = extras.getString("user_id");
//        String userName = extras.getString("user_name");
//        String userPass = extras.getString("user_pass");

//        edt_username.setText(userName);
//        edt_password.setText(userPass);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this, signin.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User u = new User();
                u.setUsername(edt_username.getText().toString());
                u.setPassword(edt_password.getText().toString());

                if(edt_username.getText().toString().equals("") || edt_password.getText().toString().equals("") || edt_confirm.getText().toString().equals("") ) {
                    Toast.makeText(register.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    addUser(u);
                    Intent intent = new Intent(register.this, signin.class);
                    Toast.makeText(register.this, "successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
            }
        });
    }
    public void addUser(User u){
        Call<User> call = userService.addUser(u);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(register.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    }
