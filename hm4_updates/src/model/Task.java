package edu.neu.hm3.todolibrary.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
@Entity(tableName = "task_table")
public class Task {
    @ColumnInfo(name = "task_id")
    @PrimaryKey(autoGenerate = true)
    public long task_id;

//    @ColumnInfo(name = "task_title")
    public String task;
    public Priority priority;

    @ColumnInfo(name = "due_Date")
    public Date dueDate;
    @ColumnInfo(name = "creatingDate")
    public Date creatingDate;
    @ColumnInfo(name = "taskComplete")
    public boolean taskComplete;



    public Task(String task, Priority priority, Date dueDate, Date creatingDate, boolean taskComplete) {
        this.task = task;
        this.priority = priority;
        this.dueDate = dueDate;
        this.creatingDate = creatingDate;
        this.taskComplete = taskComplete;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }


    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public boolean isTaskComplete() {
        return taskComplete;
    }

    public void setTaskComplete(boolean taskComplete) {
        this.taskComplete = taskComplete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task='" + task + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", creatingDate=" + creatingDate +
                ", taskComplete=" + taskComplete +
                '}';
    }
}
