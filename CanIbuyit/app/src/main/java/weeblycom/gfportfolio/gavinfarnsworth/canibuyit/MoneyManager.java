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
        return accountManager.addAccount( type,  name,  bank,  currentBalance,  positive,  owedBalance,  interest,   dueDate,  paymentAmount,  availableBalance,  limit);
    }



    private Boolean removeAccount(int id){
        return accountManager.removeAccount(id);
    }
}

