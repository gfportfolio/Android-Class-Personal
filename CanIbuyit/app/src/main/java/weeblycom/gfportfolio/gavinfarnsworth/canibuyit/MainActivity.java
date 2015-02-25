package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

import android.content.Intent;
import android.graphics.Outline;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.Test;


public class MainActivity extends ActionBarActivity {
    private TextView availableTextView;
    private TextView currentTextView;
    private ImageButton addTransactionButton;
    private Button transactionsButton;
    private Button accountsButton;
    private ListView accountsListView;
    private ListView transactionsListView;



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

    }

    public void addTransactionClick(View v){
        Intent intent = new Intent(this,AddTransaction.class);
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
