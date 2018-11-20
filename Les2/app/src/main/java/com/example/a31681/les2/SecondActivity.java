package com.example.a31681.les2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
int intResume;
String strResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("INFO", "onCreate");
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//        Intent intent = getIntent();
//        String mededeling = intent.getStringExtra(MainActivity.EXTRA_INFO);
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(mededeling);

    }
@Override
protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("AANTAL_KEER", intResume);
    super.onSaveInstanceState(savedInstanceState);
}

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
       intResume = savedInstanceState.getInt("AANTAL_KEER");
    }
    @Override
   protected void onResume(){
        super.onResume();
        intResume++;
        strResume = String.valueOf(intResume);
        Log.i("onResume", strResume);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i("INFO", "onPause");
//      }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i("INFO", "onResume");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i("INFO", "onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i("INFO", "onDestroy");
//    }



    public void startMainActivity(View view) {
       Intent intent = new Intent(this, MainActivity.class);
       startActivity(intent);
   }
}
