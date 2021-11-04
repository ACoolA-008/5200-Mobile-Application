package edu.neu.hm3.todolibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDBHelper my_DB;
    ArrayList<String> task_id, task_title, task_details, task_units;
    TaskAdapter taskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button_floating);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        my_DB = new MyDBHelper(MainActivity.this);
        task_id = new ArrayList<>();
        task_title = new ArrayList<>();
        task_details = new ArrayList<>();
        task_units = new ArrayList<>();

        storeData();

        taskAdapter = new TaskAdapter(MainActivity.this, task_id, task_title, task_details, task_units);
        recyclerView.setAdapter(taskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }


    void storeData() {
        Cursor cursor = my_DB.processAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                task_id.add(cursor.getString(0));
                task_title.add(cursor.getString(1));
                task_details.add(cursor.getString(2));
                task_units.add(cursor.getString(3));
            }
        }
    }
}