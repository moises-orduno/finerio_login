package com.moises.finerio.main.views;

import android.content.Context;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.moises.finerio.main.models.Datum;

import java.util.List;

/**
 * Created by mou on 17/02/18.
 */

public interface MovementsView {
    Context getFragmentContext();

    ProgressBar progressBar();

    int getMax();

    void setMovements(List<Datum> movements);

    void setEmail(String email);
}
