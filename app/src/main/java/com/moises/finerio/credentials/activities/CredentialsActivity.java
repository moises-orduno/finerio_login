package com.moises.finerio.credentials.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moises.finerio.R;
import com.moises.finerio.credentials.fragments.LogInFragment;

public class CredentialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
        init();



    }

    private void init() {

        LogInFragment logInFragment = LogInFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, logInFragment,LogInFragment.TAG).commit();
    }
}
