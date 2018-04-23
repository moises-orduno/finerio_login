package com.moises.finerio.credentials.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mou on 17/02/18.
 */

public class Data {

    public Data(String pass, String user) {
        this.pass = pass;
        this.user = user;
    }

    @SerializedName("pass")
    @Expose
    private String pass;
    @SerializedName("user")
    @Expose
    private String user;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
