package com.beefyazilim.app.canlibilgiyarismasi.data;


import com.beefyazilim.app.canlibilgiyarismasi.data.local.PreferencesHelper;

public interface DataManager extends PreferencesHelper {

    void setUserAsLoggedOut();


    void updateUserInfo(
            LoggedInMode loggedInMode,
            String userName,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOGGED_IN(1);


        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
