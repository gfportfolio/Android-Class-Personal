package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public abstract class Account {
    private String name;
    private String bank;
    private String type;
    private double currentBalance;
    private boolean positive;
    private ArrayList<Transaction> transactions;
    private ArrayList<Transaction> newTransactions;
    private int id;



    public Account(String name, String bank, String type, double currentBalance, boolean positive, int id) {
        this.name = name;
        this.bank = bank;
        this.type = type;
        this.currentBalance = currentBalance;
        this.positive = positive;
        this.transactions = new ArrayList<Transaction>();
        this.newTransactions = new ArrayList<Transaction>();
        this.id = id;
    }

    public String getBank() {
        return bank;

    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    abstract void sum();
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);

    }
    public void addNewTransaction(Transaction transaction){
        this.newTransactions.add(transaction);

    }

    public ArrayList<Transaction> getNewTransactions() {
        return newTransactions;
    }
}
