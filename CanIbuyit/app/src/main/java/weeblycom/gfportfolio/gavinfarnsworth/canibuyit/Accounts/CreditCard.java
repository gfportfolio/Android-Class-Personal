package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.Date;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class CreditCard extends Account {
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;
    private double availableBalance;
    private double limit;

    public CreditCard(String name, String bank, double currentBalance, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance, double limit, int id) {
        super(name, bank, "Credit Card", currentBalance, false, id);
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
        this.availableBalance = availableBalance;
        this.limit = limit;

    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getOwedBalance() {
        return owedBalance;
    }

    public void setOwedBalance(double owedBalance) {
        this.owedBalance = owedBalance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public void sum() {
        double newTransactionsTotal=sumNewTrasactions();
        super.setCurrentBalance(super.getCurrentBalance()+newTransactionsTotal);
        owedBalance = limit-super.getCurrentBalance();
    }

    @Override
    public void addAccount() {

    }

    @Override
    public void setUpCurrentAccountActivity() {

    }
}
