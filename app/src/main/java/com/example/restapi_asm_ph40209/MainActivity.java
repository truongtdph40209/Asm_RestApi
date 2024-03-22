package com.example.restapi_asm_ph40209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.restapi_asm_ph40209.adapter.ViewPager2Adapter;
import com.example.restapi_asm_ph40209.fragment.cart_frg;
import com.example.restapi_asm_ph40209.fragment.detail_frg;
import com.example.restapi_asm_ph40209.fragment.favourite_frg;
import com.example.restapi_asm_ph40209.fragment.home_frg;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.view_pager2);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        fragmentArrayList.add(new home_frg());
        fragmentArrayList.add(new cart_frg());
        fragmentArrayList.add(new detail_frg());
        fragmentArrayList.add(new favourite_frg());


        ViewPager2Adapter adapter = new ViewPager2Adapter(this, fragmentArrayList);
        viewPager2.setAdapter(adapter);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: {
                        bottomNavigationView.setSelectedItemId(R.id.menu_home);
                        break;
                    }
                    case 1: {
                        bottomNavigationView.setSelectedItemId(R.id.menu_cart);
                        break;
                    }
                    case 2: {
                        bottomNavigationView.setSelectedItemId(R.id.menu_detail);
                        break;
                    }
                    case 3: {
                        bottomNavigationView.setSelectedItemId(R.id.menu_favourite);
                        break;
                    }
                }

                super.onPageSelected(position);
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if (item.getItemId() == R.id.menu_home) {
                        viewPager2.setCurrentItem(0);
                        return true;
                    } else if (item.getItemId() == R.id.menu_cart) {
                        viewPager2.setCurrentItem(1);

                        return true;
                    } else if (item.getItemId() == R.id.menu_detail) {
                        viewPager2.setCurrentItem(2);

                        return true;
                    } else if (item.getItemId() == R.id.menu_favourite) {
                        viewPager2.setCurrentItem(3);

                        return true;
                    }
                    return false;

            }
        });







    }
}