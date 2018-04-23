package com.moises.finerio.credentials.presenters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import com.moises.finerio.R;
import com.moises.finerio.common.presenters.BasePresenterImpl;
import com.moises.finerio.credentials.fragments.LogInFragment;
import com.moises.finerio.credentials.interactors.UserInteractor;
import com.moises.finerio.credentials.interactors.UserInteractorImpl;
import com.moises.finerio.credentials.models.LogInRequest;
import com.moises.finerio.credentials.models.LogInResponse;
import com.moises.finerio.credentials.models.MeResponse;
import com.moises.finerio.credentials.views.LogInView;
import com.moises.finerio.main.activities.MainActivity;

import rx.Subscriber;

/**
 * Created by mou on 17/02/18.
 */

public class LogInPresenterImpl extends BasePresenterImpl implements LogInPresenter {

    private final Context mContext;
    private final LogInView mView;
    private final UserInteractor mUserInteractor;

    public LogInPresenterImpl(LogInView view) {
        super(view.getFragmentContext(), view.progressBar());
        mContext = view.getFragmentContext();
        mView = view;
        mUserInteractor = new UserInteractorImpl();
    }


    @Override
    public void logIn() {


        EditText editTextPassword = mView.passwordEditText();
        EditText editTextUsername = mView.usernameEditText();

        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();


//        String username = "reptilianguitar@gmail.com";
//        String password = "Inacage21";

        boolean cancel = false;

        if (password.length() == 0) {
            editTextPassword.setError("error");
            cancel = true;
        }

        if (username.length() == 0) {
            editTextUsername.setError("error");
            cancel = true;
        }
        if (cancel) return;

        showProgress();

        Subscriber<LogInResponse> subscriber = new Subscriber<LogInResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.e(LogInFragment.TAG, "onError: " + e.getMessage());
                showOneButtonDialog(e.getMessage());
                hideProgress();
            }

            @Override
            public void onNext(LogInResponse logInResponse) {

                hideProgress();
                storeAuthToken(logInResponse);
                me(logInResponse);

            }
        };
        mUserInteractor.logIn(subscriber, new LogInRequest(username, password));
    }



    @Override
    public void me(LogInResponse logInResponse) {


        showProgress();

        Subscriber<MeResponse> subscriber = new Subscriber<MeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.e(LogInFragment.TAG, "onError: " + e.getMessage());
                showOneButtonDialog(e.getMessage());
                hideProgress();
            }

            @Override
            public void onNext(MeResponse meResponse) {

                storeUserToken(meResponse);
                storeUserEmail(meResponse);
                hideProgress();
                startMovementsActivity();

            }
        };
        mUserInteractor.me(subscriber, logInResponse);
    }

    private void storeUserEmail(MeResponse meResponse) {
        saveSharedPreferenceValue(meResponse.getEmail(),mContext.getString(R.string.saved_email));
    }

    private void startMovementsActivity() {

        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);

    }

    private void storeAuthToken(LogInResponse logInResponse) {
        saveSharedPreferenceValue(logInResponse.getAccessToken(),mContext.getString(R.string.saved_auth_token));
    }
    private void storeUserToken(MeResponse meResponse) {
        saveSharedPreferenceValue(meResponse.getId()+"",mContext.getString(R.string.saved_customer_id));
    }




}
