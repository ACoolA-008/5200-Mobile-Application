package edu.neu.hm3.alarm_reminder_with_voice_command.Database;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = EntityClass.class, version = 1)
public abstract class DB extends RoomDatabase {
    private static DB INSTANCE;


    public static DB getDB(final Context context) {
        if (INSTANCE==null) {
            synchronized (DB.class) {
                if(INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DB.class,
                            "product_DB").build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract VoiceEventDao voiceEventDao();
}
