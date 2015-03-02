package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Loan extends Account {
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;


    public Loan(String name, String bank,  double currentBalance, double paymentAmount, double owedBalance, double interest, Date dueDate, int id) {
        super(name, bank, "Loan", currentBalance, false, id);
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
        double newTransactionsTotal=sumNewTrasactions();
        setCurrentBalance(super.getCurrentBalance()-newTransactionsTotal);

    }

    @Override
    public void addAccount() {

    }

    @Override
    public void setUpCurrentAccountActivity() {

    }


}
