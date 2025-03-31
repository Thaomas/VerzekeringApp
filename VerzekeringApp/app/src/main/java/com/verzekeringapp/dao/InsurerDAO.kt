package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.verzekeringapp.models.InsurancePolicy
import com.verzekeringapp.models.Insurer
import java.util.UUID

@Dao
interface InsurerDAO {
    @Query("SELECT * FROM insurers")
    fun getAll() : List<Insurer>

    @Query("SELECT * FROM policies WHERE insurerId IS (:insurerId)")
    fun getAllInsurersPolicies(insurerId: UUID) : List<InsurancePolicy>

    @Insert
    fun insertAll(insurers : List<Insurer>)
}