package edu.neu.hm3.todolibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import edu.neu.hm3.todolibrary.model.Task;
import edu.neu.hm3.todolibrary.util.Utility;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {


    private final List<Task> listOfTasks;
    private final ToDOClickListener toDOClickListener;

    public TaskAdapter(List<Task> listOfTasks,ToDOClickListener onToDoClickListener) {
        this.toDOClickListener = onToDoClickListener;
        this.listOfTasks = listOfTasks;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = listOfTasks.get(position);

        String dateFormat = Utility.dateFormatter(task.getDueDate());

        holder.task.setText(task.getTask());

        holder.calendar.setText(dateFormat);

    }

    @Override
    public int getItemCount() {
        return listOfTasks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//        public AppCompatRadioButton checkbox_button;
        public RadioButton checkbox_button;
        public TextView task;
        public Chip calendar;
        ToDOClickListener anotherTodoClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox_button = itemView.findViewById(R.id.checkbox_my_row);
            task = itemView.findViewById(R.id.task_my_row);
            calendar = itemView.findViewById(R.id.calendar_my_row);
            // toDOClickListener is the top one that's been initiated
            this.anotherTodoClickListener = toDOClickListener;

            //indicates line 59 onClickListener
            itemView.setOnClickListener(this);

            checkbox_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int id = v.getId();
            Task aTask = listOfTasks.get(getAdapterPosition());

            if (id == R.id.layout_my_row) {
                //get a task from the list and then find the position of this task
                toDOClickListener.click(aTask);
            } else if (id == R.id.checkbox_my_row) {
                toDOClickListener.checkBoxClick(aTask);
            }
        }
    }
}
