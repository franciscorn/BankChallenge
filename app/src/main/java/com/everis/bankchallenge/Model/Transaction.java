package com.everis.bankchallenge.Model;

public class Transaction {

    private String title, desc, date, value;

    public Transaction(String title, String desc, String date, String value) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }
}
