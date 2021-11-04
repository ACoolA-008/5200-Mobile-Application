package edu.neu.hm3.todolibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText task_title, task_details, task_units;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        task_title = findViewById(R.id.task_title_add);
        task_details = findViewById(R.id.task_detail_add);
        task_units = findViewById(R.id.task_units_add);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDBHelper my_DB = new MyDBHelper(AddActivity.this);
                my_DB.addTask(task_title.getText().toString().trim(),
                        task_details.getText().toString().trim(),
                        Integer.valueOf(task_units.getText().toString().trim()));
            }
        });
    }
}