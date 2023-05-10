package com.jovanovic.stefan.sqlitetutorial;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jovanovic.stefan.sqlitetutorial.Handle.DBHelper;
import com.jovanovic.stefan.sqlitetutorial.Model.Tai_khoan;

public class CapTK extends AppCompatActivity {
    private EditText etFullName, etUsername, etPassword;
    private Button btnCreateAccount;

    private DBHelper dbHelper;
    private String bac="null"; // Biến toàn cục

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cap_tk);

        // Initialize views and database helper
        etFullName = findViewById(R.id.etFullName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        //
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgAccountType);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.rbPolice);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.rbManager);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbPolice) {
                    bac = "2"; // Gán giá trị cho biến toàn cục
                } else if (checkedId == R.id.rbManager) {
                    bac = "3"; // Gán giá trị cho biến toàn cục
                }
            }
        });

        //

        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        dbHelper = new DBHelper(this);

        // Set click listener for register button
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String CCCD = etFullName.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validate user input
                if (TextUtils.isEmpty(CCCD)) {
                    etFullName.setError("Please enter your CCCD");
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    etUsername.setError("Please enter your username");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Please enter your password");
                    return;
                }

                // Check if email already exists in database
                Tai_khoan acc = dbHelper.getAcc(username);
                if (acc != null) {
                    Toast.makeText(CapTK.this, "username already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add user to database
                boolean isSuccess = dbHelper.addAcc(new Tai_khoan(username, password,CCCD , bac)); // Sử dụng biến toàn cục ở đây
                if (isSuccess) {
                    Toast.makeText(CapTK.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CapTK.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for login text view

    }
}

