package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Calendar;


public class AddTransaction extends ActionBarActivity {
    private EditText locationEditText;
    private EditText amountEditText;
    private Spinner accountSpinner;
    private Button paidDateButton;
    private Button dueDateButton;
    private ImageButton deleteButton;
    private ImageButton saveButton;

    public static Button lastPickDateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        locationEditText =(EditText) findViewById(R.id.location_add_trans);
        amountEditText =(EditText) findViewById(R.id.amount_add_trans);
        accountSpinner = (Spinner) findViewById(R.id.accountSpinner_add_tran);
        paidDateButton = (Button) findViewById(R.id.payDatePick_add_trans);
        dueDateButton = (Button) findViewById(R.id.dueDatePick_add_trans);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton_add_trans);
        saveButton = (ImageButton) findViewById(R.id.saveButton_add_trans);
    }

    public void datePickerClick(View v){
        lastPickDateButton = (Button) v;
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void deleteClick(View v){

    }

    public void saveClick(View v){

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
            AddTransaction.lastPickDateButton.setText(month+"/"+day+"/"+year);
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
