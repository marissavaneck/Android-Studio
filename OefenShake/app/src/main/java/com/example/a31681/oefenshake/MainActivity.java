package com.example.a31681.oefenshake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
private SensorManager senSensorManager;
private Sensor senAccelerometer;

private long tijdEerder = 0;
private float last_x, last_y, last_z;
private static final int SHAKE_TRESHOLD = 5;
private long tijdNu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

@Override
    public void onSensorChanged(SensorEvent sensorEvent){
        Sensor mySensor = sensorEvent.sensor;

        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            tijdNu = System.currentTimeMillis();

            if ((tijdNu - tijdEerder) > 3000){
                long tijdVerschil = (tijdNu - tijdEerder);
                tijdEerder = tijdNu;
                float beweging = Math.abs(x + y + z - last_x - last_y - last_z)/ tijdVerschil * 1000;

                if((beweging > SHAKE_TRESHOLD)){
                    getRandomNumber();
                }

                last_x = x;
                last_y = y;
                last_z = z;



            }
        }
}

private void getRandomNumber() {
    Random randNumber = new Random();
    int iNumber = (randNumber.nextInt(6) + 1);
    String message1 = "je hebt" + iNumber + " gegooit.";

    Log.d("test", message1);
    Toast.makeText(MainActivity.this, message1, Toast.LENGTH_LONG).show();
}

public void onAccuracyChanged(Sensor sensor, int accuracy){


}
protected void onPause(){
        super.onPause();
        senSensorManager.unregisterListener(this);
}

    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    }


