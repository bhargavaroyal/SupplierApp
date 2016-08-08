package com.mojro.supplier.supplierapp.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mojro.supplier.supplierapp.R;
import com.mojro.supplier.supplierapp.util.SharedConstants;


/**
 * Created by bhargavagugamsetty on 19/05/16.
 */
public class TutorialFragment extends Fragment {
    private ImageView mIcon = null;
    private TextView mTitle = null;
    private TextView mSubTitle = null;

    private String title;
    private String subTitle;
    private int position;
    private static final String TAG = "TutorialF.class";

    private View mRootView = null;

    private static final int[] SCREEN_ICONS = {R.drawable.ic_schedule, R.drawable.ic_calendar, R.drawable.ic_w_addcalendar, R.drawable.ic_media};

    private static final int[] SCREEN_TAB_ICONS = {R.drawable.ic_schedule_tab, R.drawable.ic_calendar_tab, R.drawable.ic_w_addcalendar_tab, R.drawable.ic_media_tab};

//Constructor with zero arguments so that user can't instantiate this fragment as an Object
    public TutorialFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(SharedConstants.ARG_POSITION);
        title = getArguments().getString(SharedConstants.ARG_TITLE);
        subTitle = getArguments().getString(SharedConstants.ARG_SUBTITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_tutorial, container, false);

        initFields(mRootView);

        return mRootView;
    }


    private void initFields(View rootView) {

        mIcon = (ImageView) rootView.findViewById(R.id.tutorial_center_iv);

        mTitle = (TextView) rootView.findViewById(R.id.tutorial_title_tv);
        mSubTitle = (TextView) rootView.findViewById(R.id.tutorial_subtitle_tv);

        // set the title and subtitle to the text
        mTitle.setText(title);
        mSubTitle.setText(subTitle);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mIcon = null;
        mTitle = null;
        mSubTitle = null;
        mRootView = null;
    }
}
