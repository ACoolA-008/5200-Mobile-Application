package edu.neu.hm3.alarm_reminder_with_voice_command.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "voiceTable")
public class EntityClass {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "eventName")
    String eventName;
    @ColumnInfo(name = "eventDate")
    String eventDate;
    @ColumnInfo(name = "eventTime")

    String eventTime;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
