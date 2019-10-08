package com.hzlrknbdk.asosyal.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.fragments.actionfragment.AccountActiveFragment;
import com.hzlrknbdk.asosyal.fragments.actionfragment.ActionFragment;

import java.util.concurrent.Executor;


public class MainFragment extends Fragment implements View.OnClickListener {
    private static final int RC_SIGN_IN = 123;
    private GoogleSignInClient mGoogleSignInClient;
    private EditText login_email, login_password;
    private FirebaseAuth auth;
    SignInButton mGoogleLoginBtn;

    private static final String TAG = "Main Fragment";

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
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this.getContext(), gso);
        login_email = view.findViewById(R.id.login_email);
        login_password = view.findViewById(R.id.login_password);
        view.findViewById(R.id.btn_login).setOnClickListener(this);
        view.findViewById(R.id.tv_Create_Account).setOnClickListener(this);
        view.findViewById(R.id.notUser).setOnClickListener(this);
        view.findViewById(R.id.googleLogin).setOnClickListener(this);

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
        if (v.getId() == R.id.googleLogin) {
            signIn();
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
                            AccountActiveFragment accountActiveFragment = new AccountActiveFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            assert fragmentManager != null;
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.actionfragment, accountActiveFragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                        } else {
                            Toast.makeText(MainFragment.this.getContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();

                        }


                    });
        }

    }

    private void createAccount() {
        CreateAccountFragment createAccountFragment = new CreateAccountFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.actionfragment, createAccountFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    private void transitionToActionPage() {
        ActionFragment actionFragment = new ActionFragment();
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.actionfragment, actionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                if (account != null) firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.e(TAG, "Google sign in failed", e);
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithCredential:success");

                        FirebaseUser user = auth.getCurrentUser();

                        AccountActiveFragment accountActiveFragment = new AccountActiveFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        assert fragmentManager != null;
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.actionfragment, accountActiveFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();


                    } else {
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Toast.makeText(getContext().getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();


                    }

                }).addOnFailureListener(e ->
                Toast.makeText(getContext().getApplicationContext(), "Hata burada", Toast.LENGTH_LONG).show());
    }


}
