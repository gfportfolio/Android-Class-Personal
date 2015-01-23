package weeblycom.gfportfolio.gavinfarnsworth.calculatorassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gavinfarnsworth on 1/22/15.
 */
public class Evaluator {
    private String equation;
    private ArrayList<String> parsedEquation;
    private List<String> orderOps;

    public Evaluator(String Equation){
        equation = Equation;
        equation = equation.replace("π", rounder(Math.PI));

        parsedEquation= new ArrayList<String>();
        parsedEquation.addAll(Arrays.asList(equation.split(" ")));
        if(parsedEquation.get(0).equals(" ")||parsedEquation.get(0).equals("")){
            parsedEquation.remove(0);
        }
        orderOps = new ArrayList<String>();
        orderOps.add("SIN");
        orderOps.add("COS");
        orderOps.add("TAN");
        orderOps.add("%");
        orderOps.add("÷");
        orderOps.add("×");
        orderOps.add("^2");
        orderOps.add("+");
        orderOps.add("-");
        orderOps.add("!");
        orderOps.add("LOG");
        orderOps.add("LN");
        orderOps.add("√");
    }
    public String evaluate(){
        boolean noError = true;
for(String e : orderOps){
    while((parsedEquation.contains(e) && noError==true)) {
        int location = parsedEquation.indexOf(e);
        noError =evaluateFunction(e, location);
    }
}
        if(parsedEquation.size()>1){
            return "ERROR";
        }
        return parsedEquation.get(0);



    }

    private boolean evaluateFunction(String equation,  int location) {
        switch (equation){
            case("SIN"):return sinFunction(location);
            case("COS"):return cosFunction(location);
            case("TAN"):return tanFunction(location);
            case("%"):return percentFunction(location);
            case("÷"):return divideFunction(location);
            case("×"):return multiplyFunction(location);
            case("^2"):return squareFunction(location);
            case("+"):return addFunction(location);
            case("-"):return subtractFunction(location);
            case("!"):return factorialFunction(location);
            case("LOG"):return logFunction(location);
            case("LN"):return naturalLogFunction(location);
            case("√"):return squarerootFunction(location);
        }
        
        
        
        return false;
    }
    private String rounder(double v) {
        v = Math.round(v*100.0)/100.0;
        return v+"";
    }
    private boolean sinFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.sin(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean cosFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.cos(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean tanFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.tan(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean percentFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location -1));
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = rounder((value)/100);
            parsedEquation.add(location-1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean divideFunction(int location) {
        try {
            double firstValue = Double.parseDouble(parsedEquation.get(location - 1));
            double secondValue = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location + 1);
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = "";
            if(secondValue==0){
                solution = "0";
            }
            else
            {
                solution = rounder(firstValue/secondValue);
            }
            parsedEquation.add(location - 1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean multiplyFunction(int location) {
        try {
            double firstValue = Double.parseDouble(parsedEquation.get(location - 1));
            double secondValue = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location + 1);
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = rounder(firstValue*secondValue);
            parsedEquation.add(location - 1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean squareFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location - 1));
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = rounder(Math.pow(value,2));
            parsedEquation.add(location-1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean addFunction(int location) {
        try {
            double firstValue = Double.parseDouble(parsedEquation.get(location - 1));
            double secondValue = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location + 1);
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = rounder(firstValue+secondValue);
            parsedEquation.add(location - 1, solution);

        }
        catch(Exception e){
            return false;
        }
    return true;

    }



    private boolean subtractFunction(int location) {
        try {
            double firstValue = Double.parseDouble(parsedEquation.get(location - 1));
            double secondValue = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location + 1);
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            String solution = rounder(firstValue-secondValue);
            parsedEquation.add(location - 1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean factorialFunction(int location) {
        try {
            int value = Integer.parseInt(parsedEquation.get(location -1));
            parsedEquation.remove(location);
            parsedEquation.remove(location-1);
            value = factorial(value);
            String solution = rounder((double)value);
            parsedEquation.add(location-1, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean logFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.log(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean naturalLogFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.log10(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    private boolean squarerootFunction(int location) {
        try {
            double value = Double.parseDouble(parsedEquation.get(location + 1));
            parsedEquation.remove(location+1);
            parsedEquation.remove(location);
            String solution = rounder(Math.sqrt(value));
            parsedEquation.add(location, solution);

        }
        catch(Exception e){
            return false;
        }
        return true;
    }
    public int factorial(int i){
        if(i == 1){
            return 1;
        }
        return i*factorial(i-1);
    }

}
