package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Bill extends Transaction {

    public Date dueDate;

    public Bill(String Name, Double Cost, Date Date, Date DueDate) {
        super(Name, Cost, Date);
        dueDate = DueDate;
    }

    public Bill(String Name, Double Cost, Date Date, String Category, Date DueDate) {
        super(false, Name, Cost, Date, Category);
        dueDate = DueDate;
    }

    public Bill(boolean deposit, String name, Double cost, Date date, String category, Date dueDate) {
        super(deposit, name, cost, date, category);
        this.dueDate = dueDate;
    }

    public Bill(Date DueDate) {
        dueDate = DueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
