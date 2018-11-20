package com.example.a31681.oefendebug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText firstNumber;
    TextView addResult;
    Button btnVerdubbel;
    double num1, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText)findViewById(R.id.txtNumber1);
        addResult = (TextView)findViewById(R.id.txtResult);
        btnVerdubbel = (Button)findViewById(R.id.btnVerdubbel);

        btnVerdubbel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = Double.parseDouble(firstNumber.getText().toString());
                sum = verdubbelGetal(num1);
                addResult.setText(Double.toString(sum));
            }
        });
    }
    public double verdubbelGetal(double enterGetal){
        double returnGetal = enterGetal * 2;
        Log.i("VALUE", "return getal "+returnGetal);
        return returnGetal;
    }
}
