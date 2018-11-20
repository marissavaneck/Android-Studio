package com.example.a31681.usrinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    public static final String NAAM_MESSAGE = "naam_gebruiker";
    public static final String RADIO_MESSAGE = "aanhef_gebruiker";
    public static final String LEEFTIJD_MESSAGE = "leeftijd_gebruiker";
    private RadioGroup radioGroup;
    private String selectedString;
    private RadioButton besteId, mevrouwId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startSecondActivity(View view) {
        int leeftijd;

        //intent
        Intent intent = new Intent(this, Main2Activity.class);

        // naam van gebruiker
        EditText editText = (EditText) findViewById(R.id.editText2);
        String naam = editText.getText().toString();
        intent.putExtra(NAAM_MESSAGE, naam);


        //aanhef gebruiker
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        besteId = (RadioButton) findViewById(R.id.radioButtonBeste);
        mevrouwId = (RadioButton) findViewById(R.id.radioButtonMevrouw);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == besteId.getId()) {
            selectedString = "Beste";
        } else if (selectedId == mevrouwId.getId()) {
            selectedString = "Mevrouw";
        } else {
            selectedString = "Mijnheer";
        }
        intent.putExtra(RADIO_MESSAGE, selectedString);


        //leeftijd
        EditText editLeeftijd = (EditText) findViewById(R.id.editText3);
        int leeftijdInt;
        int yearToday = Calendar.getInstance().get(Calendar.YEAR);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) {
            leeftijdInt = yearToday - Integer.parseInt(editLeeftijd.getText().toString());
        } else {
            leeftijdInt = yearToday - Integer.parseInt(editLeeftijd.getText().toString()) - 1;
        }
        String leeftijdString = String.valueOf(leeftijdInt);
        intent.putExtra(LEEFTIJD_MESSAGE, leeftijdString);
        startActivity(intent);
    }
}
