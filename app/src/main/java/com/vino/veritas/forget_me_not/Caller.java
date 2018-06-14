package com.example.vishnusmurali.caller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.vishnusmurali.caller.adapters.ViewPagerAdapter;
import com.example.vishnusmurali.caller.fragments.FragmentCalls;
import com.example.vishnusmurali.caller.fragments.FragmentContacts;
import com.example.vishnusmurali.caller.fragments.FragmentFav;

public class Caller extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private final int ICONS[] = {R.drawable.ic_call, R.drawable.ic_contacts, R.drawable.ic_star};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCalls(), "Calls");
        adapter.addFragment(new FragmentContacts(), "Contacts");
        adapter.addFragment(new FragmentFav(), "Fav");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setIcon(ICONS[i]);
        }
    }

    private void askPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, 1);
        }
    }
}

