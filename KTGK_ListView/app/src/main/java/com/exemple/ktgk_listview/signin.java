package com.exemple.ktgk_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signin extends AppCompatActivity {
    private Button button,button2;

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        button = findViewById(R.id.rg);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        button2 = findViewById(R.id.btnLogin);

        String passUname = getIntent().getStringExtra("username");
        String passPword = getIntent().getStringExtra("password");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(signin.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                        || (username.getText().toString().equals(passUname) && password.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(signin.this, synthetic.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(signin.this, "incorrect account or password!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, register.class);
                startActivity(intent);
            }
        });


    }
}
