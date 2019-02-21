package com.beefyazilim.app.canlibilgiyarismasi.data.local;


import com.beefyazilim.app.canlibilgiyarismasi.data.DataManager;

public interface PreferencesHelper {


    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);
}
