package com.moises.finerio.credentials.interactors;

import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;

import rx.Subscriber;

/**
 * Created by mou on 15/01/17.
 */

public interface UserInteractor {

    void logIn(Subscriber subscriber, LogInRequest logInRequest);

    void me(Subscriber subscriber, LogInResponse logInResponse);


}
