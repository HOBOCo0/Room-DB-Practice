package com.example.roomdatabasepractice

import androidx.room.TypeConverter
import java.util.Date


/*
    SQLITE only supports
        1. NULL
        2. INTEGER
        3. REAL
        4. TEXT
        5. BLOB data type

        we need to write converts if we want to use other data types
 */
class Converters {
    @TypeConverter
    fun fromDatetoLong(value: Date): Long{
        return value.time
    }
    @TypeConverter
    fun fromLongToDate(value: Long): Date{
        return Date(value)
    }
}