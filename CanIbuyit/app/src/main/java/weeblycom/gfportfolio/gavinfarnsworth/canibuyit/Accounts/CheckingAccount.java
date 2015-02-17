package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class CheckingAccount extends Account {
    private double availableBalance;


    public CheckingAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance, int id) {
        super(name, bank, "Checking Account", currentBalance, positive, id);
        this.availableBalance = availableBalance;
    }



    @Override
    void sum() {
        double newTransactionsTotal=sumNewTrasactions();
        super.setCurrentBalance(super.getCurrentBalance()-newTransactionsTotal);
        availableBalance -=newTransactionsTotal;
    }

    public double getAvailableBalance() {
        return availableBalance;

    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

}
