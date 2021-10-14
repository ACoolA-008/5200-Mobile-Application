package edu.neu.hm3.todolist.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import edu.neu.hm3.todolist.ToDoItemView;

public class ToDoItemViewHolder extends RecyclerView.ViewHolder {
    public ToDoItemViewBinding binding;

    public ToDoItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
