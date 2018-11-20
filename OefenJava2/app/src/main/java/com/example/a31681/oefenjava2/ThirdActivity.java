package com.example.a31681.oefenjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    ArrayList<String> merken = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

    }
    public void autoMerk(View v){
        EditText merk = (EditText) findViewById(R.id.editTextMerk);
        String selectedText = merk.getText().toString();

        TextView mededeling = (TextView) findViewById(R.id.textViewMededeling);


       if( merken.contains(selectedText)){
           mededeling.setText("merk is al bekend");


       }else{
           mededeling.setText("");
           merken.add(selectedText);
       }
    }
}
