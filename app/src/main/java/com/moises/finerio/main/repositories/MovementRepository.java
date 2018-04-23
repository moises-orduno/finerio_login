package com.moises.finerio.main.repositories;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;
import com.moises.finerio.main.models.MovementsRequest;
import com.moises.finerio.main.models.MovementsResponse;

import rx.Observable;

/**
 * Created by mou on 15/01/17.
 */
public interface MovementRepository {

    Observable<MovementsResponse> movements(MovementsRequest movementsRequest);

}
