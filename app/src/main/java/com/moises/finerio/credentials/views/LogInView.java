package com.moises.finerio.credentials.views;

import android.content.Context;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * Created by mou on 17/02/18.
 */

public interface LogInView {
    Context getFragmentContext();

    EditText usernameEditText();

    EditText passwordEditText();

    ProgressBar progressBar();
}
