package com.exemple.editlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   RecyclerView rcv_ns;
   nghesyadapter mnghesyadapter;
   nghesy nghesy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcv_ns =findViewById(R.id.rcvns);
        mnghesyadapter = new nghesyadapter(this);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_ns.setLayoutManager(linearLayoutManager1);
        mnghesyadapter.setData(getListns());
        rcv_ns.setAdapter(mnghesyadapter);
    }
    private List<nghesy> getListns(){
        List<nghesy> list = new ArrayList<>();
        list.add(new nghesy("Jack","j97","5*","Việt Nam",R.drawable.ney));
        list.add(new nghesy("Anh Tú","Atus","5*","Việt Nam",R.drawable.img));
        list.add(new nghesy("Justin BieBer","Justin","5*","Canada",R.drawable.img_1));
        list.add(new nghesy("Bùi Anh Tuấn","Tuan","5*","Việt Nam",R.drawable.img_2));
        list.add(new nghesy("Jack","j97","5*","Việt Nam",R.drawable.ney));
        list.add(new nghesy("Anh Tú","Atus","5*","Việt Nam",R.drawable.img));
        list.add(new nghesy("Justin BieBer","Justin","5*","Canada",R.drawable.img_1));
        list.add(new nghesy("Bùi Anh Tuấn","Tuan","5*","Việt Nam",R.drawable.img_2));
        return list;
    }
}