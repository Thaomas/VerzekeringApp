package com.verzekeringapp.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Policies",
    foreignKeys = [
        ForeignKey(entity = Insurer::class,
            parentColumns = ["uid"],
            childColumns = ["insurerId"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Customer::class,
            parentColumns = ["uid"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["insurerId"]), Index(value = ["customerId"])]
)data class InsurancePolicy(
    @PrimaryKey
    val uid: UUID = UUID.randomUUID(),
    val insurerId: UUID,
    val customerId: UUID,
    val name: String,
    val description: String
)