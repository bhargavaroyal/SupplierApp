package com.mojro.supplier.supplierapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mojro.supplier.supplierapp.R;

/**
 * Created by Lenovo on 8/1/2016.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = "LoginActivity";

    Button mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    private void init() {
    mLogin = (Button) findViewById(R.id.login_bt);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_bt:
                Intent intent = new Intent(LoginActivity.this, LocationActivity.class);
                startActivity(intent);


        }
    }
}
