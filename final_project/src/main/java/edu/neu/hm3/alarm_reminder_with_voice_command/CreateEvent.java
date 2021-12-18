package edu.neu.hm3.alarm_reminder_with_voice_command;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.neu.hm3.alarm_reminder_with_voice_command.Database.AlarmBroadcast;
import edu.neu.hm3.alarm_reminder_with_voice_command.Database.DB;
import edu.neu.hm3.alarm_reminder_with_voice_command.Database.EntityClass;

public class CreateEvent extends AppCompatActivity implements View.OnClickListener{
    private ImageView record_Button;
    private Button time_Button;
    private Button date_Button;
    private Button complete_Button;
    private EditText editText;
    private String time_Notification;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        record_Button = findViewById(R.id.record_button);
        time_Button = findViewById(R.id.time_Button);
        date_Button = findViewById(R.id.date_Button);
        complete_Button = findViewById(R.id.complete_Button);
        editText = findViewById(R.id.edit_Text);

        record_Button.setOnClickListener(this);
        time_Button.setOnClickListener(this);
        date_Button.setOnClickListener(this);
        complete_Button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == record_Button) {
            recordVoiceCommand();
        }
        else if(v == time_Button) {
            pickTime();
        }
        else if(v == date_Button) {
            pickDate();
        }
        else {
            submit();
        }
    }

    private void submit() {
        String text = editText.getText().toString().trim();
        if(text.isEmpty()) {
            Toast.makeText(this, "Enter or Record the voice command", Toast.LENGTH_SHORT).show();
        }
        else {
            if(time_Button.getText().toString().equals("Pick a Time") && date_Button.toString().equals("Pick a Date")){
            Toast.makeText(this,"Pick a time and date", Toast.LENGTH_SHORT).show();
            }else{
                String editext_value = editText.getText().toString().trim();
                String date_value = date_Button.getText().toString().trim();
                String time_value = time_Button.getText().toString().trim();

                EntityClass entity = new EntityClass();
                entity.setEventDate(date_value);
                entity.setEventDate(editext_value);
                entity.setEventDate(time_value);
                db.voiceEventDao().insertAll(entity);
                setUpAlarm(editext_value, date_value, time_value);


            }
        }
    }

    private void recordVoiceCommand() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");

        try{
            startActivityForResult(intent,1);
        }
        catch (Exception e) {
            Toast.makeText(this, "Voice command is not supported", Toast.LENGTH_SHORT).show();
        }
    }

    private void pickTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time_Notification=hourOfDay + ":" + minute;
                time_Button.setText(FormatTime(hourOfDay, minute));
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }

    private void pickDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date_Button.setText(day + "-" + (month + 1) + "-" + year);
            }
        },year, month, day);
        datePickerDialog.show();
    }

    public String FormatTime(int hour, int minute) {

        String time;
        time = "";
        String formattedMinute;

        if (minute / 10 == 0) {
            formattedMinute = "0" + minute;
        } else {
            formattedMinute = "" + minute;
        }


        if (hour == 0) {
            time = "12" + ":" + formattedMinute + " AM";
        } else if (hour < 12) {
            time = hour + ":" + formattedMinute + " AM";
        } else if (hour == 12) {
            time = "12" + ":" + formattedMinute + " PM";
        } else {
            int temp = hour - 12;
            time = temp + ":" + formattedMinute + " PM";
        }


        return time;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if(resultCode==RESULT_OK && data != null) {
                ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                editText.setText(text.get(0));
            }
        }
    }
    private void setUpAlarm(String text, String date, String time) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(getApplicationContext(), AlarmBroadcast.class);
        intent.putExtra("event", text);
        intent.putExtra("date", date);
        intent.putExtra("time", time);

        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(), 0,intent,PendingIntent.FLAG_ONE_SHOT);

        String dateandtime = date + " " + time_Notification;
        DateFormat formatter = new SimpleDateFormat("d-M-yyyy hh:mm");
        try {
            Date date1 = formatter.parse(dateandtime);
            alarmManager.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        finish();
    }


}