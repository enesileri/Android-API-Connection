package com.beefyazilim.app.canlibilgiyarismasi.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.beefyazilim.app.canlibilgiyarismasi.data.DataManager;


public class AppPreferencesHelper implements PreferencesHelper {




    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    private final SharedPreferences mPrefs;


    public AppPreferencesHelper(Context context, String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

}
