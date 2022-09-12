package com.exemple.editlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonAn;
    Button btnAdd,btnEdit;
    EditText txtEdit;
    ArrayList<String> arrayCourse;
    int vt=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonAn = (ListView) findViewById(R.id.lvProducts);
        btnAdd = (Button) findViewById(R.id.btnA);
        btnEdit = (Button)  findViewById(R.id.btnE);
        txtEdit = (EditText) findViewById(R.id.txtE);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("cơm");
        arrayCourse.add("mỳ");
        arrayCourse.add("bún");
        arrayCourse.add("phở");
        arrayCourse.add("hủ tiếu");

        ArrayAdapter  adapter = new ArrayAdapter(
            MainActivity.this,
                android.R.layout.simple_list_item_activated_1,
            arrayCourse);
        lvMonAn.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monAn =txtEdit.getText().toString();
                arrayCourse.add(monAn);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtEdit.setText(arrayCourse.get(i));
                vt=i;
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vt,txtEdit.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lvMonAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
              arrayCourse.remove(i);
              adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}