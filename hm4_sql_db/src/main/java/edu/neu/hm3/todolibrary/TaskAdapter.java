package edu.neu.hm3.todolibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private Context context;
    private ArrayList task_id, task_name, task_details, task_units;

    TaskAdapter(Context context, ArrayList task_id, ArrayList task_name, ArrayList task_details,
                ArrayList task_units) {
        this.context = context;
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_details = task_details;
        this.task_units = task_units;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.task_id_txt.setText(String.valueOf(task_id.get(position)));
        holder.task_title_txt.setText(String.valueOf(task_name.get(position)));
        holder.task_details_txt.setText(String.valueOf(task_details.get(position)));
        holder.status_txt.setText(String.valueOf(task_units.get(position)));
    }

    @Override
    public int getItemCount() {
        return task_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView task_id_txt, task_title_txt, task_details_txt, status_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            task_id_txt = itemView.findViewById(R.id.task_id_text);
            task_title_txt = itemView.findViewById(R.id.task_title_txt);
            task_details_txt = itemView.findViewById(R.id.task_details_txt);
            status_txt = itemView.findViewById(R.id.status_txt);
        }
    }
}
