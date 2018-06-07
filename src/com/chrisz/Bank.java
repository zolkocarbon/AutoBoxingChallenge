package com.chrisz;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String CustomerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomer(CustomerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String CustomerName, double amount) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(CustomerName, amount);
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        for (Branch currentBranch : branches) { // equivalent to foreach
            if(currentBranch.getName().equals(branchName)) {
                return currentBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customers for branch " + branchName);
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(Customer customer : branchCustomers) {
                System.out.println(customer.getName());
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for(int i=0; i<transactions.size(); i++) {
                        System.out.println((i+1) + ": " + transactions.get(i));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
