package com.verzekeringapp.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Insurers",
    indices = [Index(value = ["email"], unique = true)]
)
data class Insurer(
    @PrimaryKey
    override val uid: UUID = UUID.randomUUID(),

    override val name: String,

    override val email: String,

    override val password: String,

    val description: String
) : User{
    override fun toString(): String {
        return name
    }
}
