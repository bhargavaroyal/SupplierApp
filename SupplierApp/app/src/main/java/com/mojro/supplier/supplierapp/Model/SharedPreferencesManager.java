package com.mojro.supplier.supplierapp.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bhargavagugamsetty on 17/05/16.
 */
public class SharedPreferencesManager {

    public static boolean getBoolean(final Context c, final String key) {

        final SharedPreferences preferences = c.getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    public static void set(final Context c, final String key, final boolean value) {
        final SharedPreferences preferences = c.getSharedPreferences(key, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static String getString(final Context context, final String key) {
        final SharedPreferences preferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return preferences.getString(key, null);

    }


}
