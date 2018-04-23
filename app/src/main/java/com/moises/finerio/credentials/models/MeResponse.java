package com.moises.finerio.credentials.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mou on 17/02/18.
 */

public class MeResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("accountExpired")
    @Expose
    private Boolean accountExpired;
    @SerializedName("accountLocked")
    @Expose
    private Boolean accountLocked;
    @SerializedName("customerId")
    @Expose
    private Integer customerId;
    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("notificationsEnabled")
    @Expose
    private Boolean notificationsEnabled;
    @SerializedName("passwordExpired")
    @Expose
    private Boolean passwordExpired;
    @SerializedName("termsAndConditionsAccepted")
    @Expose
    private Boolean termsAndConditionsAccepted;
    @SerializedName("type")
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(Boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public Boolean getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Boolean getTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public void setTermsAndConditionsAccepted(Boolean termsAndConditionsAccepted) {
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
