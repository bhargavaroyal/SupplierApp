package com.mojro.supplier.supplierapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.mojro.supplier.supplierapp.R;





public class HomeActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button mLogin;
    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        setActionbarTitle(getString(R.string.home), true, R.id.home_tb);
        init();

    }

    private void init() {
        mLogin = (Button)findViewById(R.id.hom_login_bt);
        mRegister = (Button)findViewById(R.id.hom_register_bt);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hom_login_bt:
                Intent priceIntent = new Intent(this, LoginActivity.class);
                startActivity(priceIntent);
                break;
            case R.id.hom_register_bt:
                Intent contactIntent = new Intent(this, RegisterActivity.class);
                startActivity(contactIntent);
                break;


        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
