package com.moises.finerio.credentials.api;

import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;
import com.google.gson.Gson;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;



/**
 * Created by mou on 15/01/17.
 */

public class UserService {

    private static volatile UserService mUserService;
    private final UserApi mUserApi;
    private static final String URL="https://api.finerio.mx/api/";
    public static final String BEARER_HEADER="Bearer ";
    private UserService() {

        mUserApi = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserApi.class);
    }

    public static UserService getInstance() {
        if(mUserService == null) {
            synchronized (UserService.class) {
                if(mUserService == null) {
                    mUserService = new UserService();
                }
            }
        }
        return mUserService;
    }

    public Observable<LogInResponse> logInUser(LogInRequest logInRequest) {
        return mUserApi.logInUser(logInRequest,new Gson().toJson(logInRequest).length());
    }

    public Observable<MeResponse> meUser(LogInResponse logInResponse) {
        return mUserApi.meUser(BEARER_HEADER+logInResponse.getAccessToken());
    }

}
