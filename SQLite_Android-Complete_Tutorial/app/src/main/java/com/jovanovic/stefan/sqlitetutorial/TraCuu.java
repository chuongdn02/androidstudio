package com.jovanovic.stefan.sqlitetutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jovanovic.stefan.sqlitetutorial.Function.Lap_bien_ban;
import com.jovanovic.stefan.sqlitetutorial.Handle.DBHelper;
import com.jovanovic.stefan.sqlitetutorial.Model.Tai_khoan;

import java.util.Random;

public class TraCuu extends AppCompatActivity {
    private TextView tvWelcome,et_Bienso,et_maXacNhan;
    private TextView textV;
    private Button btnLogout;
    private SharedPreferences pref;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu);

        // Initialize views and database helper
        tvWelcome = findViewById(R.id.tv_Name);
        et_Bienso =findViewById(R.id.et_Bienso);
        et_maXacNhan =findViewById(R.id.et_maXacNhan);
        textV = findViewById(R.id.textView);
        btnLogout = findViewById(R.id.btn_logout);
        pref = getSharedPreferences("user_details", MODE_PRIVATE);
        dbHelper = new DBHelper(this);





        Spinner vehicleTypeSpinner = findViewById(R.id.vehicle_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicle_types, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(adapter);
        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedVehicleType = parent.getItemAtPosition(position).toString();
                // Thực hiện xử lý với giá trị loại xe đã chọn
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không làm gì khi không có loại xe nào được chọn
            }
        });

        // Get User object from intent extras
        String userJson = getIntent().getStringExtra("acc");
        Gson gson = new Gson();
        Tai_khoan account = gson.fromJson(userJson, Tai_khoan.class);

        // Set welcome message
        tvWelcome.setText("Xin chào: " + account.getUsername() + "!");

        //random ma xac nhan
        Random random = new Random();

        // Tạo chuỗi ngẫu nhiên 6 kí tự
        String randomString = "";
        for (int i = 0; i < 6; i++) {
            // Sinh một số nguyên ngẫu nhiên từ 0 đến 25, sau đó chuyển đổi thành ký tự chữ cái
            char c = (char) (random.nextInt(26) + 'a');
            randomString += c;
        }
        String rand = randomString;

        // Hiển thị chuỗi ngẫu nhiên lên TextView
        textV.setText(rand);

        // Set click listener for logout button
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear shared preferences
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();
                String maXN = et_maXacNhan.getText().toString().trim();
                String maxacnhan= textV.getText().toString().trim();
                if(!maxacnhan.equals(maXN)){
                    textV.setError("Verification does not match");
                    return;
                }

                Intent intent = new Intent(TraCuu.this, chi_tiet_bb.class);
                intent.putExtra("bienso", et_Bienso.getText().toString());
                intent.putExtra("loaiphuongtien", vehicleTypeSpinner.getSelectedItem().toString());
                startActivity(intent);
                finish();
                // Start LoginActivity

            }
        });
    }
}
