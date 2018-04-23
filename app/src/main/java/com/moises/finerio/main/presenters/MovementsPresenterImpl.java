package com.moises.finerio.main.presenters;

import android.content.Context;
import android.util.Log;

import com.moises.finerio.R;
import com.moises.finerio.common.presenters.BasePresenterImpl;
import com.moises.finerio.main.fragments.MovementsFragment;
import com.moises.finerio.main.interactors.MovementInteractor;
import com.moises.finerio.main.interactors.MovementInteractorImpl;
import com.moises.finerio.main.models.MovementsRequest;
import com.moises.finerio.main.models.MovementsResponse;
import com.moises.finerio.main.views.MovementsView;

import rx.Subscriber;

/**
 * Created by mou on 19/04/18.
 */

public class MovementsPresenterImpl extends BasePresenterImpl implements MovementsPresenter {


    private final Context mContext;
    private final MovementsView mView;
    private final MovementInteractor mMovementInteractor;

    public MovementsPresenterImpl(MovementsView view) {
        super(view.getFragmentContext(), view.progressBar());
        mContext = view.getFragmentContext();
        mView = view;
        mMovementInteractor = new MovementInteractorImpl();
    }

    @Override
    public void movements() {

        showProgress();

        Subscriber<MovementsResponse> subscriber = new Subscriber<MovementsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.e(MovementsFragment.TAG, "onError: " + e.getMessage());
                hideProgress();
            }

            @Override
            public void onNext(MovementsResponse movementsResponse) {

                hideProgress();
                Log.d(MovementsFragment.TAG, "onNext: ");
                mView.setMovements(movementsResponse.getData());

            }
        };
        mMovementInteractor.movement(subscriber, new MovementsRequest(getAccessToken(), getUser(),0));
    }

    @Override
    public void movementsWithMax() {


        showProgress();

        Subscriber<MovementsResponse> subscriber = new Subscriber<MovementsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.e(MovementsFragment.TAG, "onError: " + e.getMessage());
                hideProgress();
            }

            @Override
            public void onNext(MovementsResponse movementsResponse) {

                hideProgress();
                Log.d(MovementsFragment.TAG, "onNext: ");
                mView.setMovements(movementsResponse.getData());

            }
        };
        mMovementInteractor.movement(subscriber, new MovementsRequest(getAccessToken(), getUser(),mView.getMax()));
    }

    @Override
    public void getEmail() {
        mView.setEmail(getStringSharedPreferenceValue(mContext.getString(R.string.saved_email)));
    }

    private String getAccessToken() {
        return getStringSharedPreferenceValue(mContext.getString(R.string.saved_auth_token));
    }

    private String getUser() {
        return getStringSharedPreferenceValue(mContext.getString(R.string.saved_customer_id));
    }
}
