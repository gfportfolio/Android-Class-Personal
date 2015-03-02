package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class OtherAccount extends Account {
    private double owedBalance;
    private double interest;
    private Date dueDate;
    private double paymentAmount;
    private double availableBalance;

    public OtherAccount(String name, String bank,  double currentBalance, boolean positive, int id) {
        super(name, bank, "Other Account", currentBalance, positive, id);
        this.owedBalance=0.0;
        this.interest=1.0;
        this.dueDate= null;
        this.paymentAmount=0.0;
        this.availableBalance=0.0;
    }

    @Override
    public void sum() {
        double newTransactionsTotal=sumNewTrasactions();
        super.setCurrentBalance(super.getCurrentBalance()+newTransactionsTotal);

    }

    @Override
    public void addAccount() {

    }

    @Override
    public void setUpCurrentAccountActivity() {

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
}
