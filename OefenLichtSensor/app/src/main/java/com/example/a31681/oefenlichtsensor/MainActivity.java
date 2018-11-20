package com.example.a31681.oefenlichtsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
SensorManager mijnSensorManager;
Sensor mijnLichtSensor;
TextView lichtSensorData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SensorManager sensorManager = null;
//        sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor sensor : sensors){
//            Log.i("sensor", sensor.getName());
//        }

    lichtSensorData = (TextView)findViewById(R.id.lichtdata);
    mijnSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
    mijnLichtSensor = mijnSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    mijnSensorManager.registerListener(lichtSensorEventListener, mijnLichtSensor, SensorManager.SENSOR_DELAY_NORMAL);


    }

    SensorEventListener lichtSensorEventListener = new SensorEventListener() {


        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {

        }

        @Override
        public void onSensorChanged(SensorEvent arg0){
           if(arg0.sensor.getType()==Sensor.TYPE_LIGHT){
               lichtSensorData.setText("de gemeten hoeveelheid is" + String.valueOf(arg0.values[0]));
           }
        }


    };
}
