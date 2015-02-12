package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Edit extends ActionBarActivity {
    private EditText brandEditText;
    private ExpandableListView powerView;
    private TextView maxTextView;
    private TextView chargeTextView;
    private SeekBar maxPowerSlider;
    private SeekBar chargePowerSlider;
    private Spinner powerSpinner;
    private boolean edit;
    private ImageView powerImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        maxPowerSlider = (SeekBar) findViewById(R.id.maxPowerSlider);
        chargePowerSlider = (SeekBar) findViewById(R.id.chargeSlider);
        chargeTextView = (TextView) findViewById(R.id.editChargeTextView);
        maxTextView = (TextView) findViewById(R.id.editMaxChargeTextView);
        brandEditText = (EditText) findViewById(R.id.brandEditText);
        powerSpinner =(Spinner) findViewById(R.id.powerSpinner);
        powerImage = (ImageView) findViewById(R.id.powerImageView);
        setupSeekListeners();
        updatePowerValues();
        List<String> powersList = new ArrayList<String>();
        for(WandImage wand : globals.wandManager.getWandOptions()){
            powersList.add(wand.getName());
        }
        powerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, powersList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        powerSpinner.setAdapter(dataAdapter);



    }
    private int updatePowerValues(){
        int maxPowerSliderValue = maxPowerSlider.getProgress();
        maxTextView.setText(getString(R.string.max)+" "+maxPowerSliderValue+" "+getString(R.string.mp));
        int chargePowerSliderValue = chargePowerSlider.getProgress();
        int Charge=0;
        if(chargePowerSliderValue>0) {
            double percent = chargePowerSliderValue;
            percent = percent/100;
            float charge = (float) (percent * maxPowerSliderValue);
            Charge= Math.round(charge);
        }
        chargeTextView.setText(getString(R.string.charge)+" "+Charge+" "+getString(R.string.mp)+" ("+chargePowerSliderValue+"%)");
        return Charge;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    private void setupSeekListeners(){
        maxPowerSlider.setMax(10000);
        chargePowerSlider.setMax(100);
        maxPowerSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatePowerValues();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        chargePowerSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatePowerValues();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void onDeleteClick(View v){

    }
    private void onAddClick(View v){

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

