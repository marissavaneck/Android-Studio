package com.example.a31681.oefenjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String varMessage1 = "Java leer je door te oefenen";
        String varMessage2 = " dus doe je best";
        TextView myTextView = (TextView)findViewById(R.id.textView1);
        myTextView.setText(varMessage1 + varMessage2);

        int varInt1 = 5;
        int varInt2 = 9;
        myTextView.setText(varInt1+varInt2);


        public Object getStudentNaam() {
            Student student17244 = new Student("Piet de Koning", 17244);

        }



    }



}
