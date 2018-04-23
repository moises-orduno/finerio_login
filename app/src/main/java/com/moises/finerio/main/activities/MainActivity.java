package com.moises.finerio.main.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.moises.finerio.R;
import com.moises.finerio.main.fragments.MovementsFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        MovementsFragment movementsFragment = new MovementsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragments_container, movementsFragment,MovementsFragment.TAG).commit();
    }

}
