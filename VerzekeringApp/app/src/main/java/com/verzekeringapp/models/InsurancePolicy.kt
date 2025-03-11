package com.verzekeringapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
@Entity(tableName = "Policies")
data class InsurancePolicy(
    @PrimaryKey(autoGenerate = true)
    val uid: UUID = UUID.randomUUID(),
    val insurer: UUID,
    val name: String,
    val description: String
)
