package com.hzlrknbdk.asosyal.fragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.User;


public class CreateAccountFragment extends Fragment implements View.OnClickListener {

    private EditText editTextName, editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    public CreateAccountFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_account, container, false);

        editTextName = view.findViewById(R.id.createAccount_name);
        editTextEmail = view.findViewById(R.id.createAccount_email);
        editTextPassword = view.findViewById(R.id.createAccount_password);
        progressBar = view.findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();


        view.findViewById(R.id.createAccount_btn).setOnClickListener(this);
        view.findViewById(R.id.TV_Signin).setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {

        }
    }

    private void registerUser() {
        final String name = editTextName.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


        if (name.isEmpty()) {
            editTextName.setError(getString(R.string.input_error_name));
            editTextName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError(getString(R.string.input_error_email));
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError(getString(R.string.input_error_email_invalid));
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError(getString(R.string.input_error_password));
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError(getString(R.string.input_error_password_length));
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            User user = new User(
                                    name,
                                    email,
                                    password
                            );
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(CreateAccountFragment.this.getContext(), getString(R.string.registration_success), Toast.LENGTH_SHORT).show();
                                        editTextName.setText("");
                                        editTextEmail.setText("");
                                        editTextPassword.setText("");
                                    } else {


                                    }
                                }
                            });
                        } else {
                            Toast.makeText(CreateAccountFragment.this.getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    private void redirectToLogin() {
        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, mainFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.createAccount_btn) {
            registerUser();

        }
        if (v.getId() == R.id.TV_Signin) {
            redirectToLogin();
        }
    }
}