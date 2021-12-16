package edu.neu.hm3.todolibrary.Data;


import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.neu.hm3.todolibrary.model.Task;
import edu.neu.hm3.todolibrary.util.taskRoomDB;

public class TaskRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public TaskRepository(Application application) {
        taskRoomDB db = taskRoomDB.getDatabase(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        taskRoomDB.dbWriterExecutor.execute( ()-> {
            taskDao.insertTask(task);
        });
    }

    public LiveData<Task> get(long id) {
        return taskDao.get(id);
    }

    public void update(Task task) {
        taskRoomDB.dbWriterExecutor.execute(()->taskDao.update(task));
    }

    public void delete(Task task) {
        taskRoomDB.dbWriterExecutor.execute(()->taskDao.delete(task));
    }
}
