package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;
import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Transactions.Transaction;


public class listactivity extends ActionBarActivity {
    public ListView listView;
    public TextView title;
    public ImageButton addButton;
    private Intent currentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generalSetup();

    }

    public void onResume(){
        super.onResume();
        generalSetup();

    }

    public void onHomeClick(View v){
        //finish();
        final Intent main =new Intent(this, MainActivity.class);
        startActivity(main);
    }

    public void generalSetup(){
        setContentView(R.layout.activity_listactivity);
        listView = (ListView) findViewById(R.id.list_listactivity);
        title = (TextView) findViewById(R.id.title_list);
        addButton = (ImageButton) findViewById(R.id.addTransactionButton_list);
        final Intent addTransactionIntent =new Intent(this, AddTransaction.class);
        currentIntent = addTransactionIntent;
        final Intent addAccountIntent =new Intent(this, AddAccount.class);


        if(Model.listType.equals("Accounts")){
            setUpAccountPage(addAccountIntent);

        }
        else if(Model.listType.equals("Transactions")){
            setUpTransactionPage();

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Model.Editing = position;
                if(Model.listType.equals("Accounts")) {
                    startActivity(addAccountIntent);
                }
                else if(Model.listType.equals("Transactions")){
                   startActivity(addTransactionIntent);
                }

            }
        });


    }
    public void setUpAccountPage(Intent addAccountIntent){
        ArrayList<String> accounts = new ArrayList<String>() ;

        for(Account a : Model.accountManager.getCurrentAccounts()){
            accounts.add(a.getName()+"\t\t\t$"+a.getCurrentBalance());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , accounts);
        listView.setAdapter(adapter);
        title.setText(getString(R.string.account)+" "+getString(R.string.list));
        currentIntent=addAccountIntent;
    }
    public void setUpTransactionPage(){
        ArrayList<String> transactions = new ArrayList<String>() ;
        if(Model.accountTransactionsToView>=0){
            addButton.setVisibility(View.INVISIBLE);
            for(Transaction t: Model.accountManager.getCurrentAccounts().get(Model.accountTransactionsToView).getTransactions()){
                transactions.add(t.getName() + "\t\t\t$" + t.getCost());
            }
        }
        else{
        for(Transaction t: Model.transactionManager.getTransactionHistory()) {
            transactions.add(t.getName() + "\t\t\t$" + t.getCost());
        }
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , transactions);
        listView.setAdapter(adapter2);
        title.setText(getString(R.string.transactions)+" "+getString(R.string.list));
    }

    public void listAddClick(View v){
        Intent intent;
        Model.Editing=-1;
        intent = new Intent(this, AddTransaction.class);

        if(Model.listType.equals("Accounts")){
                intent = new Intent(this, AddAccount.class);
            }
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listactivity, menu);
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
