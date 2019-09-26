package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.fragments.navigationbarfragment.HomePageFragment;
import com.hzlrknbdk.asosyal.fragments.navigationbarfragment.LikeFragment;
import com.hzlrknbdk.asosyal.fragments.navigationbarfragment.NotificationsFragment;
import com.hzlrknbdk.asosyal.fragments.navigationbarfragment.ProfileFragment;
import com.hzlrknbdk.asosyal.fragments.navigationbarfragment.SearchFragment;

public class AccountActiveFragment extends Fragment {

    public AccountActiveFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account_active, container, false);
        BottomNavigationView bottomNav = view.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomePageFragment()).commit();
        }

        return view;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomePageFragment();
                    break;
                case R.id.nav_notifications:
                    selectedFragment = new NotificationsFragment();
                    break;
                case R.id.nav_like:
                    selectedFragment = new LikeFragment();
                    break;
                case R.id.nav_person:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
            }
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }

    };
}
