package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;

/**
 * Created by gavinfarnsworth on 2/1/15.
 */
public class TransactionManager {
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<String> types;

    public TransactionManager() {
        transactionHistory = new ArrayList<Transaction>();
        types = new ArrayList<String>();
    }

    public TransactionManager(ArrayList<Transaction> transactionHistory, ArrayList<String> types) {
        this.transactionHistory = transactionHistory;
        this.types = types;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public boolean addTransactionToHistory(Transaction transaction){
        transactionHistory.add(transaction);
        return true;
    }

    public boolean addType(String type){
        types.add(type);
        return  true;
    }

    public  boolean removeType(String type){
        types.remove(type);
        return true;
    }


}
