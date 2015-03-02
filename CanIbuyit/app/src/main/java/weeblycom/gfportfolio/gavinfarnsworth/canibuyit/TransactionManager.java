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
       // types.add("Bill");
       //types.add("Deposit");
        types.add("Expense");
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

    public boolean addTransaction(Transaction t){
        transactionHistory.add(t);
        return true;
    }

    public Transaction getTransaction(int i){
        return transactionHistory.get(i);

    }

    public String getTypeFromIndex(int i ){
        return types.get(i);
    }

    public void replaceTransaction(Transaction t, int i){
        transactionHistory.remove(i);
        transactionHistory.add(i, t);
    }

    public int getTypeIndex(String type){
        for(int i =0 ; i < types.size(); i++){
            if(types.get(i).equals(type)){
                return i;

            }
        }
        return 0;
    }

    public void removeTransaction(int location){
        transactionHistory.remove(location);
    }
}
