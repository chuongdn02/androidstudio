package com.exemple.eternal_myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.exemple.eternal_myproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentHome fragmentHome = new FragmentHome();
    FragmentSearch fragmentSearch = new FragmentSearch();
    FragmentMess fragmentMess = new FragmentMess();
    FragmentBag fragmentBag = new FragmentBag();
    FragmentMe fragmentMe = new FragmentMe();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentHome).commit();
                        return true;
                    case R.id.noti:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentSearch).commit();
                        return true;
                    case R.id.mess:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMess).commit();
                        return true;
                    case R.id.bag:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentBag).commit();
                        return true;
                    case R.id.me:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragmentMe).commit();
                        return true;
                }
                return false;
            }
        });




//        new ReadJSONObject().execute("https://63610b8e67d3b7a0a6bc3240.mockapi.io/api/");
//
////        rcv

    }

//    private class ReadJSONObject extends AsyncTask<String,Void, String>{
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            StringBuilder content = new StringBuilder();
//
//            try {
//                URL url = new URL(strings[0]);
//                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
//
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//                String line = "";
//                while ((line=bufferedReader.readLine())!= null){
//                    content.append(line);
//                }
//                bufferedReader.close();
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//            return content.toString();
//        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//                JSONArray array = new JSONArray(s);
//                for (int i=0 ;i< array.length(); i++){
//                    JSONObject object = array.getJSONObject(i);
//                    String name = object.getString("name");
//                    String price = object.getString("price");
//                    String title = object.getString("title");
//                    String manu = object.getString("manu");
//                    String color = object.getString("color");
//                    Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
//                }
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }




}