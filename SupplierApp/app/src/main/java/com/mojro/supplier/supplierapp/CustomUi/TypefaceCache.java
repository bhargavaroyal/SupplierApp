package com.mojro.supplier.supplierapp.CustomUi;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bhargavagugamsetty on 1/08/16.
 */
public class TypefaceCache {

    private static final ConcurrentHashMap<String, Typeface> CACHE = new ConcurrentHashMap<String, Typeface>();

    public static Typeface get(final AssetManager manager, final String name) {

        synchronized (CACHE) {

            if (!CACHE.containsKey(name)) {
                final Typeface t = Typeface.createFromAsset(manager, name);
                CACHE.put(name, t);
            }
            return CACHE.get(name);
        }
    }
}
