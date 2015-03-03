package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.AddAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Model;
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

    public CheckingAccount() {
    }

    @Override
    public void sum() {
        double newTransactionsTotal=sumNewTrasactions();
        super.setCurrentBalance(super.startAmount + newTransactionsTotal);
    }

    @Override
    public void addAccount() {
        try {
            super.setName(AddAccount.getNameEditText());
            super.setCurrentBalance(Double.parseDouble(AddAccount.getCurrentEditText()));
            super.setBank(AddAccount.getBankEditText());
            if(super.startAmount==0){
                super.startAmount = super.getCurrentBalance();
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    @Override
    public void setUpCurrentAccountActivity() {
        AddAccount.setNameEditText(super.getName().toString());
        AddAccount.setBankEditText(super.getBank().toString());
        AddAccount.setCurrentEditText(super.getCurrentBalance()+"");
        int location = Model.accountManager.getLocationInTypeList("Checking");
         AddAccount.setCurrentTypePosition(location);
    }

    @Override
    public void addAccountWithTransactions(ArrayList<Transaction> transactions) {
        addAccount();
        super.addTransactionsFromList(transactions);
    }

    public double getAvailableBalance() {
        return availableBalance;

    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

}
