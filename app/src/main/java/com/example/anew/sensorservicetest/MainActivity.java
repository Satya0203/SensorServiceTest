package com.example.anew.sensorservicetest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        SensorManager sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor s1=sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(new SensorEventListener()
        {
            @Override
            public void onSensorChanged(SensorEvent event)
            {
                float[] values=event.values;
                tv1.setText(String.valueOf(values[0]));
                tv2.setText(String. valueOf(values[1]));
                tv3.setText(String.valueOf(values[2]));
               // tv4.setText(String.valueOf(values[3]));
                tv4.setText(String.valueOf(values[3]));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy)
            {

            }
        },s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}
