package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.ArrayList;
import java.util.Date;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.AccountFactory;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

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
//hello

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

    public boolean addAccount(String type, String name, String bank, double currentBalance, boolean positive, double owedBalance, double interest,  Date dueDate, double paymentAmount, double availableBalance, double limit){
        int currentID = currentAccounts.size();
        currentID++;
        AccountFactory factory = new AccountFactory(type,  name,  bank,  currentBalance,  positive,  owedBalance,  interest,   dueDate,  paymentAmount,  availableBalance,  limit,  currentID);
        Account newAccount = factory.makeAccount();
        currentAccounts.add(newAccount);
        return true;
    }
    public boolean removeAccount(int id){

        Account RemoveAccount=null;
        for(Account a : currentAccounts){
            if(a.getId()==id){
                RemoveAccount=a;
            }
        }
        if(RemoveAccount==null){
            return false;
        }
        currentAccounts.remove(RemoveAccount);
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
    public boolean addAccount(Account account){
        currentAccounts.add(account);
        return true;
    }
    public int totalAccounts(){
        return currentAccounts.size();
    }

    public boolean addTransactionToAccount(int i, Transaction t){
        currentAccounts.get(i).addTransaction(t);
        return true;
    }

}
