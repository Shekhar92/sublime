package com.sumlimecorpdemo.assignment.demo;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by pratiksha on 9/17/2017.
 */

public class CustomerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        ButterKnife.bind(this);
    }
}
