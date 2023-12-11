package com.sildtech.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowerResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_result);

        TextView text = findViewById(R.id.res);

        Intent i= getIntent();
        String res = i.getStringExtra("restext");

        text.setText(res);
    }
}