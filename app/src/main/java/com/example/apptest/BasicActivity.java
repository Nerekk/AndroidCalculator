package com.example.apptest;

import static com.example.apptest.Constants.ICC_KEY;
import static com.example.apptest.Constants.ID_KEY;
import static com.example.apptest.Constants.IOC_KEY;
import static com.example.apptest.Constants.OP_KEY;
import static com.example.apptest.Constants.TV_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewFinal, textViewEstimate;
//    private boolean isOperationChosen = false;
//    private boolean isDouble = false;
//    private boolean isClearClicked = false;
//    private int operation = 0;
    private Calculator c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_basic);

        assignAllIds();
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        c = new Calculator(textViewFinal, textViewEstimate);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        String[] parts = savedInstanceState.getStringArray(TV_KEY);

        textViewFinal.setText(parts[0]);
        textViewEstimate.setText(parts[1]);

        c.restoreCalculator(
                textViewFinal,
                textViewEstimate,
                savedInstanceState.getBoolean(IOC_KEY),
                savedInstanceState.getBoolean(ID_KEY),
                savedInstanceState.getBoolean(ICC_KEY),
                savedInstanceState.getInt(OP_KEY)
        );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String[] parts = new String[2];
        parts[0] = textViewFinal.getText().toString();
        parts[1] = textViewEstimate.getText().toString();

        outState.putStringArray(TV_KEY, parts);
        outState.putInt(OP_KEY, c.getOperation());
        outState.putBoolean(ICC_KEY, c.isClearClicked());
        outState.putBoolean(ID_KEY, c.isDouble());
        outState.putBoolean(IOC_KEY, c.isOperationChosen());
    }

    public void backToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        c.operateButton((Button) v);
        textViewFinal.setText(c.getTextViewFinal().getText());
        textViewEstimate.setText(c.getTextViewEstimate().getText());
    }

    public void assignAllIds() {
        textViewFinal = findViewById(R.id.textViewFinal);
        textViewEstimate = findViewById(R.id.textViewEstimate);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);

        findViewById(R.id.buttonAC).setOnClickListener(this);
        findViewById(R.id.buttonC).setOnClickListener(this);
        findViewById(R.id.buttonBK).setOnClickListener(this);
        findViewById(R.id.buttonChange).setOnClickListener(this);
        findViewById(R.id.buttonDot).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonSub).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
    }
}