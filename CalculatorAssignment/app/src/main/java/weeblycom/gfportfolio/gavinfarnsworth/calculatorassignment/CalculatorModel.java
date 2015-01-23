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

public CalculatorModel(){
    mainText = "";
    historyText = "";
    mainTextStrings= new ArrayList<String>();
    historyList = new ArrayList<String>();
}

    public String numberButton(String buttonText){
        mainText+=buttonText;
        return mainText;
    }
    public String functionButton(String buttonText){
        if(buttonText.contains("x")){
            buttonText = buttonText.replace("x","");
        }
        mainText+=" "+buttonText+" ";
        return mainText;
    }
    public String clickedCE(Button clickedButton){
        mainText="";
        return mainText;
    }
    public String clickedAC(Button clickedButton){
        mainText="";
        return mainText;
    }
    public String clickedPeriod(Button clickedButton){
        if(!mainText.contains(".")){
            mainText+=clickedButton.getText();
        }
        return mainText;
    }
    public String clickedEqual(Button clickedButton){

        Calculator calculator = new Calculator();
        String equationString = equationStringChanger(mainText);
        equationString.replace("ANS", historyText);
        calculator.setExpression(equationString);
        if(!historyText.equals("")){
            historyList.add(historyText);
        }
        historyText = mainText;
        try{
            //double result = calculator.getResult();
            Evaluator evaluator = new Evaluator(mainText);
            String result = evaluator.evaluate();
            mainText = result+"";
        }
        catch(Exception e){
            mainText = "ERROR";
        }


        return mainText;
    }
    private String equationStringChanger(String equation) {
        if(!historyText.equals("")){
            equation = equation.replaceAll("ans",historyText);
        }
        equation = equation.toLowerCase();
        equation = equation.replaceAll("×","*");
        equation = equation.replaceAll("÷","/");
        equation = equation.replaceAll("π","PI");
        equation = equation.replaceAll("SIN","sin");
        equation = equation.replaceAll("COS","cos");
        equation = equation.replaceAll("TAN","tan");
        equation = equation.replaceAll(" ","");

        //equation = equation.replaceAll("×","*");
        return equation;
    }

}
