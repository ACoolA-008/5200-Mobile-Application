package edu.neu.hm3.todolibrary.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.neu.hm3.todolibrary.model.Task;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(Task task);
    @Query("DELETE FROM task_table")
    void deleteAllData();

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM task_table WHERE task_table.task_id = :id")
    LiveData<Task> get(long id);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);
}
