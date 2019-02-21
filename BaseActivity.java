package com.beefyazilim.app.canlibilgiyarismasi;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.beefyazilim.app.canlibilgiyarismasi.data.api.ApiCall;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.AboutFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.AskQuestionFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.HintFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.JokerFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.LeaderboardFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.MainActivity;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.ProfileFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.home.WaitFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.init.AvatarFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.init.LoginFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.init.RegisterFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.result.FalseFragment;
import com.beefyazilim.app.canlibilgiyarismasi.ui.result.TrueFragment;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseActivity extends AppCompatActivity {


    ProgressDialog mProgressDialog;
    ProgressDialog mProgressDialoglock;

    //  GsonConverterFactory gsonConverterFactory;

    Page page1;

    OkHttpClient.Builder httpClient;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        httpClient= new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json").addHeader("token","1f7fe230-c6a2-4a93-80a0-28b3ef2d3c0").build();
                return chain.proceed(request);
            }
        });

    }

    public void showPage(boolean transactionType, boolean addBackStack, Bundle bundle, Page page) {
        showPage(FragmentUtils.getTransaction(getSupportFragmentManager(), page, addBackStack), page, transactionType, bundle);
        page1 = page;
    }

    private void showPage(FragmentTransaction transaction, Page page, boolean transactionType, Bundle bundle) {

        BaseFragment baseFragment = null;
        String TAG = "";
        switch (page) {
            case REGISTER:
                baseFragment = new RegisterFragment();
                break;
            case LOGIN:
                baseFragment = new LoginFragment();
                break;
            case ABOUT:
                baseFragment = new AboutFragment();
                break;
            case ASK:
                baseFragment = new AskQuestionFragment();
                break;
            case HINT:
                baseFragment = new HintFragment();
                break;
            case LEADER:
                baseFragment = new LeaderboardFragment();
                break;
            case PROFILE:
                baseFragment = new ProfileFragment();
                break;
            case WAIT:
                baseFragment = new WaitFragment();
                break;
            case FALSE:
                baseFragment = new FalseFragment();
                break;
            case TRUE:
                baseFragment = new TrueFragment();
                break;
            case AVATAR:
                baseFragment = new AvatarFragment();
                break;
            case JOKER:
                baseFragment = new JokerFragment();
                break;

        }

        if (baseFragment == null)
            return;

        TAG = baseFragment.getClass().getSimpleName();

        baseFragment.setArguments(bundle);

        if (transactionType) {
            transaction.replace(R.id.main_container, baseFragment, TAG);
        } else {
            transaction.add(R.id.main_container, baseFragment, TAG);
        }
        transaction.commit();

    }

    public void showDialog() {
        mProgressDialog = Util.showLoadingDialog(this);
    }

    public void showDialoglock() {
        mProgressDialoglock = Util.showLoadingDialogLock(this);
    }

    public void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private static final String BASE_URL = "http://fatihmandirali.com";

    public ApiCall provideApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit.create(ApiCall.class);
    }

    public void startAvtivityData(Bundle data, Class t) {
        Intent intent = new Intent(getApplicationContext(), t);
        intent.putExtras(data);
        startActivity(intent);
    }



}
