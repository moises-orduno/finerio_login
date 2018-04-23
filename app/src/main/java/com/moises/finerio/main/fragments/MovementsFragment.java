package com.moises.finerio.main.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.moises.finerio.R;
import com.moises.finerio.main.adapters.MovementRecyclerViewAdapter;
import com.moises.finerio.main.models.Datum;
import com.moises.finerio.main.presenters.MovementsPresenter;
import com.moises.finerio.main.presenters.MovementsPresenterImpl;
import com.moises.finerio.main.views.MovementsView;

import java.util.List;



public class MovementsFragment extends Fragment implements MovementsView {

    public static final String TAG = MovementsFragment.class.getSimpleName();

    private MovementsPresenter mPresenter;
    private ProgressBar mProgressbar;
    //resources brought by the service

    //number which mMax increases everytime the service is requested
    public final static int MAX_INCREMENT=6;
    private int mMax=MAX_INCREMENT;


    private MovementRecyclerViewAdapter mMovementRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private TextView mEmail;
    private List<Datum> mMovements;

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MovementsFragment newInstance() {
        MovementsFragment fragment = new MovementsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movements, container, false);
        mProgressbar = view.findViewById(R.id.progressbar);
        mRecyclerView = view.findViewById(R.id.recycler_view_products);
        mEmail = view.findViewById(R.id.textview_email);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                if (mIsLoading)
//                    return;
                int visibleItemCount = mLayoutManager.getChildCount();
                int totalItemCount = mLayoutManager.getItemCount();
                int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();
                if (pastVisibleItems + visibleItemCount >= totalItemCount && mMovements.size() < mMax) {

                    Log.d(TAG, "onScrolled max is : "+mMax);
                    mPresenter.movementsWithMax();
                    mMax+=MAX_INCREMENT;
                    //End of list
                }
            }
        });

        mPresenter = new MovementsPresenterImpl(this);
        mPresenter.getEmail();
        mPresenter.movementsWithMax();
//        mPresenter.movements();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    @Override
    public Context getFragmentContext() {
        return getContext();
    }

    @Override
    public ProgressBar progressBar() {
        return mProgressbar;
    }

    @Override
    public int getMax() {
        return mMax;
    }

    @Override
    public void setMovements(List<Datum> movements) {
        if (movements.isEmpty()) return;
        mMovements = movements;
        mMovementRecyclerViewAdapter = new MovementRecyclerViewAdapter(movements);
        mRecyclerView.setAdapter(mMovementRecyclerViewAdapter);
    }

    @Override
    public void setEmail(String email) {
        mEmail.setText(email);
    }

}
