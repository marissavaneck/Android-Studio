package com.example.a31681.oefenjava2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.RADIO_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }
}
