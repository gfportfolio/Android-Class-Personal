package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.content.Intent;
import android.graphics.Outline;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;


public class MainActivity extends ActionBarActivity {
    private TextView availableTextView;
    private TextView currentTextView;
    private ImageButton addTransactionButton;
    private Button transactionsButton;
    private Button accountsButton;
    private ListView accountsListView;
    private ListView transactionsListView;
    private static boolean hasInitiated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        availableTextView = (TextView) findViewById(R.id.availablelbl_main);
        currentTextView = (TextView) findViewById(R.id.currentlbl_main);
        addTransactionButton = (ImageButton) findViewById(R.id.addTransactionButton_main);
        transactionsButton = (Button) findViewById(R.id.transactionsButton_main);
        accountsButton = (Button) findViewById(R.id.accountsButton_main);
        accountsListView = (ListView) findViewById(R.id.accountListView_main);
        transactionsListView = (ListView) findViewById(R.id.transactionListView_main);

        if(!hasInitiated) {
            Model.initiate();
        }
        setupView();
    }

    private void setupView(){
        double totalMoney = Model.accountManager.sumAllAccounts();
        availableTextView.setText(getString(R.string.available)+": $"+ totalMoney);



        final Intent addTransactionIntent = new Intent(this, AddTransaction.class);
        final Intent addAccountIntent = new Intent(this, AddAccount.class);
        accountsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Model.Editing=position;
            }
        });

        transactionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Model.Editing=position;
            }
        });
        ArrayList<String> accounts = new ArrayList<String>() ;
        ArrayList<String> transactions = new ArrayList<String>() ;
        for(Account a : Model.accountManager.getCurrentAccounts()){
            accounts.add(a.getName()+"\t\t\t$"+a.getCurrentBalance());
        }
        for(Transaction t: Model.transactionManager.getTransactionHistory()){
            transactions.add(t.getName()+"\t\t\t$"+t.getCost());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , accounts);
        accountsListView.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , transactions);
        transactionsListView.setAdapter(adapter2);
    }

    public void onResume(){
        super.onResume();
        setupView();

    }
    public void addTransactionClick(View v) {
        Model.Editing=-1;
        Intent intent = new Intent(this, AddTransaction.class);
        startActivity(intent);
    }
    public void clickAccountButton(View v){
        Button current = (Button)v;
        if(current.getText().equals(getString(R.string.accounts))){
            Model.listType="Accounts";
        }
        else{
            Model.listType="Transactions";
        }
        Intent intent = new Intent(this, listactivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
