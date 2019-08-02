package com.hzlrknbdk.asosyal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hzlrknbdk.asosyal.R;


public class MainFragment extends Fragment implements View.OnClickListener {

    public MainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.btn_social).setOnClickListener(this);
        view.findViewById(R.id.btn_parents).setOnClickListener(this);
        view.findViewById(R.id.btn_teacher).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_social:
                SocialFragment socialFragment = new SocialFragment();
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, socialFragment);
                //   fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            case R.id.btn_parents:
                ParentsFragment parentsFragment = new ParentsFragment();
                FragmentManager fragmentManager1 = getFragmentManager();
                assert fragmentManager1 != null;
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.container, parentsFragment);
                //    fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

            case R.id.btn_teacher:
                TeacherFragment teacherFragment = new TeacherFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                assert fragmentManager2 != null;
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.container, teacherFragment);
                //   fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
        }

    }
}