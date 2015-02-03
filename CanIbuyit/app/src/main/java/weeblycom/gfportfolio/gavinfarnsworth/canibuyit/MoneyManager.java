package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.CheckingAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.CreditCard;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Loan;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.OtherAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.SavingsAccount;

/**
 * Created by gavinfarnsworth on 2/1/15.
 */
public class MoneyManager {
    private AccountManager accountManager;
    private TransactionManager transactionManager;

    public MoneyManager() {
        accountManager = new AccountManager();
        transactionManager = new TransactionManager();
    }

    public MoneyManager(AccountManager accountManager, TransactionManager transactionManager) {
        this.accountManager = accountManager;
        this.transactionManager = transactionManager;
    }
    public boolean addAccount(String type, String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest,  Date dueDate, double paymentAmount, double availableBalance, double limit) {
        Account newAccount = null;
        switch (type) {
            case "CheckingAccount":
                newAccount=addCheckingAccount(name, bank, currentBalance, positive, availableBalance);
            case "CreditCard":
                newAccount=addCreditCard( name,  bank,  currentBalance, owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance, limit);
            case "Loan":
                newAccount=addLoan( name,  bank, currentBalance, paymentAmount,  owedBalance,  interest,  dueDate);
            case "OtherAccount":
                newAccount=addOtherAccount( name,  bank,   currentBalance,  positive);
            case "Savings":
                newAccount=addSavingsAccount( name,  bank,  currentBalance, availableBalance,  interest);
        }
        return true;
    }

    private SavingsAccount addSavingsAccount(String name, String bank,  double currentBalance, double availableBalance, double interest) {
       SavingsAccount newAccount = new SavingsAccount(name,  bank,   currentBalance,  availableBalance,  interest);
        //String name, String bank, String type, double currentBalance, boolean positive, double availableBalance, double interest
        return newAccount;
    }

    private OtherAccount addOtherAccount(String name, String bank,  double currentBalance, boolean positive) {
       OtherAccount newAccount = new OtherAccount(name,  bank,   currentBalance,  positive);
       // String name, String bank,  double currentBalance, boolean positive
       return newAccount;
    }

    private Loan addLoan(String name, String bank,  double currentBalance, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        Loan newAccount = new Loan(name,  bank, currentBalance, paymentAmount,  owedBalance,  interest,  dueDate);
        //String name, String bank,  double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate
        return newAccount;
    }

    private CreditCard addCreditCard(String name, String bank, double currentBalance,  double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance, double limit) {
       CreditCard newAccount = new CreditCard(name,  bank,  currentBalance,   owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance, limit);
       // String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance
        return newAccount;
    }

    private CheckingAccount addCheckingAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance) {
        CheckingAccount newAccount = new CheckingAccount(name, bank, currentBalance, positive, availableBalance);
        //String name, String bank, double currentBalance, boolean positive, double availableBalance
        return newAccount;
    }

    private Boolean removeAccount(String type, String Name, String Bank){
        ArrayList<Account> accountList = accountManager.getCurrentAccounts();
        Account RemoveAccount=null;
        for(Account a : accountList){
            if(a.getBank()==Bank&&a.getName()==Name&&a.getType()==type){
                RemoveAccount=a;
            }
        }
        if(RemoveAccount==null){
            return false;
        }
        accountManager.removeAccount(RemoveAccount);
        return true;
    }
}

