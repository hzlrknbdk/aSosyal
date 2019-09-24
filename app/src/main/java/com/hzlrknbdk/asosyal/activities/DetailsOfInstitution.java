package com.hzlrknbdk.asosyal.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.TabInstitutionsAdapter;

public class DetailsOfInstitution extends AppCompatActivity {
    private TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_institution);

        toolbar = findViewById(R.id.toolbar_institutions);
        TextView textView = toolbar.findViewById(R.id.toolbarTextView);
        textView.setText("Kurum & Kuruluşlar");

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Yapılan Projeler"));
        tabLayout.addTab(tabLayout.newTab().setText("Yapılacak Projeler"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager_tab);
        TabInstitutionsAdapter tabInstitutionsAdapter = new TabInstitutionsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabInstitutionsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
