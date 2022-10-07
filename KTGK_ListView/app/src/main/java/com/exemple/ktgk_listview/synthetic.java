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

import com.exemple.ktgk_listview.Fragment.Fragment_1;
import com.exemple.ktgk_listview.Fragment.Fragment_2;
import com.exemple.ktgk_listview.Fragment.Fragment_3;
import com.google.android.material.navigation.NavigationView;

public class synthetic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  static final int FM_HOME = 0;
    private  static final int FM_FAVORITE = 1;
    private  static final int FM_HISTORY = 2;

    private int mCurrentFragment = FM_HOME;

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthetic);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new Fragment_1());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home){
            if(mCurrentFragment != FM_HOME)
            {
                replaceFragment(new Fragment_1());
                mCurrentFragment = FM_HOME;
            }

        }else if(id == R.id.nav_favorite){
            if(mCurrentFragment != FM_FAVORITE)
            {
                replaceFragment(new Fragment_2());
                mCurrentFragment = FM_FAVORITE;
            }

        }else if(id == R.id.nav_history){
            if(mCurrentFragment != FM_HISTORY)
            {
                replaceFragment(new Fragment_3());
                mCurrentFragment = FM_HISTORY;
            }

        }else if(id == R.id.nav_my_profile){
            Intent intentHistory = new Intent(this ,profile.class);
            startActivity(intentHistory);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace( R.id.content_frame, fragment );
        transaction.commit();
    }
}