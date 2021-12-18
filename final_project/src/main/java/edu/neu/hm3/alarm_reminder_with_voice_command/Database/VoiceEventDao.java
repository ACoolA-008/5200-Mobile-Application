package edu.neu.hm3.alarm_reminder_with_voice_command.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface VoiceEventDao {
    @Insert
    void insertAll(EntityClass entity);

    @Query("SELECT * FROM voiceTable")
    List<EntityClass> getAllData();
}
