package com.exemple.ktgk_listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.exemple.ktgk_listview.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private DrawerLayout mDrawerLayout;


    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        int[] imageId = {R.drawable.gi, R.drawable.kaka, R.drawable.kevin, R.drawable.mount, R.drawable.ney,
                R.drawable.persie, R.drawable.reus, R.drawable.torres};
        String[] name = {"Olivier Giroud","Ricardo Kaka","Kevin De Bruyne","Mason Mount",
                "Neymar Jr","Van Persie","Marco Reus","Fernando Torres"};
        String[] lastMessage = {"Striker","Midfielder","Midfielder","RightWing","LeftWing","Striker","Midfielder","Striker"};
        String[] lastTime = {"1986","1982","1991","1999","1992","1983","1989","1984"};
        String[] clb = {"Chelsea","Milan","Man City","Chelsea","PSG","","Dortmund","Liverpool"};
        String[] country = {"France","Brazil","Belgium","England","Brazil","Holland","Germany","Spain"};
        String[] wei = {"88 kg","82 kg","70 kg","74 kg","68 kg","71 kg","71 kg","78 kg"};
        String[] hei = {"1.93 m","1.87 m","1.81 m","1.80 m","1.75 m","1.88 m","1.80 m","1.84 m"};
        String[] dob = {"30/09/1986","22/04/1982","28/06/1991","10/01/1999","05/02/1992","06/08/1983","31/05/1989","20/03/1984"};
        String[] year = {"\t2005-2008\n\t2007-2009\n\t2008-1010\n\t2010-2012\n\t2010\n\t2012-2018\n\t2018-2012\n\t2021-",
                "\t2001-2003\n\t2003-2009\n\t2009-2013\n\t2013-2014\n\t2014-2017\n\t2014",
                "\t2008-2012\n\t2012-2014\n\t2012-2013\n\t2014-2015\n\t2015-",
                "\t2017-\n\t2017-2018\n\t2018-2019",
                "\t2009-2013\n\t2013-2017\n\t2017-",
                "\t2001-2004\n\t2004-2012\n\t2012-2015\n\t2015-2018\n\t2018-2019",
                "\t2006-2007\n\t2007-2009\n\t2009-2012\n\t2012-",
                "\t2001-2007\n\t2007-2011\n\t2011-1015\n\t2014-2015\n\t2015-2016\n\t2015-2016\n\t2016-2018\n\t2018-2019"};
        String[] team = {"\tGrenoble\n\tIstres\n\tTours\n\tMontpellier\n\tTours\n\tArsenal\n\tChelsea\n\tMilan",
                "\tSão Paulo\n\tMilan\n\tReal Madrid\n\tMilan\n\tOrlando City\n\tSão Paulo",
                "\tGenk\n\tChelsea\n\tWerder Bremen\n\tWolfsburg\n\tManchester City",
                "\tChelsea\n\tvitesse\n\tDerby County",
                "\tSantos\n\tBarcelona\n\tParis Saint-Germain",
                "\tFeyenoord\n\tArsenal\n\tManchester United\n\tFenerbahçe\n\tFeyenoord",
                "\tRot Weiss Ahlen II\n\tRot Weiss Ahlen\n\tBorussia Mönchengladbach\n\tBorussia Dortmund",
                "\tAtlético Madrid\n\tLiverpool\n\tChelsea\n\tMilan\n\tMilan\n\tAtlético Madrid\n\tAtlético Madrid\n\tSagan Tosu"};
        String[] match = {"23\n33\n44\n73\n17\n180\n75\n36","59\n193\n85\n30\n73\n19",
                "97\n3\n33\n52\n209","112\n29\n35",
                "177\n123\n100","61\n194\n86\n57\n37",
                "6\n43\n97\n250","214\n102\n110\n10\n0\n49\n58\n35"};
        String[] goal = {"2\n14\n24\n33\n6\n73\n17\n15","23\n70\n23\n7\n24\n2",
                "16\n0\n10\n13\n58","24\n9\n8",
                "107\n68\n77","15\n96\n48\n25\n21",
                "3\n5\n36\n110","82\n65\n20\n1\n0\n14\n13\n5"};
        ArrayList<User> userArrayList = new ArrayList<>();
        for(int i=0 ; i< imageId.length; i++){
            User user = new User(name[i],lastMessage[i],lastTime[i],clb[i],country[i],wei[i],hei[i],dob[i],year[i],team[i],match[i],goal[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra( "name",name[position]);
                i.putExtra( "phone",clb[position]);
                i.putExtra( "country",country[position]);
                i.putExtra( "imageid",imageId[position]);
                i.putExtra("wei",wei[position]);
                i.putExtra("hei",hei[position]);
                i.putExtra("dob",dob[position]);
                i.putExtra("year",year[position]);
                i.putExtra("team",team[position]);
                i.putExtra("match",match[position]);
                i.putExtra("goal",goal[position]);

                startActivity(i);


            }
        });


    }



}