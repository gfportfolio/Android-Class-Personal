package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import org.w3c.dom.NameList;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Transaction {
    private String name;
    private Double cost;
    private Date date;
    private String category;
    private boolean deposit;
    private int accountID;

    public Transaction(String name, Double cost, Date date, String category, boolean deposit, int accountID) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.category = category;
        this.deposit = deposit;
        this.accountID = accountID;
    }

    public Transaction(boolean deposit, String name, Double cost, Date date, String category) {
        this.deposit = deposit;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.category = category;

    }

    public Transaction(String Name, Double Cost, Date Date){
        name = Name;
        cost = Cost;
        date = Date;
        category = "No Category";
        deposit = true;
    }

    public Transaction(String Name, Double Cost, Date Date, String Category) {
        name = Name;
        cost = Cost;
        date = Date;
        category = Category;
        deposit = true;
    }

    public Transaction() {
        name = "";
        cost = 0.0;
        date = new Date(1990,1,1);
        deposit = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
