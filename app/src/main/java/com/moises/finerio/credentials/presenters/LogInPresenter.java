package com.moises.finerio.credentials.presenters;

import com.moises.finerio.credentials.models.LogInResponse;

/**
 * Created by mou on 17/02/18.
 */

public interface LogInPresenter {

    void logIn();

    void me(LogInResponse logInResponse);
}
