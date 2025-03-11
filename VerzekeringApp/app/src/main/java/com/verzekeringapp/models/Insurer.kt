package com.verzekeringapp.models

import androidx.room.Entity

@Entity(tableName = "Insurers")
data class Insurer(
    val description: String
) : User()
