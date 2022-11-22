package com.exemple.thenternal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    EditText email,pass,confirm;
    RelativeLayout btnSignUp;
    TextView back;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.up_username);
        pass=findViewById(R.id.up_pass);
        confirm=findViewById(R.id.up_confirm);
        btnSignUp=findViewById(R.id.signup);
        back=findViewById(R.id.back);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,password;
                mail=email.getText().toString();
                password=pass.getText().toString();
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(signUp.this, "vui lòng nhập email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(signUp.this, "vui lòng nhập password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signUp.this, "tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signUp.this, signIn.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(signUp.this, "tạo tài khoản no thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this, signIn.class);
                startActivity(intent);
            }
        });

    }
}