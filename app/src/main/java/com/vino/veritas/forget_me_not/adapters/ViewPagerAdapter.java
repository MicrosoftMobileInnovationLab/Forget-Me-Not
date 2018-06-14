package com.example.vishnusmurali.caller.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;

import com.example.vishnusmurali.caller.fragments.FragmentContacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishnu S Murali on 13-06-2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment=new ArrayList<>();
    private List<String> lisTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);

    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lisTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        listFragment.add(fragment);
        lisTitles.add(title);

    }
}
