package com.example.newsapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Started" ;
   // public final String api = "3b7a2e1749c041faad5d261804acbe28";

ViewPager pager;
Toolbar toolbar;
TabLayout tabLayout;
ViewPagerAdapter adapter;
NavigationView navigationView;
DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ResponseM> newsList = new ArrayList<>();

        initviews();

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();





    }

    private void initviews() {
        tabLayout = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);
        toolbar = findViewById(R.id.tool);
        navigationView = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.drawer);

    }
}
