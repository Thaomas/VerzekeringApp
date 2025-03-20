package com.verzekeringapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.Date

@Entity(tableName = "Customers")
data class Customer(
    @ColumnInfo(name = "birthday")
    val birthdate: Date
) : User()
