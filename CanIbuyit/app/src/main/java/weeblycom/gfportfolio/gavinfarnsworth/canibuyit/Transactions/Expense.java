package weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.AddTransaction;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Model;

/**
 * Created by gavinfarnsworth on 1/27/15.
 */
public class Expense extends Transaction {
    public Expense(boolean deposit, String name, Double cost, Date date) {
        super(deposit, name, cost, date, "Expense");
    }

    public Expense(String Name, Double Cost, Date Date) {
        super(Name, Cost, Date, "Expense");
    }

    public Expense(String Name, Double Cost, Date Date, String Category) {
        super(Name, Cost, Date, Category);
    }

    public Expense() {
    }

    @Override
    public void setUpActivity() {

    }



    @Override
    public void addTransaction() {

    }

    @Override
    public void setUpCurrentTransactionActivity() {
        /*
        public EditText locationEditText;
        public EditText amountEditText;
        public Spinner accountSpinner;
        public Button paidDateButton;
        public Button dueDateButton;
        public ImageButton deleteButton;
        public ImageButton saveButton;
        public Spinner typeSpinner;
        public static Button lastPickDateButton;
        public LinearLayout dueDateLayout;
        */

        AddTransaction.locationEditText.setText(super.getName());
        AddTransaction.amountEditText.setText(super.getCost()+"");
        AddTransaction.accountSpinner.setSelection(super.getAccountID());
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = super.getDate();
        date.setMonth(date.getMonth()-1);
        String dateString = formatter.format(super.getDate());
        AddTransaction.paidDateButton.setText(dateString);
        AddTransaction.typeSpinner.setSelection(Model.transactionManager.getTypeIndex(super.getCategory()));
        AddTransaction.dueDateLayout.setVisibility(View.GONE);
    }


}
