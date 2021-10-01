package edu.neu.neusea_allisoncheng_lesson_2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView mCounterText;
    private Button mCounterButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.counter_textview);
        Log.d(LOG_TAG, "-----");
        Log.d(LOG_TAG, "onCreate");
        mCounterText = mShowCount;
        mCounterButton = findViewById(R.id.count_button);
        mEditText = findViewById(R.id.editText);

        if (savedInstanceState!= null) {
            boolean isVisible = savedInstanceState.getBoolean("counter_button_visible");
            if (isVisible) {
                mCounterText.setText(savedInstanceState.getString("counter_text"));
                mCounterButton.setVisibility(View.VISIBLE);
                mEditText.setVisibility(View.VISIBLE);
            }
        }
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mCounterButton.getVisibility() == View.VISIBLE) {
            outState.putBoolean("counter_button_visible", true);
            outState.putString("counter_text", mCounterText.getText().toString());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}