package com.moises.finerio.main.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mou on 18/04/18.
 */

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("balance")
    @Expose
    private Double balance;
    @SerializedName("customDate")
    @Expose
    private String customDate;
    @SerializedName("customDescription")
    @Expose
    private String customDescription;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("duplicated")
    @Expose
    private Boolean duplicated;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("concepts")
    @Expose
    private List<Concept> concepts = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCustomDate() {
        return customDate;
    }

    public void setCustomDate(String customDate) {
        this.customDate = customDate;
    }

    public String getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDuplicated() {
        return duplicated;
    }

    public void setDuplicated(Boolean duplicated) {
        this.duplicated = duplicated;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }


}
