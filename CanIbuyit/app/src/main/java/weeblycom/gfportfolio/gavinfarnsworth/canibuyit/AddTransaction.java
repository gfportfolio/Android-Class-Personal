package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.AvoidXfermode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Bill;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Deposit;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Expense;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;


public class AddTransaction extends ActionBarActivity {
    public static EditText locationEditText;
    public static EditText amountEditText;
    public static Spinner accountSpinner;
    public static Button paidDateButton;
    public static Button dueDateButton;
    public static ImageButton deleteButton;
    public static ImageButton saveButton;
    public static Spinner typeSpinner;
    public static Button lastPickDateButton;
    public static LinearLayout dueDateLayout;
    public static int accountLocationId;
    private Transaction newTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        setupIds();

        if(Model.Editing>=0){
            setupActivity();
        }

    }

    public void setupIds(){
        locationEditText =(EditText) findViewById(R.id.location_add_trans);
        amountEditText =(EditText) findViewById(R.id.amount_add_trans);
        accountSpinner = (Spinner) findViewById(R.id.accountSpinner_add_tran);
        paidDateButton = (Button) findViewById(R.id.payDatePick_add_trans);
        dueDateButton = (Button) findViewById(R.id.dueDatePick_add_trans);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton_add_trans);
        saveButton = (ImageButton) findViewById(R.id.saveButton_add_trans);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner_add_transaction);
        dueDateLayout = (LinearLayout) findViewById(R.id.dueDateLayout_add_transaction);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , Model.accountManager.getAccountNames());
        accountSpinner.setAdapter(adapter);

        accountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accountLocationId=position;


                //Toast.makeText(getApplicationContext(),
                //        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                //        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , Model.transactionManager.getTypes());
        typeSpinner.setAdapter(adapter2);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = Model.transactionManager.getTypeFromIndex(position);
                switch(type){
                    case "Bill":newTransaction = new Bill();
                        break;
                    case "Deposit": newTransaction = new Deposit();
                        break;
                    case "Expense": newTransaction = new Expense();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setupActivity(){
        Transaction selectedTransaction = Model.transactionManager.getTransaction(Model.Editing);
        selectedTransaction.setUpCurrentTransactionActivity();
    }

    public void datePickerClick(View v){
        lastPickDateButton = (Button) v;
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void deleteClick(View v){
        if(Model.Editing>-1){
            Model.transactionManager.removeTransaction(Model.Editing);
            Model.accountManager.removeTransaction(accountLocationId, Model.Editing);
        }
        finish();
    }

    public void saveClick(View v){
        if(!paidDateButton.getText().equals(getString(R.string.pickADate))) {


            newTransaction.addTransaction();

            if (Model.Editing > -1) {
                Model.transactionManager.replaceTransaction(newTransaction, Model.Editing);
                Model.accountManager.replaceTransaction(accountLocationId, Model.Editing, newTransaction);
            } else {
                Model.transactionManager.addTransaction(newTransaction);
                Model.accountManager.addTransactionToAccount(accountLocationId, newTransaction);
            }
            Model.Editing=-1;
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),
                    "Please Choose a Date", Toast.LENGTH_LONG)
                    .show();
        }
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            AddTransaction.lastPickDateButton.setText((month+1)+"/"+day+"/"+year);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_transaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
