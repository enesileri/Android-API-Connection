package com.beefyazilim.app.canlibilgiyarismasi;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class FragmentUtils {


    @SuppressLint("ResourceType")
    public static FragmentTransaction getTransaction(FragmentManager manager, Page page, boolean addBackStack) {
        FragmentTransaction fTransaction = manager.beginTransaction();
        String TAG = page.name();

        switch (page) {
            case REGISTER:
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case ABOUT:
              //  fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case LOGIN:
                // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case ASK:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case HINT:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case LEADER:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case PROFILE:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case WAIT:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
              //  fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case FALSE:
                //fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;
            case TRUE:
               // fTransaction.setCustomAnimations(R.anim.anim_in_from_bottom, R.anim.anim_out_from_bottom);
                fTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;

        }

        if (addBackStack)
            fTransaction.addToBackStack(TAG);

        return fTransaction;
    }

}
