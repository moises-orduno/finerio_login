package com.moises.finerio.credentials.interactors;

import android.content.Context;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.repositories.UserRepository;
import com.moises.finerio.credentials.repositories.UserRepositoryImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mou on 15/01/17.
 */

public class UserInteractorImpl implements UserInteractor {


    private UserRepository mUserRepository;

    public UserInteractorImpl(Context context) {
        this.mUserRepository = new UserRepositoryImpl();
    }

    public UserInteractorImpl() {
        this.mUserRepository = new UserRepositoryImpl();
    }

    @Override
    public void logIn(Subscriber subscriber, LogInRequest logInRequest) {

        mUserRepository.logInUser(logInRequest)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    @Override
    public void me(Subscriber subscriber, LogInResponse logInResponse) {

        mUserRepository.meUser(logInResponse)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
