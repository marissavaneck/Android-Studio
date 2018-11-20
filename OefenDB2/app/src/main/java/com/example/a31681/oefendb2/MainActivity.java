package com.example.a31681.oefendb2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
            Log.i("database gebruikersDB", "bestaat niet");
        }
        gebruikersDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + "gegevens"
                + " (Inlognaam VARCHAR, Wachtwoord Varchar);");



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

    public void onClick(View view) {
        SQLiteDatabase gebruikersDB = this.openOrCreateDatabase("gebruikerDB", MODE_PRIVATE, null);

        EditText username = (EditText) findViewById(R.id.etInlognaam);
        EditText password = (EditText) findViewById(R.id.etWachtwoord);
        String gebruiker = username.getText().toString();
        String ww = password.getText().toString();

        switch (view.getId()) {
            case R.id.registreren:
                Log.i("registreren", "gelukt");
                String sql = "INSERT or replace INTO gegevens(Inlognaam, Wachtwoord) VALUES('" + gebruiker + "', '" + ww + "')";
                gebruikersDB.execSQL(sql);
                break;

            case R.id.inloggen:
                String table = "gegevens";
                String[] columnsToReturn = {"Wachtwoord"};
                String selection = "Inlognaam =?";
                String[] selectionArgs = {gebruiker};

                try {
                    Cursor cursor = gebruikersDB.query(table, columnsToReturn, selection, selectionArgs, null, null, null);
                    cursor.moveToLast();
                    String column1 = cursor.getString(0);
                    if (column1.equals(ww)) {
                        Log.d(column1, "inloggen button geklikt");
                        //andere activity gaan
                    } else {
                        Log.d(column1, "inloggen mislukt");
                    }
                    cursor.close();
                    break;
                } catch (android.database.CursorIndexOutOfBoundsException e) {
                    Log.d(gebruiker, "bestaat waarschijnlijk niet");
                }

        }
        }


    }
