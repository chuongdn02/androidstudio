package com.share4happy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.share4happy.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;

    ListView lvDanhba;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControls();
        showAllContact();



    }
    private void showAllContact(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor= getContentResolver().query(uri,null,null,null,null );
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String tenCotName =ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone= ContactsContract.CommonDataKinds.Phone.NUMBER;

            int viTriCotName= cursor.getColumnIndex(tenCotName);
            int viTriCotPhone= cursor.getColumnIndex(tenCotPhone);

            String name= cursor.getString(viTriCotName);
            String phone= cursor.getString(viTriCotPhone );

            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();

        }
    }
    private void addControls(){
        lvDanhba= findViewById(R.id.lvDanhBa);
        dsDanhBa= new ArrayList<>();
        adapterDanhBa= new ArrayAdapter<>(
                DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvDanhba.setAdapter(adapterDanhBa);

    }
}