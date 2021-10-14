package edu.neu.hm3.todolist.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import edu.neu.hm3.todolist.databinding.ToDoItemViewBinding;

public class ToDoItemRecyclerViewAdapter extends RecyclerView.Adapter<ToDoItemViewHolder> {

    @NonNull
    @Override
    public ToDoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoItemViewHolder(ToDoItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoItemViewHolder holder, int position) {
        // This is how we bind the UI to a specific task
        holder.bind(ToDoItemRepository.getAllTodos().asList().get(position));
    }

    @Override
    public int getItemCount() {
        return ToDoItemRepository.getAllTodos().asList().size();
    }
}
