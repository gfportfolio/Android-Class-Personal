package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.Date;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.CheckingAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.SavingsAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Expense;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 2/24/15.
 */
public class Model {
    public static AccountManager accountManager;
    public static TransactionManager transactionManager;
    public static String listType;
    public static int Editing;

    public static void initiate() {
        accountManager = new AccountManager();
        transactionManager = new TransactionManager();

        accountManager.addAccount(new SavingsAccount("Savings", "Mountain America", 100.00, 95.00, 1.0, accountManager.totalAccounts()));
        accountManager.addAccount(new CheckingAccount("Checking", "Mountain America", 200.00, true, 200.00, accountManager.totalAccounts()));

        Transaction one = new Expense("Walmart", 50.0, new Date(115, 2, 3));
        Transaction two = new Expense("Lins", 20.0, new Date(115, 2, 6));
        transactionManager.addTransaction(one);
        transactionManager.addTransaction(two);

        accountManager.addTransactionToAccount(1, one);
        accountManager.addTransactionToAccount(1, two);

        accountManager.addAccountType("Savings");
        accountManager.addAccountType("Checking");
        accountManager.addAccountType("Credit Card");
        accountManager.addAccountType("Loan");
        accountManager.addAccountType("Other");
    }
}
