package com.exemple.tuan5_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn  extends AppCompatActivity {
    private Button button,button2;
    EditText editText, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.rg);
        editText = findViewById(R.id.username);
        editText2 = findViewById(R.id.pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenRegister();
            }
        });
        button2 = findViewById(R.id.btnLogin);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenProfile();
            }
        });
    }
    private void OpenRegister() {
        Intent intent = new Intent(this , register.class);
        startActivity(intent);
    }
    private void OpenProfile() {
        Intent intent = new Intent(this , profile.class);
        String username = "chuong",pass= "1";
        startActivity(intent);
    }

}
