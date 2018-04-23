package com.moises.finerio.common.repositories;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.moises.finerio.R;
import com.moises.finerio.credentials.api.UserService;
import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;

import rx.Observable;

/**
 * Created by mou on 18/04/18.
 */

public class SharedPreferencesRepositoryImpl implements SharedPreferencesRepository {

    private Context mContext;
    private static final String TAG = SharedPreferencesRepositoryImpl.class.getSimpleName();
    private static final String SHARED_PREFERENCES_NAME = "Finerio";

    public SharedPreferencesRepositoryImpl(Context context) {
        this.mContext = context;
    }


    @Override
    public void saveValue(String value, String key) {

        SharedPreferences.Editor editor = mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        boolean isSaved = editor.commit();
        Log.d(TAG, "saveValue: "+isSaved);
    }

    @Override
    public void saveValue(int value, String key) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        boolean isSaved = editor.commit();
        Log.d(TAG, "saveValue: "+isSaved);
    }

    @Override
    public String getStringValue(String key) {

        SharedPreferences sharedPref =  mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);

        String sharedPreferenceValue = sharedPref.getString(key, null);
        Log.d(TAG, "getStringValue: " + sharedPreferenceValue);
        return sharedPreferenceValue;
    }

    @Override
    public int getIntValue(String key) {
        SharedPreferences sharedPref =  mContext.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE);
        int sharedPreferenceValue=sharedPref.getInt(key, 0);
        Log.d(TAG, "getIntValue: " + sharedPreferenceValue);
        return sharedPreferenceValue;
    }
}
