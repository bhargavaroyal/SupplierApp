package com.mojro.supplier.supplierapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.mojro.supplier.supplierapp.Application.MojApplication;
import com.mojro.supplier.supplierapp.Model.SharedPreferencesManager;
import com.mojro.supplier.supplierapp.R;
import com.mojro.supplier.supplierapp.util.SharedConstants;


/**
 * Created by bhargavagugamsetty on 17/05/16.
 */
public class SplashActivity extends BaseActivity {
    public static final long mSplashTimeDelay = 2 * 1000;
    private Handler mHandler = null;
    private SplashRunnableThread mSplashRunnableThread = null;
    private static final String TAG = "SplashActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        initFields();
        MojApplication.getInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeRunnableHandlers();
        clearAllObjects();
    }

    private void removeRunnableHandlers() {
        if (mHandler != null) {
            mHandler.removeCallbacks(mSplashRunnableThread);
        }
    }

    private void clearAllObjects() {
        mHandler = null;
        mSplashRunnableThread = null;

    }

    private void initFields() {
        mHandler = new Handler();
        mSplashRunnableThread = new SplashRunnableThread();
        mHandler.postDelayed(mSplashRunnableThread, mSplashTimeDelay);

    }

    private class SplashRunnableThread implements Runnable{
        @Override
        public void run() {
            Boolean isFirstLaunch = SharedPreferencesManager.getBoolean(SplashActivity.this, SharedConstants.IS_FIRST_LAUNCH);
            if (!isFirstLaunch) {
                Intent intent = new Intent(SplashActivity.this, TutorialActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }
}

