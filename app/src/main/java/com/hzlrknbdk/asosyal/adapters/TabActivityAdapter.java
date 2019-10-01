package com.hzlrknbdk.asosyal.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hzlrknbdk.asosyal.fragments.ActivityTabOneFragment;
import com.hzlrknbdk.asosyal.fragments.ActivityTabTwoFragment;

public class TabActivityAdapter extends FragmentStatePagerAdapter {

    int behavior;

    public TabActivityAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.behavior = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ActivityTabOneFragment tabOne = new ActivityTabOneFragment();
                return tabOne;
            case 1:
                ActivityTabTwoFragment tabTwo = new ActivityTabTwoFragment();
                return tabTwo;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return behavior;
    }
}
