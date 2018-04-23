package com.moises.finerio.credentials.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.moises.finerio.R;
import com.moises.finerio.credentials.presenters.LogInPresenter;
import com.moises.finerio.credentials.presenters.LogInPresenterImpl;
import com.moises.finerio.credentials.views.LogInView;


public class LogInFragment extends Fragment implements LogInView {


    public static final String TAG = LogInFragment.class.getSimpleName();

    private LogInPresenter mPresenter;
    private EditText mPasswordEditText;
    private EditText mUsernameEditText;
    private ProgressBar mProgressbar;


    public static LogInFragment newInstance() {

        return new LogInFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_log_in, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.logIn();
            }
        });

        mPasswordEditText = view.findViewById(R.id.edittext_password);
        mUsernameEditText = view.findViewById(R.id.edittext_view_amount);
        mProgressbar = view.findViewById(R.id.progressbar);

        mPresenter = new LogInPresenterImpl(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public Context getFragmentContext() {
        return getContext();
    }

    @Override
    public EditText usernameEditText() {
        return mUsernameEditText;
    }

    @Override
    public EditText passwordEditText() {
        return mPasswordEditText;
    }

    @Override
    public ProgressBar progressBar() {
        return mProgressbar;
    }
}