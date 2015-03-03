package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.CheckingAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.SavingsAccount;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Bill;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Deposit;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Expense;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;


public class AddAccount extends ActionBarActivity {
    private TextView        nameTextView;
    private TextView        typeTextView;
    private TextView        bankTextView;
    private TextView        currentTextView;
    private TextView        availabeTextView;
    private TextView        interestTextView;
    private TextView        limitTextView;
    private TextView        dueDateTextView;
    private LinearLayout    nameLayout;
    private LinearLayout    typeLayout;
    private LinearLayout    bankLayout;
    private LinearLayout    currentLayout;
    private LinearLayout    availabeLayout;
    private LinearLayout    interestLayout;
    private LinearLayout    limitLayout;
    private LinearLayout    dueDateLayout;
    private static EditText        nameEditText;
    private static Spinner         typeSpinner;
    private static EditText        bankEditText;
    private static EditText        currentEditText;
    private EditText        availabeEditText;
    private EditText        interestEditText;
    private EditText        limitEditText;
    private Button          dueDateButton;
    private Button          viewTransactionButton;
    private ImageButton     saveButton;
    private ImageButton     deleteButton;
    private Account newAccount;
    private Account selectedAccount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        setupInstanceVariables();
        if(Model.Editing>=0){
            setupActivity();
        }
        else{
            viewTransactionButton.setVisibility(View.INVISIBLE);
        }
    }

    public void setupActivity(){
        selectedAccount = Model.accountManager.getCurrentAccounts().get(Model.Editing);
        selectedAccount.setUpCurrentAccountActivity();
    }

    private void setupInstanceVariables(){
        saveButton = (ImageButton) findViewById(R.id.save_add_account);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton_add_account);
        nameTextView =(TextView) findViewById(R.id.namelbl_add_activity);
        typeTextView  =(TextView) findViewById(R.id.typelbl_add_account);
        bankTextView=(TextView) findViewById(R.id.banklbl_add_activity);
        currentTextView=(TextView) findViewById(R.id.currentlbl_add_activity);
        availabeTextView=(TextView) findViewById(R.id.availablelbl_add_activity);
        interestTextView=(TextView) findViewById(R.id.interestlbl_add_activity);
        limitTextView=(TextView) findViewById(R.id.limitlbl_add_activity);
        dueDateTextView=(TextView) findViewById(R.id.dueDatelbl_add_activity);
        nameLayout=(LinearLayout) findViewById(R.id.nameline_add_activity);
        typeLayout=(LinearLayout) findViewById(R.id.typeline_add_activity);
        bankLayout=(LinearLayout) findViewById(R.id.bankline_add_activity);
        currentLayout=(LinearLayout) findViewById(R.id.currentline_add_activity);
        availabeLayout=(LinearLayout) findViewById(R.id.availableline_add_activity);
        interestLayout=(LinearLayout) findViewById(R.id.interestline_add_activity);
        limitLayout=(LinearLayout) findViewById(R.id.limitline_add_activity);
        dueDateLayout=(LinearLayout) findViewById(R.id.duedateline_add_activity);
        nameEditText=(EditText) findViewById(R.id.nameEditText_add_account);
        typeSpinner=(Spinner) findViewById(R.id.typeSpinner_add_account);
        bankEditText=(EditText) findViewById(R.id.bankEditText_add_account);
        currentEditText=(EditText) findViewById(R.id.currentAmount_add_account);
        availabeEditText=(EditText) findViewById(R.id.availableEditText_add_activity);
        interestEditText=(EditText) findViewById(R.id.interestEditText_add_account);
        limitEditText=(EditText) findViewById(R.id.limitEditText_add_activity);
        dueDateButton=(Button) findViewById(R.id.pickDateButton_add_activity);
        viewTransactionButton = (Button) findViewById(R.id.viewTransactionsButton_add_account);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , Model.accountManager.getAccountTypes());
        typeSpinner.setAdapter(adapter);
        currentTextView.setText(getString(R.string.current)+": $");
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = Model.accountManager.getTypeStringFromInt(position);
                switch(type){
                    case "Savings":newAccount = new SavingsAccount();
                        break;
                    case "Checking": newAccount = new CheckingAccount();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            public void datePickerClick(View v){
                dueDateButton = (Button) v;
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });
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
        getMenuInflater().inflate(R.menu.menu_add_account, menu);
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

    public void accountTransactionButton(View v){
        final Intent addTransactionIntent = new Intent(this, listactivity.class);
        if(selectedAccount!= null){
            Model.listType = "Transactions";
            Model.accountTransactionsToView = selectedAccount.getId();
            startActivity(addTransactionIntent);

        }
    }

    public void accountDeleteClick(View v){
        if(Model.Editing>-1){
            Model.accountManager.removeAccount(Model.Editing);
            ArrayList<Transaction> transactionArrayList = Model.transactionManager.getTransactionHistory();

            for(Transaction t: transactionArrayList){
                if(t.getAccountID()==Model.Editing){
                    Model.transactionManager.removeTransaction(t.getTransactionID());
                }
            }
        }
        finish();
    }

    public void accountSaveClick(View v){

            if (Model.Editing >-1) {

                newAccount.addAccountWithTransactions(selectedAccount.getTransactions());
                Model.accountManager.replaceAccount(newAccount, Model.Editing);
            } else {
                newAccount.addAccount();
                Model.accountManager.addAccount(newAccount);
            }
            Model.Editing=-1;
            finish();
    }

    public static String getBankEditText() {
        return bankEditText.getText().toString();
    }

    public static void setBankEditText(String bankEditText) {
        AddAccount.bankEditText.setText( bankEditText);
    }

    public static String getNameEditText() {
        return nameEditText.getText().toString();
    }

    public static void setNameEditText(String nameEditText) {
        AddAccount.nameEditText.setText( nameEditText);
    }

    public static String getCurrentEditText() {
        return currentEditText.getText().toString();
    }

    public static void setCurrentEditText(String currentEditText) {
        AddAccount.currentEditText.setText(currentEditText);
    }

    public static int getCurrentTypePosition() {
        return typeSpinner.getSelectedItemPosition();
    }

    public static void setCurrentTypePosition(int currentTypePosition) {
        typeSpinner.setSelection(currentTypePosition);
    }
}
