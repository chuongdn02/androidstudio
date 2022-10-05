package com.share4happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }
    private void addEvents(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moDanhBa();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moTinNhan();
            }
        });
    }



    private void moTinNhan(){

    }
    private void moDanhBa(){
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.share4happy","com.share4happy.DanhBa");
        startActivity(intent);

    }

    private void addControl(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }


}