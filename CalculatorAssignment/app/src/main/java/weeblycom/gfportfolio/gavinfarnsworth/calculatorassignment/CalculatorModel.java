package weeblycom.gfportfolio.gavinfarnsworth.calculatorassignment;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mathexpressioncalculator.Calculator;

/**
 * Created by gavinfarnsworth on 1/22/15.
 */
public class CalculatorModel {
    public TextView mainTextView;
    public TextView historyTextView;
    public Button clearButton;
    public String mainText;
    public String historyText;
    public ArrayList<String> mainTextStrings;
    public ArrayList<String> historyList;
    boolean lastButtonEquals;
    public ArrayList<String> answerFunctions;


public CalculatorModel(){
    mainText = "";
    historyText = "";
    mainTextStrings= new ArrayList<String>();
    historyList = new ArrayList<String>();
    lastButtonEquals = false;
    answerFunctions = new ArrayList<String>();
    answerFunctions.add("%");
    answerFunctions.add("÷");
    answerFunctions.add("×");
    answerFunctions.add("^2");
    answerFunctions.add("+");
    answerFunctions.add("-");
    answerFunctions.add("!");
}

    public String numberButton(String buttonText){
        if(lastButtonEquals) {
            historyText = mainText;
            mainText=buttonText;
            lastButtonEquals = false;

        }
        else{
            mainText+=buttonText;
        }
        return mainText;
    }
    public String functionButton(String buttonText){
        if(buttonText.contains("x")){
            buttonText = buttonText.replace("x","");
        }
        if(lastButtonEquals) {
            historyText = mainText;
            String beginingspace=" ";
            if(answerFunctions.contains(buttonText)&&!historyText.equals("ERROR")){
                beginingspace="ANS ";
            }
            mainText = beginingspace + buttonText + " ";
            lastButtonEquals = false;
        }
        else{
            mainText += " " + buttonText + " ";
        }
        return mainText;
    }
    public String clickedCE(Button clickedButton){
        if(mainText.length()>1) {
            mainText = mainText.substring(0, mainText.length() - 1);
        }
        else if(mainText.length()==1){
            mainText = " ";
        }
        return mainText;
    }
    public String clickedAC(Button clickedButton){
        if(!historyText.equals("")){
            historyList.add(historyText);
        }
        historyText = mainText;
        mainText="";
        lastButtonEquals = false;
        return mainText;
    }
    public String clickedPeriod(Button clickedButton){
        if(lastButtonEquals) {
            historyText = mainText;
            mainText=clickedButton.getText().toString();
            lastButtonEquals = false;
        }
        else{
            if(!mainText.contains(".")){
                mainText+=clickedButton.getText().toString();
            }
        }
        if(!mainText.contains(".")){
            mainText+=clickedButton.getText();
        }
        return mainText;
    }
    public String clickedEqual(Button clickedButton){
        lastButtonEquals = true;
        String equationString = mainText;
        equationString = equationString.replace("ANS", historyText);
        equationString=equationString.replace("  "," ");
        if(!historyText.equals("")){
            historyList.add(historyText);
        }
        historyText = mainText;
        try{
            //double result = calculator.getResult();
            Evaluator evaluator = new Evaluator(equationString);
            String result = evaluator.evaluate();
            mainText = result+"";
        }
        catch(Exception e){
            mainText = "ERROR";
        }


        return mainText;
    }


}
