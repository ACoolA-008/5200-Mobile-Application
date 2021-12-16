package edu.neu.hm3.todolibrary.util;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.neu.hm3.todolibrary.Data.TaskDao;
import edu.neu.hm3.todolibrary.model.Task;

@Database(entities = {Task.class}, version = 2, exportSchema = false)
@TypeConverters({TypeConverter.class})
public abstract class taskRoomDB extends RoomDatabase {
    public static final int NUMBER_OF_THREADS = 4;
    public static volatile taskRoomDB INSTANCE;
    public static final String DATABASE_NAME = "todo_database";
    public static final ExecutorService dbWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    dbWriterExecutor.execute(() ->{
                        TaskDao taskDao = INSTANCE.taskDao();
                        taskDao.deleteAllData();
                    });
                }
            };

    public static taskRoomDB getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (taskRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            taskRoomDB.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract TaskDao taskDao();
}
