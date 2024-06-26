package com.example.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
    }

    public void goToBasic(View view) {
        Intent intent = new Intent(this, BasicActivity.class);
        startActivity(intent);
    }

    public void goToAdvanced(View view) {
        Intent intent = new Intent(this, AdvancedActivity.class);
        startActivity(intent);
    }

    public void goToInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void quitApp(View view) {
        finish();
        System.exit(0);
    }
}
