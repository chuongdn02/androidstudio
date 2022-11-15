package com.exemple.editlistview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class signIn extends AppCompatActivity {
    EditText email,pass;
    RelativeLayout btnLogin;
    TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        email=findViewById(R.id.edt_username);
        pass=findViewById(R.id.edt_password);
        btnLogin=findViewById(R.id.login);
        btnRegister=findViewById(R.id.newAcc);
        String passUname = getIntent().getStringExtra("username");
        String passPword = getIntent().getStringExtra("password");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(signIn.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((email.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                        || (email.getText().toString().equals(passUname) && pass.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(signIn.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(signIn.this, "incorrect account or password!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signIn.this, signUp.class);
                startActivity(intent);
            }
        });


    }
}
