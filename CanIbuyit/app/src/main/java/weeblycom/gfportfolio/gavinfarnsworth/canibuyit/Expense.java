package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import java.util.Date;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Expense extends Transaction {
    public Expense(boolean deposit, String name, Double cost, Date date, String category) {
        super(deposit, name, cost, date, category);
    }

    public Expense(String Name, Double Cost, Date Date) {
        super(Name, Cost, Date);
    }

    public Expense(String Name, Double Cost, Date Date, String Category) {
        super(Name, Cost, Date, Category);
    }

    public Expense() {
    }
}
