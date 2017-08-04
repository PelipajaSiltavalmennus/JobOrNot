package com.pelipaja.jobornot;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public JobsFragment jobsFragment = new JobsFragment();
    public SubmitFragment submitFragment = new SubmitFragment();
    public OptionsFragment optionsFragment = new OptionsFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_jobs:
                    setView(jobsFragment);
                    return true;
                case R.id.navigation_submit:
                    setView(submitFragment);
                    return true;
                case R.id.navigation_options:
                    setView(optionsFragment);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setView(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }
}
