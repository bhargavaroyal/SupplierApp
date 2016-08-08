package com.mojro.supplier.supplierapp.CustomUi;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by bhargavagugamsetty on 1/08/16.
 */
public class MaterialLoadingProgress {


    /**
     * The m context.
     */
    private Context mContext;

    /**
     * The m progress dialog.
     */
    private ProgressDialog mProgressDialog;

    /**
     * Instantiates a new custom dialog.
     *
     * @param inContext the in context
     */
    public MaterialLoadingProgress(Context inContext) {
        mContext = inContext;
    }

    /**
     * Show progress dialog.
     */
    public void ShowLoadingProgress(Boolean cancelable) {
        if(mContext!=null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage("Please wait....");
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(cancelable);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.show();
        }

    }

    /**
     * Cancel dialog.
     */
    public void CancelDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
