package com.verzekeringapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "Customers",
    indices = [Index(value = ["email"], unique = true)]
)
data class Customer(
    @PrimaryKey
    override val uid: UUID = UUID.randomUUID(),

    override val name: String,

    override val email: String,

    override val password: String,

    @ColumnInfo(name = "birthday")
    val birthdate: Date
) : User
