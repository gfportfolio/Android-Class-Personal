package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.Date;

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
    public boolean addAccount(String type, String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest,  Date dueDate, double paymentAmount, double availableBalance) {
        Account newAccount = null;
        switch (type) {
            case "CheckingAccount":
                newAccount=addCheckingAccount(name, bank, currentBalance, positive, availableBalance);
            case "CreditCard":
                newAccount=addCreditCard( name,  bank,  currentBalance,  positive,  owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance);
            case "Loan":
                newAccount=addLoan( name,  bank, currentBalance,  positive,  paymentAmount,  owedBalance,  interest,  dueDate);
            case "OtherAccount":
                newAccount=addOtherAccount( name,  bank,   currentBalance,  positive);
            case "Savings":
                newAccount=addSavingsAccount( name,  bank,  currentBalance,  positive,  availableBalance,  interest);
        }
        return true;
    }

    private SavingsAccount addSavingsAccount(String name, String bank,  double currentBalance, boolean positive, double availableBalance, double interest) {
       SavingsAccount newAccount = new SavingsAccount(name,  bank,   currentBalance,  positive,  availableBalance,  interest);
        //String name, String bank, String type, double currentBalance, boolean positive, double availableBalance, double interest
        return newAccount;
    }

    private OtherAccount addOtherAccount(String name, String bank,  double currentBalance, boolean positive) {
       OtherAccount newAccount = new OtherAccount(name,  bank,   currentBalance,  positive);
       // String name, String bank,  double currentBalance, boolean positive
       return newAccount;
    }

    private Loan addLoan(String name, String bank,  double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate) {
        Loan newAccount = new Loan(name,  bank, currentBalance,  positive,  paymentAmount,  owedBalance,  interest,  dueDate);
        //String name, String bank,  double currentBalance, boolean positive, double paymentAmount, double owedBalance, double interest, Date dueDate
        return newAccount;
    }

    private CreditCard addCreditCard(String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance) {
       CreditCard newAccount = new CreditCard(name,  bank,  currentBalance,  positive,  owedBalance,  interest,  dueDate,  paymentAmount,  availableBalance);
       // String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest, Date dueDate, double paymentAmount, double availableBalance
        return newAccount;
    }

    private CheckingAccount addCheckingAccount(String name, String bank, double currentBalance, boolean positive, double availableBalance) {
        CheckingAccount newAccount = new CheckingAccount(name, bank, currentBalance, positive, availableBalance);
        //String name, String bank, double currentBalance, boolean positive, double availableBalance
        return newAccount;
    }
}
