package edu.neu.hm3.todolibrary.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.neu.hm3.todolibrary.Data.TaskRepository;

public class TaskViewModel extends AndroidViewModel {
    public static TaskRepository repository;
    public final LiveData<List<Task>> allTasks;
    public TaskViewModel(@NonNull Application application) {
        super(application);

        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }
    public LiveData<List<Task>> getAlltheTasks() {
        return allTasks;
    }

    public static void insert(Task task) {
        repository.insert(task);
    }

    public LiveData<Task> get(long id) {
        return repository.get(id);
    }

    public static void update(Task task) {
        repository.update(task);
    }

  public static void delete(Task task) {
        repository.delete(task);
  }
}
