package com.moises.finerio.main.api;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;
import com.moises.finerio.main.models.MovementsResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mou on 18/04/18.
 */

public interface MovementsApi {



    @Headers({
            "Content-Type: application/json;charset=UTF-8",
            "Origin: https://app.finerio.mx",
            "Host: api.finerio.mx",
            "Accept: application/json;charset=UTF-8",
            "Connection: keep-alive",
            "Accept-Language: es-xl",
            "Accept-Encoding: gzip, deflate",
            "User-Agent: Android",
            "Referer: https://app.finerio.mx/app/movements"

    })
    @GET("users/{user}/movements")
    Observable<MovementsResponse> movements(@Header("Authorization") String authorizationToken, @Path("user") String user, @Query("deep") boolean order,
                                         @Query("includeCharges") boolean includeCharges, @Query("includeDeposits") boolean includeDeposits, @Query("max") int max);


}
