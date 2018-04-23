package com.moises.finerio.main.interactors;

import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.main.models.MovementsRequest;

import rx.Subscriber;

/**
 * Created by mou on 15/01/17.
 */

public interface MovementInteractor {

    void movement(Subscriber subscriber, MovementsRequest movementsRequest);


}
