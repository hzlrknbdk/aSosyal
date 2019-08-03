package com.hzlrknbdk.asosyal.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.hzlrknbdk.asosyal.R;

public class ParentsFragment extends Fragment {

    EditText login_email, login_password;
    FirebaseAuth auth;


    public ParentsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parents, container, false);


        auth = FirebaseAuth.getInstance();
        login_email = view.findViewById(R.id.login_email);
        login_password = view.findViewById(R.id.login_password);

        view.findViewById(R.id.btn_parents_login).setOnClickListener(v -> {
            String txt_email = login_email.getText().toString();
            String txt_password = login_password.getText().toString();
            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(ParentsFragment.this.getContext(), "All field are required", Toast.LENGTH_SHORT).show();

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
                                Toast.makeText(ParentsFragment.this.getContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();

                            }


                        });
            }
        });
        return view;


    }


}
