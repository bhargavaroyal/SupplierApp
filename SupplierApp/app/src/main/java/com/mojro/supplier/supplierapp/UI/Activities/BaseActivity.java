package com.mojro.supplier.supplierapp.UI.Activities;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mojro.supplier.supplierapp.R;


/**
 * Created by bhargavagugamsetty on 20/05/16.
 */
public class BaseActivity extends AppCompatActivity {
    public Toolbar mToolbar;
    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void setActionbarTitle(String title, Boolean isParent, int id) {

        mToolbar = (Toolbar) findViewById(id);
        mToolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.White));
        setSupportActionBar(mToolbar);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
//        mActionBar.setHomeAsUpIndicator(R.drawable.ic_media_tab);

        if (title != null) {
            mActionBar.setTitle(title);
        }
    }
}
