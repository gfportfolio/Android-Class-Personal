package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

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
}
