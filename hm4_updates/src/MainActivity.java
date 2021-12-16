package edu.neu.hm3.todolibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import android.util.Log;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import edu.neu.hm3.todolibrary.model.SharedViewModel;
import edu.neu.hm3.todolibrary.model.Task;
import edu.neu.hm3.todolibrary.model.TaskViewModel;
import edu.neu.hm3.todolibrary.util.AddActivityFragment;

public class MainActivity extends AppCompatActivity implements ToDOClickListener{

    private static final String TAG = "task_ITEM";

    private TaskViewModel taskViewModel;
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    FloatingActionButton add_button;
    private int count;
    AddActivityFragment addActivityFragment;
    private SharedViewModel sharedViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;

        addActivityFragment = new AddActivityFragment();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        taskViewModel will allow me to call all the methods from TaskViewModel class
        taskViewModel = new ViewModelProvider.AndroidViewModelFactory(
                MainActivity.this.getApplication()).create(TaskViewModel.class);

       sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);



        taskViewModel.getAlltheTasks().observe(this,tasks -> {
                taskAdapter = new TaskAdapter(tasks,this);
                recyclerView.setAdapter(taskAdapter);
                });



        add_button = findViewById(R.id.add_button_floating);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Task t = new Task("ToDo" + count++, Priority.HIGH, Calendar.getInstance().getTime(),
//                        Calendar.getInstance().getTime(),false);
//
//                TaskViewModel.insert(t);

            showAddActivity();

            }
        });

    }



    private void showAddActivity() {
        addActivityFragment.show(getSupportFragmentManager(), addActivityFragment.getTag());
//        getSupportFragmentManager().beginTransaction().add(R.id.addActivity_layout, addActivityFragment).commit();

    }


    @Override
    public void click(Task task) {
        Log.d("Aloha", "onTodoClick: " + task.getTask());
//        Log.d("Click", "onTodoClick: " + adapterPosition);
      sharedViewModel.selectItem(task);
      sharedViewModel.setUpdate(Boolean.TRUE);
      showAddActivity();
//       showBottomSheet();



    }

    @Override
    public void checkBoxClick(Task task) {
        Log.d("Click", "onCheckBoxClick: " + task.getTask());
        TaskViewModel.delete(task);
        taskAdapter.notifyDataSetChanged();
    }
}