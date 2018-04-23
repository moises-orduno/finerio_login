package com.moises.finerio.main.interactors;

import android.content.Context;

import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.repositories.UserRepository;
import com.moises.finerio.credentials.repositories.UserRepositoryImpl;
import com.moises.finerio.main.models.MovementsRequest;
import com.moises.finerio.main.repositories.MovementRepository;
import com.moises.finerio.main.repositories.MovementRepositoryImpl;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mou on 15/01/17.
 */

public class MovementInteractorImpl implements MovementInteractor {


    private MovementRepository mMovementRepository;


    public MovementInteractorImpl() {
        mMovementRepository = new MovementRepositoryImpl();
    }


    @Override
    public void movement(Subscriber subscriber, MovementsRequest movementsRequest) {
        mMovementRepository.movements(movementsRequest)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
