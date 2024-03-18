package com.example.apptest;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdvancedActivity extends AppCompatActivity {

    private TextView textViewFinal, textViewEstimate;
    private boolean isOperationChosen = false;
    private boolean isDouble = false;
    private boolean isClearClicked = false;
    private int operation = 0;
    private int advOperation = 0;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int MUL = 3;
    private static final int DIV = 4;
    private static final int PERC = 5;
    private static final int POW2 = 6;
    private static final int POWY = 7;
    private static final int SQRT = 8;
    private static final int LOG = 9;
    private static final int LN = 10;
    private static final int SIN = 11;
    private static final int COS = 12;
    private static final int TG = 13;




    private static final String TV_KEY = "TV_KEY";
    private static final String ICC_KEY = "ICC_KEY";
    private static final String ID_KEY = "ID_KEY";
    private static final String IOC_KEY = "IOC_KEY";
    private static final String OP_KEY = "OP_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advanced);
        assignAllIds();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        String[] parts = savedInstanceState.getStringArray(TV_KEY);

        textViewFinal.setText(parts[0]);
        textViewEstimate.setText(parts[1]);

        operation = savedInstanceState.getInt(OP_KEY);
        isClearClicked = savedInstanceState.getBoolean(ICC_KEY);
        isDouble = savedInstanceState.getBoolean(ID_KEY);
        isOperationChosen = savedInstanceState.getBoolean(IOC_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String[] parts = new String[2];
        parts[0] = textViewFinal.getText().toString();
        parts[1] = textViewEstimate.getText().toString();

        outState.putStringArray(TV_KEY, parts);
        outState.putInt(OP_KEY, operation);
        outState.putBoolean(ICC_KEY, isClearClicked);
        outState.putBoolean(ID_KEY, isDouble);
        outState.putBoolean(IOC_KEY, isOperationChosen);
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    public void handlePerc(View v) { operateButton((Button) v);}

    public void handleSqrt(View v) { operateButton((Button) v);}

    public void handleSin(View v) { operateButton((Button) v);}

    public void handleCos(View v) { operateButton((Button) v);}

    public void handleTg(View v) { operateButton((Button) v);}

    public void handlePow2(View v) { operateButton((Button) v);}

    public void handlePowy(View v) { operateButton((Button) v);}

    public void handleLog(View v) { operateButton((Button) v);}

    public void handleLn(View v) { operateButton((Button) v);}


    public void handleAC(View v) {
        operateButton((Button) v);
    }

    public void handleC(View v) {
        operateButton((Button) v);
    }

    public void handleBK(View v) {
        operateButton((Button) v);
    }

    public void handleCh(View v) {
        operateButton((Button) v);
    }

    public void handleDot(View v) {
        operateButton((Button) v);
    }

    public void handleDivide(View v) {
        operateButton((Button) v);
    }

    public void handleMultiply(View v) {
        operateButton((Button) v);
    }

    public void handleSub(View v) {
        operateButton((Button) v);
    }

    public void handleAdd(View v) {
        operateButton((Button) v);
    }

    public void handleEquals(View v) {
        operateButton((Button) v);
    }


    public void handleNum0(View v) {
        operateButton((Button) v);
    }

    public void handleNum1(View v) {
        operateButton((Button) v);
    }

    public void handleNum2(View v) {
        operateButton((Button) v);
    }

    public void handleNum3(View v) {
        operateButton((Button) v);
    }

    public void handleNum4(View v) {
        operateButton((Button) v);
    }

    public void handleNum5(View v) {
        operateButton((Button) v);
    }

    public void handleNum6(View v) {
        operateButton((Button) v);
    }

    public void handleNum7(View v) {
        operateButton((Button) v);
    }

    public void handleNum8(View v) {
        operateButton((Button) v);
    }

    public void handleNum9(View v) {
        operateButton((Button) v);
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
                operateNumButton("1");
                break;
            case "2":
                operateNumButton("2");
                break;
            case "3":
                operateNumButton("3");
                break;
            case "4":
                operateNumButton("4");
                break;
            case "5":
                operateNumButton("5");
                break;
            case "6":
                operateNumButton("6");
                break;
            case "7":
                operateNumButton("7");
                break;
            case "8":
                operateNumButton("8");
                break;
            case "9":
                operateNumButton("9");
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
                if (tvFinal.startsWith("-")) {
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
        textViewFinal.setText(resultStr);

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
        textViewFinal.setText(resultStr);
        if (isFinished) {
            textViewEstimate.setText("");
            isOperationChosen = true;
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

    public void assignAllIds() {
        textViewFinal = findViewById(R.id.textViewFinal);
        textViewEstimate = findViewById(R.id.textViewEstimate);
    }
}
