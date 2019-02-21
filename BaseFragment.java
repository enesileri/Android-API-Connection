package com.beefyazilim.app.canlibilgiyarismasi;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {


    ProgressDialog mProgressDialog;
    private BaseActivity mActivity;

    public void showPage(Page page, Bundle dataTransferObject, boolean transactionType, boolean addBackStack) {
        getBaseActivity().showPage(transactionType, addBackStack, dataTransferObject, page);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            //activity.onAttachFragment(context);
        }
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void showDialog() {
        mProgressDialog = Util.showLoadingDialog(getBaseActivity());
    }

    public void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


}
