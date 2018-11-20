package com.example.a31681.les3;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

//import static android.icu.text.DisplayContext.LENGTH_SHORT;
import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void startThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
    public void maakSnackbar(View view){
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),
                "dit is een mededeling", LENGTH_SHORT);
                mySnackbar.show();
    }
}
