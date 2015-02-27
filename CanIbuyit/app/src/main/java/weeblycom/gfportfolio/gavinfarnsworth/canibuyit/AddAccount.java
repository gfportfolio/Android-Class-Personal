package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


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
    private EditText        nameEditText;
    private Spinner         typeSpinner;
    private EditText        bankEditText;
    private EditText        currentEditText;
    private EditText        availabeEditText;
    private EditText        interestEditText;
    private EditText        limitEditText;
    private Button          dueDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        setupInstanceVariables();
    }

    private void setupInstanceVariables(){
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , Model.accountManager.getAccountTypes());
        typeSpinner.setAdapter(adapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
}
