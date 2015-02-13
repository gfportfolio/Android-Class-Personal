package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static weeblycom.gfportfolio.gavinfarnsworth.wandshop.R.drawable.sorcerermickeyhat;


public class MainActivity extends ActionBarActivity {
    private TextView brandTextView;
    private TextView maxTextView;
    private TextView chargeTextView;
    private TextView powerTextView;
    private ImageView powerImageView;

    //private WandManager wandManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        globals.wandManager = new WandManager();
        brandTextView = (TextView)findViewById(R.id.brandTextView);
        maxTextView = (TextView)findViewById(R.id.maxTextView);
        chargeTextView = (TextView)findViewById(R.id.chargeTextView);
        powerTextView = (TextView)findViewById(R.id.powerTextView);
        powerImageView = (ImageView)findViewById(R.id.powerImageView);


        setCurrentDetails(globals.wandManager.getCurrentWond());


        //Remove if can pass
        globals.wandOptions= new ArrayList<WandImage>();
        globals.wandOptions.addAll(globals.wandManager.getWandOptions());

    }

    public void onAddClick(View v){
        Intent i = new Intent(getApplicationContext(), Edit.class);
        globals.editing=false;
        startActivity(i);
    }

    public void onNextClick(View v){
        MagicWand currentWand = globals.wandManager.changeWond(true);
        setCurrentDetails(currentWand);
    }

    public void onPreviousClick(View v){
        MagicWand currentWand = globals.wandManager.changeWond(false);
        setCurrentDetails(currentWand);
    }

    public void onEditClick(View v){
        Intent i = new Intent(getApplicationContext(), Edit.class);
        globals.editingWand=globals.wandManager.getCurrentWond();
        globals.editing=true;
        startActivity(i);
    }

    @Override
    protected  void onResume(){
        super.onResume();
        setCurrentDetails(globals.wandManager.getCurrentWond());
    }

    private void setCurrentDetails(MagicWand magicWand){
          brandTextView.setText(magicWand.getBrand());
          maxTextView.setText(getString(R.string.max)+" "+magicWand.getMaxMagicPoints());
          float max = magicWand.getMaxMagicPoints();
          float charge = magicWand.getCurrentMagicCharge();
          float percent = (charge/max)*100;
          percent = Math.round(percent);
          chargeTextView.setText(getString(R.string.charge)+" "+magicWand.getCurrentMagicCharge()+" ("+percent+"%)");
          powerTextView.setText(getString(R.string.core)+" "+magicWand.getImage().getName());
          powerImageView.setImageResource(magicWand.getImage().getImageResourceNumber());
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
