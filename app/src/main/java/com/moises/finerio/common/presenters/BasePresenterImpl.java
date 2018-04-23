package com.moises.finerio.common.presenters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;

import com.moises.finerio.common.repositories.SharedPreferencesRepository;
import com.moises.finerio.common.repositories.SharedPreferencesRepositoryImpl;

/**
 * Created by mou on 17/02/18.
 */

public class BasePresenterImpl implements BasePresenter {

    private final Context mContext;
    private final ProgressBar mProgressBar;
    private final SharedPreferencesRepository mSharedPreferencesRepository;

    public BasePresenterImpl(Context context, ProgressBar progressBar) {
        mContext = context;
        mProgressBar = progressBar;
        mSharedPreferencesRepository = new SharedPreferencesRepositoryImpl(mContext);

    }

    @Override
    public void showProgress() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        if (mProgressBar != null) mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void saveSharedPreferenceValue(String value, String key) {
        mSharedPreferencesRepository.saveValue(value, key);
    }

    @Override
    public void saveSharedPreferenceValue(int value, String key) {
        mSharedPreferencesRepository.saveValue(value, key);
    }

    @Override
    public String getStringSharedPreferenceValue(String key) {
        return mSharedPreferencesRepository.getStringValue(key);
    }

    @Override
    public int getIntSharedPreferenceValue(String key) {
        return mSharedPreferencesRepository.getIntValue(key);
    }

    @Override
    public void showOneButtonDialog(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(text)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
