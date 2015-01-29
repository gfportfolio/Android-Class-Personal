package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Loan extends Account {
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;


    public Loan(String name, String bank, String type, double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        super(name, bank, type, currentBalance, positive);
        this.paymentAmount = paymentAmount;
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
    }

    public Loan(String name, String type, double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        super(name, type, currentBalance, positive);
        this.paymentAmount = paymentAmount;
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
    }

    public Loan(String name, String type, double currentBalance, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        super(name, type, currentBalance);
        this.paymentAmount = paymentAmount;
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
    }

    public Loan(String name, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        super(name);
        this.paymentAmount = paymentAmount;
        this.owedBalance = owedBalance;
        this.interest = interest;
        this.dueDate = dueDate;
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

    @Override
    public void sum(){

    }

}
