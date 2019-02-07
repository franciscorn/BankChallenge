package com.everis.bankchallenge.Model;

public class UserAccount {
    private long userId, bankAccount, agency;
    private String name;
    private Double balance;

    public UserAccount(long userId, long bankAccount, long agency, String name, Double balance) {
        this.userId = userId;
        this.bankAccount = bankAccount;
        this.agency = agency;
        this.name = name;
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public long getAgency() {
        return agency;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }
}
