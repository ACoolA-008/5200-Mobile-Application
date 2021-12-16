package edu.neu.hm3.todolibrary.util;

import java.util.Date;

import edu.neu.hm3.todolibrary.model.Priority;

public class TypeConverter {

    @androidx.room.TypeConverter
    public static Date fromTimeStamp(Long time){
        return time == null ? null : new Date(time);
    }

    @androidx.room.TypeConverter
    public static Long toTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }

    @androidx.room.TypeConverter
    public static String fromPriority(Priority p){
        return p == null ? null : p.name();
    }

    @androidx.room.TypeConverter
    public static Priority toPriority(String p){
        return p == null ? null : Priority.valueOf(p);
    }
}
