package edu.neu.neusea_allisoncheng_lesson_1_1new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Hello World. debug");
        Log.v(TAG, "Hello World. verbose");
        Log.e(TAG, "Hello World. error");
        Log.i(TAG, "Hello World. information");

    }
}