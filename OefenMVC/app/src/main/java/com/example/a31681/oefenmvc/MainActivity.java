package com.example.a31681.oefenmvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Model model1 = new Model();
    Controller controller1 = new Controller(model1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRefresh(View view){
        //roep later controller aan
        EditText etInputGetal = (EditText)  findViewById(R.id.inputGetal1);
        int getal = Integer.valueOf(etInputGetal.getText().toString());
        controller1.addToLijst(model1, getal);


        String strLijst = TextUtils.join(",", model1.getLijst());
        String strGemid = String.valueOf(model1.getGemiddelde());
        TextView tvLijstCijfers = (TextView)findViewById(R.id.LijstCijfers);
        tvLijstCijfers.setText("test1");

        TextView tvGemCijfers = (TextView)findViewById(R.id.gemidCijfers);
        tvGemCijfers.setText("test2");
    }
}
