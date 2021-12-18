package edu.neu.hm3.alarm_reminder_with_voice_command;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.hm3.alarm_reminder_with_voice_command.Adapter.EventAdapter;
import edu.neu.hm3.alarm_reminder_with_voice_command.Database.DB;
import edu.neu.hm3.alarm_reminder_with_voice_command.Database.EntityClass;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button createEvent_Button;
    private EventAdapter eventAdapter;
    private RecyclerView recyclerView;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent_Button = findViewById(R.id.Create_Event_Button);
        recyclerView = findViewById(R.id.recyclerview);
        createEvent_Button.setOnClickListener(this);
        db = DB.getDB(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAdapter();
    }

    private void setAdapter() {
        List<EntityClass> classList = db.voiceEventDao().getAllData();
        eventAdapter = new EventAdapter(getApplicationContext(), classList);
        recyclerView.setAdapter(eventAdapter);
    }


    @Override
    public void onClick(View view) {
        if (view == createEvent_Button) {
            goToCreateEventActivity();
        }
    }

    private void goToCreateEventActivity() {
        Intent intent = new Intent(getApplicationContext(), CreateEvent.class);
        startActivity(intent);
    }
}
