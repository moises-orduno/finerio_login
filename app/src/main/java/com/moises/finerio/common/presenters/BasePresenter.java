package com.moises.finerio.common.presenters;

/**
 * Created by mou on 17/02/18.
 */

public interface BasePresenter {

    void showProgress();

    void hideProgress();

    void saveSharedPreferenceValue(String value, String key);

    void saveSharedPreferenceValue(int value, String key);

    String getStringSharedPreferenceValue(String key);

    int getIntSharedPreferenceValue(String key);

    void showOneButtonDialog(String text);

}
