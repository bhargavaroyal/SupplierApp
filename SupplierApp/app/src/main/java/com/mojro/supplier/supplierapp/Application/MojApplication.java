package com.mojro.supplier.supplierapp.Application;

import android.app.Application;
import android.content.Context;




/**
 * Created by bhargavagugamsetty on 19/05/16.
 */
public class MojApplication extends Application {
    private static MojApplication sMojApplication = null;
//    private RequestQueue              mRequestqueue;
    public static final String        TAG = "Mojroaplication";
//    private ImageLoader mImageLoader = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sMojApplication = this;
        initFields();
    }

    private void initFields() {

        initVolley();
    }

    private void initVolley() {

//        RequestManager.init(this);

//        mImageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
//
//            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
//
//            public void putBitmap(String url, Bitmap bitmap) {
//                mCache.put(url, bitmap);
//            }
//
//            public Bitmap getBitmap(String url) {
//                return mCache.get(url);
//            }
//        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
    public static MojApplication getInstance() {

        if (sMojApplication == null)
            sMojApplication = new MojApplication();

        return sMojApplication;
    }


//    public static RequestQueue getRequestQueue() {
//        return RequestManager.getRequestQueue();
//    }


}
