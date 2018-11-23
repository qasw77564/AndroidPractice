package com.example.asus.myapop;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.asus.myapop.fragment.Fragment01;
import com.example.asus.myapop.fragment.Fragment02;
import com.example.asus.myapop.fragment.Fragment03;
import com.example.asus.myapop.fragment.Fragment04;
import com.example.asus.myapop.fragment.Fragment06;
import com.example.asus.myapop.fragment.Fragment07;
import com.example.asus.myapop.fragment.HomeFragment;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity  {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;
    private BottomNavigationView b_nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment=new HomeFragment();
        final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_contaliner,homeFragment);
        fragmentTransaction.commit();

        b_nv=findViewById(R.id.bo_nav);
        navigationView=findViewById(R.id.nv);
        mDrawerLayout= findViewById(R.id.dl);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.menu_open,R.string.menu_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b_nv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id) {
                    case R.id.menu01:
                        HomeFragment homeFragment = new HomeFragment();
                        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_contaliner, homeFragment);
                        fragmentTransaction.commit();


                        break;
                    case R.id.menu02:
                        Fragment06 Fragment06 = new Fragment06();
                        final FragmentTransaction fragmentTransaction06 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction06.replace(R.id.fragment_contaliner, Fragment06);
                        fragmentTransaction06.commit();


                        break;
                    case R.id.menu03:
                        Fragment07 Fragment07 = new Fragment07();
                        final FragmentTransaction fragmentTransaction07 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction07.replace(R.id.fragment_contaliner, Fragment07);
                        fragmentTransaction07.commit();


                        break;
                }

                return true;
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.db:
                        HomeFragment homeFragment=new HomeFragment();
                        final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_contaliner,homeFragment);
                        fragmentTransaction.commit();


                        break;
                    case R.id.db1:
                        Fragment01 fragment01=new Fragment01();
                        FragmentTransaction fragmentTransaction01=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction01.replace(R.id.fragment_contaliner,fragment01);
                        fragmentTransaction01.commit();

                        break;
                    case R.id.db2:
                        Fragment02 fragment02=new Fragment02();
                        FragmentTransaction fragmentTransaction02=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction02.replace(R.id.fragment_contaliner,fragment02);
                        fragmentTransaction02.commit();

                        break;
                    case R.id.db3:
                        Fragment03 fragment03=new Fragment03();
                        FragmentTransaction fragmentTransaction03=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction03.replace(R.id.fragment_contaliner,fragment03);
                        fragmentTransaction03.commit();

                        break;
                    case R.id.db4:
                        Fragment04 fragment04=new Fragment04();
                        FragmentTransaction fragmentTransaction04=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction04.replace(R.id.fragment_contaliner,fragment04);
                        fragmentTransaction04.commit();

                        break;

                }

                mDrawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }


}
