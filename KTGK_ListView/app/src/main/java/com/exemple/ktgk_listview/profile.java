package com.exemple.ktgk_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        textView = (TextView) findViewById(R.id.exit);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackMain();
            }
        });
    }

    private void BackMain() {
        Intent intent = new Intent(this, synthetic.class);
        startActivity(intent);
    }
}
