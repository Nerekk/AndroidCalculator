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
    private Button button0, button1, button2, button3, button4, button5, button6,
    button7, button8, button9, buttonAC, buttonC, buttonBK,buttonDivide, buttonMultiply,
    buttonAdd, buttonSub, buttonChange, buttonEquals, buttonComma;
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

        switch (buttonText) {
            case "0":
                if (!textViewFinal.getText().toString().equals("0")) {
                    String newText = textViewFinal.getText().toString() + "0";
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
    }

    private void operateNumButton(String buttonText, String digit) {
        if (textViewFinal.getText().toString().equals("0")) {
            textViewFinal.setText(digit);
        } else {
            String newText = textViewFinal.getText().toString() + digit;
            textViewFinal.setText(newText);
        }
    }

    public void assignAllIds() {
        textViewFinal = findViewById(R.id.textViewFinal);
        textViewEstimate = findViewById(R.id.textViewEstimate);

        assignButtonId(button0, R.id.button0);
        assignButtonId(button1, R.id.button1);
        assignButtonId(button2, R.id.button2);
        assignButtonId(button3, R.id.button3);
        assignButtonId(button4, R.id.button4);
        assignButtonId(button5, R.id.button5);
        assignButtonId(button6, R.id.button6);
        assignButtonId(button7, R.id.button7);
        assignButtonId(button8, R.id.button8);
        assignButtonId(button9, R.id.button9);

        assignButtonId(buttonAC, R.id.buttonAC);
        assignButtonId(buttonC, R.id.buttonC);
        assignButtonId(buttonBK, R.id.buttonBK);
        assignButtonId(buttonDivide, R.id.buttonDivide);
        assignButtonId(buttonMultiply, R.id.buttonMultiply);
        assignButtonId(buttonAdd, R.id.buttonAdd);
        assignButtonId(buttonSub, R.id.buttonSub);
        assignButtonId(buttonChange, R.id.buttonChange);
        assignButtonId(buttonEquals, R.id.buttonEquals);
        assignButtonId(buttonComma, R.id.buttonComma);

    }

    public void assignButtonId(Button button, int id) {
        button = findViewById(id);
    }
}