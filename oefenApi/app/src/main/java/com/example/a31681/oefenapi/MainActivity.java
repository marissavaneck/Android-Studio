package com.example.a31681.oefenapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Verbinding().execute();
    }

    class Verbinding extends AsyncTask<Void, Void, JSONObject> {
        private static  final String JSON_URL= "http://ip.jsontest.com/";
        String charset = "UTF-8";
        HttpURLConnection conn;
        StringBuilder result;
        URL urlObj;

        @Override
        protected JSONObject doInBackground(Void... args){
            JSONObject retObj = null;

            try{
                urlObj = new URL(JSON_URL);

                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setDoOutput(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Charset", charset);
                conn.setConnectTimeout(15000);
                conn.connect();

                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while (())

            }
        }
    }
}
