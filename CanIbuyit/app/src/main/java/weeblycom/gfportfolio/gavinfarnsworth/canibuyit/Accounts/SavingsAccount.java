package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.AccountManager;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.AddAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Model;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class SavingsAccount extends Account {
    public double availableBalance;
    public double interest;

    public SavingsAccount(String name, String bank, double currentBalance,  double availableBalance, double interest, int id) {
        super(name, bank, "Savings Account", currentBalance, true, id);
        this.availableBalance = availableBalance;
        this.interest = interest;

    }

    public SavingsAccount() {
    }

    @Override
    public void sum() {
        double newTransactionsTotal=sumNewTrasactions();
        super.setCurrentBalance(super.getCurrentBalance()-newTransactionsTotal);
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
/*
        public static EditText nameEditText;
        public static Spinner typeSpinner;
        public static EditText        bankEditText;
        public static EditText        currentEditText;
        */

        AddAccount.setNameEditText(super.getName().toString());
        AddAccount.setBankEditText(super.getBank().toString());
        AddAccount.setCurrentEditText(super.getCurrentBalance()+"");
        int location = Model.accountManager.getLocationInTypeList("Savings");
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

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
