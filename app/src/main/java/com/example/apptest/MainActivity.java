package com.example.apptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFinal, textViewEstimate;
    private boolean isOperationChosen = false;
    private boolean isDouble = false;
    private boolean isClearClicked = false;
    private int operation = 0;
    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        assignAllIds();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


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
                if (tvFinal.length() == 1) {
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

            case "=":
                isClearClicked = false;
                calculate(true);
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
        } else {
            textViewEstimate.setText(resultStr);
        }
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