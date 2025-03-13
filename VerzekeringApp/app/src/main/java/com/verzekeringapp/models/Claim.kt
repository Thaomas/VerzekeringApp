package com.verzekeringapp.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.UUID

@Entity(tableName = "Claims",
    foreignKeys = [
        ForeignKey(entity = InsurancePolicy::class,
            parentColumns = ["uid"],
            childColumns = ["policyId"],
            onDelete = ForeignKey.CASCADE)
    ]
)
data class Claim(
    @PrimaryKey(autoGenerate = true)
    val uid: UUID,
    val policyId: UUID,
    val description: String,
    val value: BigDecimal
)
