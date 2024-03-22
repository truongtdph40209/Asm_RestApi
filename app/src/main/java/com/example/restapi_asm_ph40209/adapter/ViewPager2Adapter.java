package com.example.restapi_asm_ph40209.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPager2Adapter extends FragmentStateAdapter {
    ArrayList<Fragment> arr;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity,ArrayList<Fragment> arr ) {
        super(fragmentActivity);
        this.arr = arr;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arr.get(position);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
