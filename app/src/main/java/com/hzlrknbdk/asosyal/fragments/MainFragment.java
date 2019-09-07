package com.hzlrknbdk.asosyal.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.fragments.actionfragment.ActionFragment;


public class MainFragment extends Fragment implements View.OnClickListener {

    private EditText login_email, login_password;
    private FirebaseAuth auth;

    public MainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        auth = FirebaseAuth.getInstance();
        login_email = view.findViewById(R.id.login_email);
        login_password = view.findViewById(R.id.login_password);

        view.findViewById(R.id.btn_login).setOnClickListener(this);
        view.findViewById(R.id.tv_Create_Account).setOnClickListener(this);
        view.findViewById(R.id.notUser).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            loginAccount();
        }
        if (v.getId() == R.id.tv_Create_Account) {
            createAccount();
        }
        if (v.getId() == R.id.notUser) {
            transitionToActionPage();
        }
    }

    private void loginAccount() {
        String txt_email = login_email.getText().toString();
        String txt_password = login_password.getText().toString();
        if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
            Toast.makeText(MainFragment.this.getContext(), "All field are required", Toast.LENGTH_SHORT).show();

        } else {
            auth.signInWithEmailAndPassword(txt_email, txt_password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            ParentsHomePageFragment parentsHomePageFragment = new ParentsHomePageFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            assert fragmentManager != null;
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container, parentsHomePageFragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        } else {
                            Toast.makeText(MainFragment.this.getContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();

                        }


                    });
        }

    }

    private void createAccount() {
        ActionFragment createAccountFragment = new ActionFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, createAccountFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    private void transitionToActionPage() {
        ActionFragment actionFragment = new ActionFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, actionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
