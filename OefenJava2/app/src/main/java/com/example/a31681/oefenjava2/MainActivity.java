package com.example.a31681.oefenjava2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    String rechtkinderbijslag;
    int leeftijd = 22;
    public static final String RADIO_MESSAGE = "jaargetijden";
    private RadioGroup radioGroup;
    private RadioButton lente, zomer, herfst, winter;
    private String selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if (leeftijd < 18){
            rechtkinderbijslag = "jij hebt recht op kinderbijslag";
        }
        else{
            rechtkinderbijslag = "jij hebt geen recht op kinderbijslag";
        }
        TextView myTextView = (TextView) findViewById(R.id.textView1);
        myTextView.setText(rechtkinderbijslag);*/

    }
        public void startSecondActivity (View view){
            Intent intent = new Intent(this, SecondActivity.class);

            radioGroup = (RadioGroup) findViewById(R.id.jaargetijden);
            lente = (RadioButton) findViewById(R.id.lente);
            zomer = (RadioButton) findViewById(R.id.zomer);
            herfst = (RadioButton) findViewById(R.id.herfst);
            winter = (RadioButton) findViewById(R.id.winter);

            int selectedID = radioGroup.getCheckedRadioButtonId();
            if (selectedID == lente.getId()) {
                selectedText = lente.getText().toString();
            } else if (selectedID == zomer.getId()) {
                selectedText = zomer.getText().toString();
            } else if (selectedID == herfst.getId()) {
                selectedText = herfst.getText().toString();
            } else {
                selectedText = winter.getText().toString();
            }


            intent.putExtra(RADIO_MESSAGE, selectedText);
            startActivity(intent);
        }
        public void writeHallo(View v) {
        TextView tv = (TextView)findViewById(R.id.hallo);
        String mededeling ="";
        for(int i = 0; i < 5; i++){
            mededeling = mededeling + " hallo";
        }
        tv.setText(mededeling);
        }
        public  void writeWorld(View v){
        TextView tv = (TextView)findViewById(R.id.world);
        String mededeling = "";
        int i = 0;


    while(i < 10){
        mededeling = mededeling + 1;
        i++;
    }
    }
    public void startThirdActivity (View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
}
}

