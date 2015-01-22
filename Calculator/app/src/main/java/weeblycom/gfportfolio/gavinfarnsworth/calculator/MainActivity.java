package weeblycom.gfportfolio.gavinfarnsworth.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    public TextView mainTextView;
    public TextView historyTextView;
    public Button clearButton;
    public String mainText;
    public String historyText;
    public List<String> mainTextStrings;
    public List<String> historyList;
    public String[] orderOfOps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = (TextView) findViewById(R.id.maintextview);
        historyTextView = (TextView) findViewById(R.id.historytextview);
        clearButton = (Button) findViewById(R.id.btnclear);
        mainText = "";
        historyText = "";
        mainTextStrings= Collections.emptyList();
        historyList = Collections.emptyList();
        mainTextView.setText(mainText);
        historyTextView.setText(historyText);

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
    public void clickFunctionButton(View v){
        Button clickedButton = (Button)v;
        String buttonText = clickedButton.getText().toString().toLowerCase();
        if(buttonText.contains("x")){
           buttonText = buttonText.replace("x","");
        }
        mainText+=" "+buttonText+" ";
        mainTextView.setText(mainText);
        clearButton.setText(R.string.backspace);


    }
    public void clickNumberButton(View v){
        Button clickedButton = (Button)v;
        mainText+=clickedButton.getText();
        mainTextView.setText(mainText);
        clearButton.setText(R.string.backspace);
    }

    public void clickSpecialButton(View v){
        Button clickedButton = (Button)v;
        switch(clickedButton.getText().toString()){
            case"CE":clickedCE(clickedButton);
                break;
            case"AC":clickedAC(clickedButton);
                break;
            case"=":clickedEqual(clickedButton);
                break;
            case".":clickedPeriod(clickedButton);
                break;
               }


        mainTextView.setText(mainText);

    }
    private void clickedCE(Button clickedButton){
        mainText="";
        clearButton.setText(R.string.clearall);
    }
    private void clickedAC(Button clickedButton){
        mainText="";
    }
    private void clickedPeriod(Button clickedButton){
        if(!mainText.contains(".")){
            mainText+=clickedButton.getText();
        }
    }
    private void clickedEqual(Button clickedButton){
        //mainText="";
    }

}
