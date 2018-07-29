package com.example.ivstk.sannacodetesttask.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class SimplePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public SimplePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public Iterable<? extends Fragment> getItems() {
        return fragments;
    }
}