package com.moises.finerio.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mou on 18/04/18.
 */

public class MovementsResponse {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("size")
    @Expose
    private Integer size;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
