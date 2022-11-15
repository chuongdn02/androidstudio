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

public class signUp extends AppCompatActivity {
    EditText email,pass,confirm;
    RelativeLayout btnSignUp;
    TextView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        email=findViewById(R.id.up_username);
        pass=findViewById(R.id.up_pass);
        confirm=findViewById(R.id.up_confirm);
        btnSignUp=findViewById(R.id.signup);
        back=findViewById(R.id.back);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this, signIn.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().equals("") || pass.getText().toString().equals("") || confirm.getText().toString().equals("") ) {
                    Toast.makeText(signUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = new Intent(signUp.this, signIn.class);

                    Toast.makeText(signUp.this, "successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
            }
        });
    }
}