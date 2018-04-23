package com.moises.finerio.main.models;

/**
 * Created by mou on 19/04/18.
 */

public class MovementsRequest {

    private String accessToken;
    private String user;

    public int getMax() {
        return max;
    }

    public MovementsRequest(String accessToken, String user, int max) {

        this.accessToken = accessToken;
        this.user = user;
        this.max = max;
    }

    private int max;

    public MovementsRequest(String accessToken, String user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUser() {
        return user;
    }
}
