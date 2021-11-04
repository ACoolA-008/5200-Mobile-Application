package edu.neu.hm3.todolibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Task.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_task";
    private static final String COLUMN_ID = "task_id";
    private static final String COLUMN_TASK_NAME = "task_name";
    private static final String COLUMN_TASK_DETAILS = "task_details";
    private static final String COLUMN_UNITS = "task_units";


    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASK_NAME +
                " TEXT, " + COLUMN_TASK_DETAILS + " TEXT, " + COLUMN_UNITS +
                " INTEGER);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addTask(String title, String author, Integer pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TASK_NAME,title);
        cv.put(COLUMN_TASK_DETAILS,author);
        cv.put(COLUMN_UNITS,pages);
        long result = db.insert(TABLE_NAME,null,cv);
//        failed to insert data when result is -1.
        if (result == -1) {
            Toast.makeText(context,"Failed to insert",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"Successfully inserted",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor processAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
