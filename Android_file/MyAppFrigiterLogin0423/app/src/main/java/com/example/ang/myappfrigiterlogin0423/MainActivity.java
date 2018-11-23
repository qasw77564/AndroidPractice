package com.example.ang.myappfrigiterlogin0423;

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

import com.example.ang.myappfrigiterlogin0423.framegrent.Fragment01;
import com.example.ang.myappfrigiterlogin0423.framegrent.Fragment02;
import com.example.ang.myappfrigiterlogin0423.framegrent.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;
   // private BottomNavigationView b_nv;
//private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment homeFragment = new HomeFragment();
       // Fragment01 fragment01=new Fragment01();
        final FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_contener,homeFragment);
        fragmentTransaction.commit();
       // b_nv=findViewById(R.id.bo_nav);
        navigationView=findViewById(R.id.nv);
        mDrawerLayout= findViewById(R.id.dl);
        mToggle= new ActionBarDrawerToggle(this,mDrawerLayout,R.string.menu_open,R.string.menu_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.mlogin:
                        Fragment01 fragment01=new Fragment01();
                        FragmentTransaction fragmentTransaction01=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction01.replace(R.id.frame_contener,fragment01);
                        fragmentTransaction01.commit();

                        break;
                    case R.id.mresgister:
                        Fragment02 fragment02=new Fragment02();
                        FragmentTransaction fragmentTransaction02=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction02.replace(R.id.frame_contener,fragment02);
                        fragmentTransaction02.commit();

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
