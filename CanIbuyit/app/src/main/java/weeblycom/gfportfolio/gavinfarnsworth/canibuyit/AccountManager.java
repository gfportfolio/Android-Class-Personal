package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;

/**
 * Created by gavinfarnsworth on 2/1/15.
 */
public class AccountManager {
    private ArrayList<Account> currentAccounts;
    private ArrayList<String> accountTypes;

    public AccountManager() {
        currentAccounts = new ArrayList<Account>();
        accountTypes = new ArrayList<String>();
    }

    public AccountManager(ArrayList<Account> currentAccounts, ArrayList<String> accountTypes) {
        this.currentAccounts = currentAccounts;
        this.accountTypes = accountTypes;
    }

    public ArrayList<Account> getCurrentAccounts() {
        return currentAccounts;
    }

    public ArrayList<String> getAccountTypes() {
        return accountTypes;
    }

    public boolean addAccount(Account account){
        currentAccounts.add(account);
        return true;
    }
    public boolean removeAccount(Account account){
        currentAccounts.remove(account);
        return true;
    }
    public boolean addAccountType(String type){
        accountTypes.add(type);
        return true;
    }
    public boolean removeAccountType(String type){
        accountTypes.remove(type);
        return true;
    }

}
