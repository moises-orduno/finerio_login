package com.moises.finerio.main.repositories;



import com.moises.finerio.main.api.MovementsService;
import com.moises.finerio.main.models.MovementsRequest;
import com.moises.finerio.main.models.MovementsResponse;

import rx.Observable;

/**
 * Created by mou on 15/01/17.
 */

public class MovementRepositoryImpl implements MovementRepository {

    private MovementsService mMovementsService;

    public MovementRepositoryImpl() {
        mMovementsService = MovementsService.getInstance();
    }


    @Override
    public Observable<MovementsResponse> movements(MovementsRequest movementsRequest) {
        return mMovementsService.movements(movementsRequest);
    }
}
