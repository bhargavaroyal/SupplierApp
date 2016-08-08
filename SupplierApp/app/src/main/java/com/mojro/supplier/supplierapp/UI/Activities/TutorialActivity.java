package com.mojro.supplier.supplierapp.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mojro.supplier.supplierapp.Model.SharedPreferencesManager;
import com.mojro.supplier.supplierapp.R;
import com.mojro.supplier.supplierapp.UI.Fragments.TutorialFragment;
import com.mojro.supplier.supplierapp.util.SharedConstants;


/**
 * Created by bhargavagugamsetty on 1/08/16.
 */
public class TutorialActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int[] INDICATOR = new int[]{R.id.pager_indicator_one, R.id.pager_indicator_two, R.id.pager_indicator_three, R.id.pager_indicator_four};

    private LinearLayout mIndicatorLinearLayout = null;
    public PagerAdapter mPagerAdapter = null;
    public ViewPager mViewPager = null;

    private TextView mNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initFields();

    }

    private void initFields() {
        mIndicatorLinearLayout = (LinearLayout) findViewById(R.id.pager_layout_ll);

        mNext = (TextView) findViewById(R.id.tutorial_get_started_tv);
        mNext.setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOffscreenPageLimit(1);
        findViewById(INDICATOR[0]).setSelected(true);


        mPagerAdapter = new TutorialPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 3) {
                    mNext.setText(getString(R.string.get_started));
                } else {
                    mNext.setText(getString(R.string.skip));
                }
                resetSelector();
                findViewById(INDICATOR[position]).setSelected(true);
            }
        });
    }
    private void resetSelector() {
        for (int i = 0; i < INDICATOR.length; i++) {
            findViewById(INDICATOR[i]).setSelected(false);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.tutorial_get_started_tv:
                SharedPreferencesManager.set(TutorialActivity.this, SharedConstants.IS_FIRST_LAUNCH, true);
                Intent tutorialIntent = new Intent (TutorialActivity.this, HomeActivity.class);
                startActivity(tutorialIntent);

        }

    }

    private class TutorialPagerAdapter extends FragmentStatePagerAdapter {

        public TutorialPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return getTutorialFragment(0, getString(R.string.screen_one_title), getString(R.string.screen_one_subtitle));

                case 1:
                    return getTutorialFragment(1, getString(R.string.screen_two_title), getString(R.string.screen_two_subtitle));

                case 2:
                    return getTutorialFragment(2, getString(R.string.screen_three_title), getString(R.string.screen_three_subtitle));

                case 3:
                    return getTutorialFragment(3, getString(R.string.screen_four_title), getString(R.string.screen_four_subtitle));

                default:
                    return null;
            }
        }



        @Override
        public int getCount() {
            return SharedConstants.NUM_PAGES;
        }


//         * Method returns tutorial fragment objects with title and subtitle

        public Fragment getTutorialFragment(int position, String title, String subTitle) {
            TutorialFragment fragment = new TutorialFragment();
            Bundle args = new Bundle();
            args.putString(SharedConstants.ARG_TITLE, title);
            args.putString(SharedConstants.ARG_SUBTITLE, subTitle);
            args.putInt(SharedConstants.ARG_POSITION, position);
            fragment.setArguments(args);
            return fragment;
        }
    }

}
