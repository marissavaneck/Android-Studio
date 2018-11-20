package com.example.a31681.usrinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String naam = intent.getStringExtra(MainActivity.NAAM_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(naam);

        String aanhef = intent.getStringExtra(MainActivity.RADIO_MESSAGE);
        TextView textView1 = (TextView) findViewById(R.id.textView2);
        textView1.setText(aanhef);

    }


}
