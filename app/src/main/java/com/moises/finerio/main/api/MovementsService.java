package com.moises.finerio.main.api;

import com.moises.finerio.main.models.MovementsRequest;
import com.moises.finerio.main.models.MovementsResponse;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import static com.moises.finerio.credentials.api.UserService.BEARER_HEADER;


/**
 * Created by mou on 18/04/18.
 */

public class MovementsService {

    private static volatile MovementsService mMovementsService;
    private final MovementsApi mMovementsApi;
    private static final String URL="https://api.finerio.mx/api/";
    private static final boolean DEEP=true;
    private static final boolean INCLUDE_CHARGES=true;
    private static final boolean INCLUDE_DEPOSITS=true;
    private static final int MAX=10;

    private MovementsService() {

        mMovementsApi = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovementsApi.class);
    }

    public static MovementsService getInstance() {
        if(mMovementsService == null) {
            synchronized (MovementsService.class) {
                if(mMovementsService == null) {
                    mMovementsService = new MovementsService();
                }
            }
        }
        return mMovementsService;
    }

    public Observable<MovementsResponse> movements(MovementsRequest movementsRequest) {
        return mMovementsApi.movements(BEARER_HEADER+movementsRequest.getAccessToken(), movementsRequest.getUser(), DEEP,
        INCLUDE_CHARGES,INCLUDE_DEPOSITS, movementsRequest.getMax());
    }



}
