package com.moises.finerio.common.repositories;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;

import rx.Observable;

/**
 * Created by mou on 18/04/18.
 */
public interface SharedPreferencesRepository {

    void saveValue(String value, String key);

    void saveValue(int value, String key);

    String getStringValue(String key);

    int getIntValue(String key);
}
