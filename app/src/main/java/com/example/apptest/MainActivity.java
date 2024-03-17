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

        switch (buttonText) {
            case "0":
                isClearClicked = false;
                if (isOperationChosen) {
                    String s = "0";
                    textViewFinal.setText(s);
                    isOperationChosen = false;
                    break;
                }
                if (!tvFinal.equals("0") && !tvFinal.equals("-0")) {
                    String newText = tvFinal + "0";
                    textViewFinal.setText(newText);
                }
                break;
            case "1":
                operateNumButton(buttonText, "1");
                break;
            case "2":
                operateNumButton(buttonText, "2");
                break;
            case "3":
                operateNumButton(buttonText, "3");
                break;
            case "4":
                operateNumButton(buttonText, "4");
                break;
            case "5":
                operateNumButton(buttonText, "5");
                break;
            case "6":
                operateNumButton(buttonText, "6");
                break;
            case "7":
                operateNumButton(buttonText, "7");
                break;
            case "8":
                operateNumButton(buttonText, "8");
                break;
            case "9":
                operateNumButton(buttonText, "9");
                break;
        }
        String s;
        switch (buttonText) {
            case "AC":
                textViewEstimate.setText("");
                textViewFinal.setText("0");
                break;

            case "C":
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
                } else {
                    s = tvFinal.substring(0, tvFinal.length()-1);
                    textViewFinal.setText(s);
                }
                break;
        }

        switch (buttonText) {
            case "/":
                isClearClicked = false;
                operation = DIV;
                if (textViewEstimate.getText().toString().isEmpty()) {
                    textViewEstimate.setText(tvFinal);
                } else if (!isOperationChosen) {
                    calculate(false);
                }

                isOperationChosen = true;
                break;

            case "*":
                isClearClicked = false;
                operation = MUL;
                if (textViewEstimate.getText().toString().isEmpty()) {
                    textViewEstimate.setText(tvFinal);
                } else if (!isOperationChosen) {
                    calculate(false);
                }

                isOperationChosen = true;
                break;

            case "-":
                isClearClicked = false;
                operation = SUB;
                if (textViewEstimate.getText().toString().isEmpty()) {
                    textViewEstimate.setText(tvFinal);
                } else if (!isOperationChosen) {
                    calculate(false);
                }

                isOperationChosen = true;
                break;

            case "+":
                isClearClicked = false;
                operation = ADD;
                if (textViewEstimate.getText().toString().isEmpty()) {
                    textViewEstimate.setText(tvFinal);
                } else if (!isOperationChosen) {
                    calculate(false);
                }

                isOperationChosen = true;
                break;

            case "=":
                isClearClicked = false;
                calculate(true);
                break;
        }
    }

    public void calculate(boolean isFinished) {
//        if (!isOperationChosen) return;

        String est = textViewEstimate.getText().toString();
        String fin = textViewFinal.getText().toString();

        Double estimated = Double.parseDouble(est);
        Double finalNumber = Double.parseDouble(fin);
        Double result = 0.0;

        switch (operation) {
            case DIV:
                if (finalNumber!=0.0)
                    result = estimated/finalNumber;
                break;

            case MUL:
                result = estimated*finalNumber;
                break;

            case ADD:
                result = estimated+finalNumber;
                break;

            case SUB:
                result = estimated-finalNumber;
                break;
        }
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

    public void operateNumButton(String buttonText, String digit) {
        isClearClicked = false;
        String tvFinal = textViewFinal.getText().toString();
        if (tvFinal.equals("0") || isOperationChosen) {
            textViewFinal.setText(digit);
            if (isOperationChosen) isOperationChosen = false;
        } else if (tvFinal.equals("-0")) {
            String s = "-" + digit;
            textViewFinal.setText(s);
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