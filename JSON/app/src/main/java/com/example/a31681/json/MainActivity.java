package com.example.a31681.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View view){
        try{
        JSONArray reader = new JSONArray(readJSONFromAsset());
        EditText tvVoornaam = (EditText) findViewById(R.id.edittext1);
        TextView tvAchternaam = (TextView) findViewById(R.id.textview2);
        String voornaamVriend = tvVoornaam.getText().toString();

        for (int x = 0; x < reader.length(); x++) {
            JSONObject vriend = reader.getJSONObject(x);
            String voornaam = vriend.getString("voornaam");
            String achternaam = vriend.getString("achternaam");
            if (voornaam.equals(voornaamVriend)) {
                tvAchternaam.setText(achternaam);
            }
        }
        }catch (JSONException E){
            e.printStackTrace();
        }

    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("studenten.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
