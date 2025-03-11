package com.verzekeringapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

abstract class User {
    @PrimaryKey(autoGenerate = true)
    val uid: UUID = UUID.randomUUID()

    @ColumnInfo(name = "name")
    val name: String = ""

    @ColumnInfo(name = "email")
    val email: String = ""

    @ColumnInfo("password")
    val password: String = ""
}