package com.moises.finerio.credentials.repositories;


import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;

import rx.Observable;

/**
 * Created by mou on 15/01/17.
 */
public interface UserRepository {

    Observable<LogInResponse> logInUser(LogInRequest logInRequest);

    Observable<MeResponse> meUser(LogInResponse logInResponse);

}
