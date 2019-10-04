package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.fragments.MainFragment;

public class ActionFragment extends Fragment implements View.OnClickListener {

    Button loginAccount;

    public ActionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action, container, false);
        loginAccount = view.findViewById(R.id.loginAccount);
        loginAccount.setOnClickListener(this);

        return view;
    }

    private void loginAccount() {
        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.actionfragment, mainFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginAccount) {
            loginAccount();
        }
    }
}
