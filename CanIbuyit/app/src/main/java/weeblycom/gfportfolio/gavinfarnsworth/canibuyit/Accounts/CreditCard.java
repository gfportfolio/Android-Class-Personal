package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class CreditCard extends Account {
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;
    private double availableBalance;

    public CreditCard(String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance) {
        super(name, bank, "Credit Card", currentBalance, positive);
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
        this.availableBalance = availableBalance;
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
    void sum() {

    }
}
