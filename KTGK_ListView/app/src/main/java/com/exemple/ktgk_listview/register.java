package com.exemple.ktgk_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class register extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText username,  password, cfirm;
    User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        textView = (TextView) findViewById(R.id.haveacc);

        button = findViewById(R.id.btnregister);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.passw);
        cfirm = (EditText) findViewById(R.id.cf);



        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(register.this, signin.class);
                    startActivity(intent);
                }
            });
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(username.getText().toString().equals("") || password.getText().toString().equals("") || cfirm.getText().toString().equals("") ) {
                        Toast.makeText(register.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(register.this, signin.class);
                        Toast.makeText(register.this, "successful", Toast.LENGTH_SHORT).show();
                        startActivity(intent);

                    }
                }
            });
        }
    }