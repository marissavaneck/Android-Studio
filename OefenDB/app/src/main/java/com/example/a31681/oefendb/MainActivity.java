package com.example.a31681.oefendb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase gebruikersDB = this.openOrCreateDatabase("gebruikersDB", MODE_PRIVATE, null);

        File dbFile = getDatabasePath("gebruikersDB");
        if(dbFile.exists()){
            Log.i("database gebruikersDB", "bestaat");
        }else{
            Log.i("database gebruikerDB", "bestaat niet");
        }

    gebruikersDB.execSQL("INSERT INTO "
            + "gegevens"
            + " (Inlognaam, Wachtwoord)"
            + " VALUES ('Vladimir', '2213');");

        Cursor c = gebruikersDB.rawQuery("SELECT * FROM " + "gegevens" , null);
        int Column1 = c.getColumnIndex("Inlognaam");
        int Column2 = c.getColumnIndex("Wachtwoord");
        c.moveToFirst();
        String Name = c.getString(Column1);
        String WW = c.getString(Column2);
        Log.i(Name, WW);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.registreren:
                Log.d("test", "registreren button geklikt");
                break;

            case R.id.inloggen:
                Log.d("test", "inloggen button geklikt");
                break;
                }
                }



}
