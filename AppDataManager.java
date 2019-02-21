

package com.beefyazilim.app.canlibilgiyarismasi.data;

import android.content.Context;

import com.beefyazilim.app.canlibilgiyarismasi.data.local.PreferencesHelper;
import com.google.gson.Gson;


public abstract class AppDataManager implements DataManager {


    private final PreferencesHelper mPreferencesHelper;

    private final Context mContext;
    private final Gson mGson;

    public AppDataManager(Context context, PreferencesHelper preferencesHelper, Gson gson) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mGson = gson;
    }



    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {

    }


    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }


    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public void updateUserInfo(
            LoggedInMode loggedInMode,
            String userName,
            String profilePicPath) {


        setCurrentUserLoggedInMode(loggedInMode);
        setCurrentUserName(userName);

    }


}
