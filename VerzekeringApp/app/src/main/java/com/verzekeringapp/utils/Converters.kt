package com.verzekeringapp.utils

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromUUID(uuid: UUID) : String {
        return uuid.toString();
    }

    @TypeConverter
    fun uuidFromString(string: String) : UUID {
        return UUID.fromString(string);
    }
}