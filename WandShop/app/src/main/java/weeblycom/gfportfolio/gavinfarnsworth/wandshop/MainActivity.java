package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static weeblycom.gfportfolio.gavinfarnsworth.wandshop.R.drawable.sorcerermickeyhat;


public class MainActivity extends ActionBarActivity {
    private TextView brandTextView;
    private TextView maxTextView;
    private TextView chargeTextView;
    private TextView powerTextView;
    private ImageView powerImageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onAddClick(View v){

    }

    public void onNextClick(View v){

    }
    public void onPreviousClick(View v){

    }
    public void onEditClick(View v){

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
