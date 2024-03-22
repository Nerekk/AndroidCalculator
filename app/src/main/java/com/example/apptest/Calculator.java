package com.example.apptest;

import static com.example.apptest.Constants.ADD;
import static com.example.apptest.Constants.SUB;
import static com.example.apptest.Constants.DIV;
import static com.example.apptest.Constants.MUL;
import static com.example.apptest.Constants.PERC;
import static com.example.apptest.Constants.POW2;
import static com.example.apptest.Constants.POWY;
import static com.example.apptest.Constants.SQRT;
import static com.example.apptest.Constants.LOG;
import static com.example.apptest.Constants.LN;
import static com.example.apptest.Constants.SIN;
import static com.example.apptest.Constants.COS;
import static com.example.apptest.Constants.TG;


import android.widget.Button;
import android.widget.TextView;

public class Calculator {
    private TextView textViewFinal, textViewEstimate;
    private boolean isOperationChosen;
    private boolean isDouble;
    private boolean isClearClicked;
    private int operation;
    private int advOperation;

    public Calculator(TextView textViewFinal, TextView textViewEstimate) {
        this.textViewFinal = textViewFinal;
        this.textViewEstimate = textViewEstimate;
        this.isOperationChosen = false;
        this.isDouble = false;
        this.isClearClicked = false;
        this.operation = 0;
        this.advOperation = 0;
    }

    public void restoreCalculator(TextView textViewFinal,
                                  TextView textViewEstimate,
                                  boolean iOC,
                                  boolean iD,
                                  boolean iCC,
                                  int op) {
        setTextViewFinal(textViewFinal);
        setTextViewEstimate(textViewEstimate);
        setOperationChosen(iOC);
        setDouble(iD);
        setClearClicked(iCC);
        setOperation(op);
    }

    public TextView getTextViewFinal() {
        return textViewFinal;
    }

    public void setTextViewFinal(TextView textViewFinal) {
        this.textViewFinal = textViewFinal;
    }

    public TextView getTextViewEstimate() {
        return textViewEstimate;
    }

    public void setTextViewEstimate(TextView textViewEstimate) {
        this.textViewEstimate = textViewEstimate;
    }

    public boolean isOperationChosen() {
        return isOperationChosen;
    }

    public void setOperationChosen(boolean operationChosen) {
        isOperationChosen = operationChosen;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDouble(boolean aDouble) {
        isDouble = aDouble;
    }

    public boolean isClearClicked() {
        return isClearClicked;
    }

    public void setClearClicked(boolean clearClicked) {
        isClearClicked = clearClicked;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void operateButton(Button button) {
        String buttonText = button.getText().toString();
        String tvFinal = textViewFinal.getText().toString();
        String s;

        switch (buttonText) {
            case "0":
                isClearClicked = false;
                if (isOperationChosen) {
                    s = "0";
                    textViewFinal.setText(s);
                    isOperationChosen = false;
                    isDouble = false;
                    break;
                }
                if (!tvFinal.equals("0") && !tvFinal.equals("-0")) {
                    s = tvFinal + "0";
                    textViewFinal.setText(s);
                }
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                operateNumButton(buttonText);
                break;
        }

        switch (buttonText) {
            case "AC":
                isDouble = false;
                textViewEstimate.setText("");
                textViewFinal.setText("0");
                break;

            case "C":
                isDouble = false;
                if (isClearClicked) {
                    textViewEstimate.setText("");
                }
                textViewFinal.setText("0");
                isClearClicked = true;
                break;

            case ".":
                isClearClicked = false;
                if (!isDouble) {
                    String finalDot = tvFinal + ".";
                    textViewFinal.setText(finalDot);
                    isDouble = true;
                } else if (tvFinal.endsWith(".")) {
                    s = tvFinal.substring(0, tvFinal.length()-1);
                    textViewFinal.setText(s);
                    isDouble = false;
                }
                break;

            case "+/-":
                isClearClicked = false;
                if (tvFinal.equals("0")) {
                    break;
                } else if (tvFinal.startsWith("-")) {
                    s = tvFinal.substring(1);
                } else {
                    s = "-" + tvFinal;
                }
                textViewFinal.setText(s);
                break;

            case "":
                isClearClicked = false;
                if (tvFinal.length() == 1 || isOperationChosen) {
                    textViewFinal.setText("0");
                    isDouble = false;
                } else {
                    int len = tvFinal.length();
                    if (tvFinal.charAt(len-1) == '.') isDouble = false;

                    s = tvFinal.substring(0, tvFinal.length()-1);
                    textViewFinal.setText(s);
                }
                break;
        }

        switch (buttonText) {
            case "/":
                operation = DIV;
                handleOperator(tvFinal);
                break;

            case "*":
                operation = MUL;
                handleOperator(tvFinal);
                break;

            case "-":
                operation = SUB;
                handleOperator(tvFinal);
                break;

            case "+":
                operation = ADD;
                handleOperator(tvFinal);
                break;

            case "xy":
                operation = POWY;
                handleOperator(tvFinal);
                break;

            case "=":
                isClearClicked = false;
                calculate(true);
                break;
        }

        switch (buttonText) {
            case "√x":
                advOperation = SQRT;
                advCalculate();
                break;
            case "x²":
                advOperation = POW2;
                advCalculate();
                break;
            case "%":
                advOperation = PERC;
                advCalculate();
                break;
            case "log":
                advOperation = LOG;
                advCalculate();
                break;
            case "ln":
                advOperation = LN;
                advCalculate();
                break;
            case "sin":
                advOperation = SIN;
                advCalculate();
                break;
            case "cos":
                advOperation = COS;
                advCalculate();
                break;
            case "tg":
                advOperation = TG;
                advCalculate();
                break;
        }
    }

    private void handleOperator(String tvFinal) {
        isClearClicked = false;
        if (textViewEstimate.getText().toString().isEmpty() || textViewEstimate.getText().toString().equals("Error")) {
            textViewEstimate.setText(tvFinal);
        } else if (!isOperationChosen) {
            calculate(false);
        }
        isOperationChosen = true;
    }

    public void advCalculate() {
        isClearClicked = false;
        String est = textViewEstimate.getText().toString();
        String fin = textViewFinal.getText().toString();

        Double estimated = 0.0;
        if (!est.isEmpty()) {
            estimated = Double.parseDouble(est);
        }

        Double finalNumber = Double.parseDouble(fin);
        Double result = 0.0;
        result = getAdvResult(finalNumber, estimated, result);
        String resultStr = result.toString();
        if (resultStr.endsWith(".0")) {
            resultStr = resultStr.substring(0, resultStr.length()-2);
        }
        textViewFinal.setText(resultStr);

        isOperationChosen = true;
        isDouble = true;
        advOperation=0;
    }

    public void calculate(boolean isFinished) {
        String est = textViewEstimate.getText().toString();
        if (est.isEmpty()) return;
        String fin = textViewFinal.getText().toString();

        Double estimated = Double.parseDouble(est);
        Double finalNumber = Double.parseDouble(fin);
        Double result = 0.0;

        result = getResult(finalNumber, estimated, result);

        if (finalNumber==0.0 && operation == DIV) {
            String err = "Error";
            textViewEstimate.setText(err);
            return;
        }

        String resultStr = result.toString();
        if (resultStr.endsWith(".0")) {
            resultStr = resultStr.substring(0, resultStr.length()-2);
        }
        textViewFinal.setText(resultStr);

        if (isFinished) {
            textViewEstimate.setText("");
            isOperationChosen = true;
            isDouble = true;
        } else {
            textViewEstimate.setText(resultStr);
        }
    }

    private Double getAdvResult(Double finalNumber, Double estimated, Double result) {
        switch (advOperation) {
            case PERC:
                if (operation==ADD || operation==SUB)
                    result = (estimated * (finalNumber/100));
                if (operation==MUL || operation==DIV)
                    result = (finalNumber/100);
                break;

            case POW2:
                result = Math.pow(finalNumber, 2);
                break;

            case SQRT:
                result = Math.sqrt(finalNumber);
                break;

            case LOG:
                result = Math.log10(finalNumber);
                break;

            case LN:
                result = Math.log(finalNumber);
                break;

            case SIN:
                result = Math.sin(Math.toRadians(finalNumber));
                break;

            case COS:
                result = Math.cos(Math.toRadians(finalNumber));
                break;

            case TG:
                result = Math.tan(Math.toRadians(finalNumber));
                break;
        }
        return result;
    }

    private Double getResult(Double finalNumber, Double estimated, Double result) {
        switch (operation) {
            case DIV:
                if (finalNumber !=0.0)
                    result = estimated / finalNumber;
                break;

            case MUL:
                result = estimated * finalNumber;
                break;

            case ADD:
                result = estimated + finalNumber;
                break;

            case SUB:
                result = estimated - finalNumber;
                break;

            case POWY:
                result = Math.pow(estimated, finalNumber);
                break;
        }
        return result;
    }

    public void operateNumButton(String digit) {
        isClearClicked = false;
        String tvFinal = textViewFinal.getText().toString();
        if (tvFinal.equals("0") || isOperationChosen) {
            textViewFinal.setText(digit);
            isDouble = false;
            if (isOperationChosen) isOperationChosen = false;
        } else if (tvFinal.equals("-0")) {
            String s = "-" + digit;
            textViewFinal.setText(s);
            isDouble = false;
        } else {
            String newText = tvFinal + digit;
            textViewFinal.setText(newText);
        }
    }
}
