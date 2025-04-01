package com.verzekeringapp.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Claims",
    foreignKeys = [
        ForeignKey(entity = InsurancePolicy::class,
            parentColumns = ["uid"],
            childColumns = ["policyId"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["policyId"])]
)

data class Claim(
    @PrimaryKey
    val uid: UUID = UUID.randomUUID(),
    val policyId: UUID,
    val description: String,
    val value: Double
)
