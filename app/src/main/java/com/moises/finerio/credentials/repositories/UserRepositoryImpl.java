package com.moises.finerio.credentials.repositories;



import com.moises.finerio.credentials.api.UserService;
import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;

import rx.Observable;

/**
 * Created by mou on 15/01/17.
 */

public class UserRepositoryImpl implements UserRepository{

    private UserService mUserService;

    public UserRepositoryImpl() {
        this.mUserService = UserService.getInstance();
    }

    @Override
    public Observable<LogInResponse> logInUser(LogInRequest logInRequest) {
        return mUserService.logInUser(logInRequest);

    }

    @Override
    public Observable<MeResponse> meUser(LogInResponse logInResponse) {
        return mUserService.meUser(logInResponse);
    }


}
