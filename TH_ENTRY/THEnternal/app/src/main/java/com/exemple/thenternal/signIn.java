package com.exemple.thenternal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signIn extends AppCompatActivity {

    EditText email,pass;
    RelativeLayout btnLogin;
    TextView btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth=FirebaseAuth.getInstance();

        email=findViewById(R.id.edt_username);
        pass=findViewById(R.id.edt_password);
        btnLogin=findViewById(R.id.login);
        btnRegister=findViewById(R.id.newAcc);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,password;
                mail=email.getText().toString();
                password=pass.getText().toString();
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(signIn.this, "vui lòng nhập email", Toast.LENGTH_SHORT).show();
                    return;
                }
                 if(TextUtils.isEmpty(password)){
                    Toast.makeText(signIn.this, "vui lòng nhập password", Toast.LENGTH_SHORT).show();
                    return;
                }
                 mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()){
                             Toast.makeText(signIn.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(signIn.this, MainActivity.class);
                             startActivity(intent);
                         }
                         else {
                             Toast.makeText(signIn.this, "đăng nhập no thành công", Toast.LENGTH_SHORT).show();
                         }
                     }
                 });



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