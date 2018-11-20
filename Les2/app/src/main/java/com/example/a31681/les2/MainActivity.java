package com.example.a31681.les2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


//    public static final string EXTRA_INFO = "default";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        Button b1=(Button) findViewById(R.id.button1);
//        setContentView(R.layout.activity_main);
//
////        Intent browserIntent = new Intent("android.intent.action.VIEW",
////                Uri.parse("https://developer.android.com/index.html"));
////        startActivity(browserIntent);
//    }
//
//public void startSecondActivity(View view){
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra(EXTRA_INFO, "dit bericht komt uit main activity");
//        startActivity(intent);
//}


    public static final String EXTRA_INFO = "default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_INFO, "dit bericht komt uit MainActivity");
        startActivity(intent);
    }
}
