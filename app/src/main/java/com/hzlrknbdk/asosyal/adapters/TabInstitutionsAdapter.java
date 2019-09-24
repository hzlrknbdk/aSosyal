package com.hzlrknbdk.asosyal.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.hzlrknbdk.asosyal.fragments.InstitutionsTabOne;
import com.hzlrknbdk.asosyal.fragments.InstitutionsTabTwo;

public class TabInstitutionsAdapter extends FragmentStatePagerAdapter {

    int counttab;

    public TabInstitutionsAdapter(FragmentManager fm, int counttab) {
        super(fm, counttab);
        this.counttab = counttab;
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                InstitutionsTabOne tabOne = new InstitutionsTabOne();
                return tabOne;
            case 1:
                InstitutionsTabTwo tabTwo = new InstitutionsTabTwo();
                return tabTwo;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return counttab;
    }
}
