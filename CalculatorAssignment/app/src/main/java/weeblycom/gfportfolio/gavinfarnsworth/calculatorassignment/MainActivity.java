package weeblycom.gfportfolio.gavinfarnsworth.calculatorassignment;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mathexpressioncalculator.Calculator;


public class MainActivity extends ActionBarActivity {
    public TextView mainTextView;
    public TextView historyTextView;
    public Button clearButton;
    public String mainText;
    public String historyText;
    public List<String> mainTextStrings;
    public ArrayList<String> historyList;
    private CalculatorModel calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = (TextView) findViewById(R.id.maintextview);
        historyTextView = (TextView) findViewById(R.id.historytextview);
        clearButton = (Button) findViewById(R.id.btnclear);

        mainTextView.setText(mainText);
        historyTextView.setText(historyText);
        calc = new CalculatorModel();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void clickFunctionButton(View v){
        Button clickedButton = (Button)v;
        mainTextView.setText(calc.functionButton(clickedButton.getText().toString()));
        clearButton.setText(R.string.backspace);


    }
    public void clickNumberButton(View v){
        Button clickedButton = (Button)v;
        mainTextView.setText(calc.numberButton(clickedButton.getText().toString()));
        clearButton.setText(R.string.backspace);
    }

    public void clickSpecialButton(View v){
        String newText = "";
        Button clickedButton = (Button)v;
        switch(clickedButton.getText().toString()){
            case"CE":newText=calc.clickedCE(clickedButton);
                break;
            case"AC":newText = calc.clickedAC(clickedButton);
                break;
            case"=":newText = clickedEqual(clickedButton);
                break;
            case".":newText = calc.clickedPeriod(clickedButton);
                break;
        }


        mainTextView.setText(newText);

    }

    private String clickedEqual(Button clickedButton) {
        String r = calc.clickedEqual(clickedButton);
        historyTextView.setText(calc.historyText);
        return r;
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
