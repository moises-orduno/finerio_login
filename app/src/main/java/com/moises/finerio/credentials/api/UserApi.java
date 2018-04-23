package com.moises.finerio.credentials.api;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by mou on 17/02/18.
 */

public interface UserApi {

    @Headers({
            "Content-Type: application/json;charset=UTF-8",
            "Origin: https://app.finerio.mx",
            "Host: api.finerio.mx",
            "Accept: application/json;charset=UTF-8",
            "Connection: keep-alive",
            "Accept-Language: es-xl",
            "Accept-Encoding: gzip, deflate",
            "Authorization: Bearer",
            "User-Agent: Android",
            "Referer: https://app.finerio.mx/login"

    })
    @POST("login")
    Observable<LogInResponse> logInUser(@Body LogInRequest logInRequest,@Header("Content-Length") int contentLenght);

    @Headers({
            "Content-Type: application/json;charset=UTF-8",
            "Origin: https://app.finerio.mx",
            "Host: api.finerio.mx",
            "Accept: application/json;charset=UTF-8",
            "Connection: keep-alive",
            "Accept-Language: es-xl",
            "Accept-Encoding: gzip, deflate",
            "User-Agent: Android",
            "Referer: https://app.finerio.mx/login"

    })
    @GET("me")
    Observable<MeResponse> meUser(@Header("Authorization") String authorizationToken);


}
