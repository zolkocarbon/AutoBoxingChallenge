package com.chrisz;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>(); // initialize
        addTransaction(initialAmount);
    }

    public void addTransaction(double value) {
        this.transactions.add(value);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
