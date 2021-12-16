package edu.neu.hm3.todolibrary.util;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;
import java.util.Date;

import edu.neu.hm3.todolibrary.R;
import edu.neu.hm3.todolibrary.model.Priority;
import edu.neu.hm3.todolibrary.model.SharedViewModel;
import edu.neu.hm3.todolibrary.model.Task;
import edu.neu.hm3.todolibrary.model.TaskViewModel;

public class AddActivityFragment extends BottomSheetDialogFragment {

    private EditText enterTaskTitle;
    private EditText enterTaskDetail;
    private ImageButton priorityButton;
    private ImageButton calendarButton;
    private ImageButton saveButton;
    private RadioGroup priorityRadioGroup;
    private Integer priorityButtonId;
    private CalendarView calendarView;
    private Date deadline;
    Calendar calendar = Calendar.getInstance();
    private SharedViewModel sharedViewModel;
    private Boolean Update;
    Priority priority;
    public AddActivityFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_add, container, false);
        enterTaskTitle = v.findViewById(R.id.task_title_add);
        enterTaskDetail = v.findViewById(R.id.task_details_add);
        priorityButton = v.findViewById(R.id.priority_button_add);
        calendarButton = v.findViewById(R.id.calendar_button_add);
        saveButton = v.findViewById(R.id.save_button_add);
        priorityRadioGroup = v.findViewById(R.id.radioGroup);
        calendarView = v.findViewById(R.id.calendarView);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (sharedViewModel.getItem().getValue() != null) {
            Update = sharedViewModel.getUpdate();
            Task task = sharedViewModel.getItem().getValue();
            enterTaskTitle.setText(task.getTask());
            Log.d("MY", "onViewCreated: " + task.getTask());
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        CAN BE DELETED IF NOT WORKING!!!!!
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the view is gone, set the view to visible when click on it.
                calendarView.setVisibility(calendarView.getVisibility() == View.GONE ?
                        View.VISIBLE : View.GONE);
                Utility.hideKeyboard(v);
            }
        });

        //month + 1 to convert into actual month
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                calendar.clear();
                calendar.set(year, month, dayOfMonth);
                deadline = calendar.getTime();
//                Log.d("Cal", "onViewCreated: month" + (month + 1)
//                + ", day " + dayOfMonth);
            }
        });

        priorityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.hideKeyboard(v);
                priorityRadioGroup.setVisibility(priorityRadioGroup.getVisibility()==View.GONE ?
                        View.VISIBLE : View.GONE);
                priorityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(priorityRadioGroup.getVisibility()==View.VISIBLE) {
                            priorityButtonId=checkedId;
                            priorityButton = view.findViewById(priorityButtonId);
                            if(priorityButton.getId()==R.id.priority_high_add) {
                                priority=Priority.HIGH;
                            }else if(priorityButton.getId()==R.id.priority_medium_add){
                                priority=Priority.MEDIUM;
                            }else if(priorityButton.getId()==R.id.priority_low_add) {
                                priority=Priority.LOW;
                            }else {
                                priority=Priority.LOW;
                            }
                        }else{
                            priority=Priority.LOW;
                        }
                    }
                });
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskTitle = enterTaskTitle.getText().toString().trim();
                if(deadline != null && !TextUtils.isEmpty(taskTitle)) {
                    Task newTask = new Task(taskTitle,
                            priority,
                            deadline,
                            Calendar.getInstance().getTime(),
                            false);
                    if(Update) {
                        Task updatedTask = sharedViewModel.getItem().getValue();
                        updatedTask.setTask(taskTitle);
                        updatedTask.setDueDate(deadline);
                        updatedTask.setCreatingDate(Calendar.getInstance().getTime());
                        updatedTask.setPriority(priority);
                        TaskViewModel.update(updatedTask);
                        sharedViewModel.setUpdate(Boolean.FALSE);
                    }else {
                        TaskViewModel.insert(newTask);
                    }

                }

            }
        });
    }

}
