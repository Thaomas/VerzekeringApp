package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.verzekeringapp.models.InsurancePolicy
import java.util.UUID

@Dao
interface InsurerDAO {
    @Query("SELECT * FROM insurers")
    fun getAll()

    @Query("SELECT * FROM policies WHERE insurerId IS (:insurerId)")
    fun getAllInsurersPolicies(insurerId: UUID) : List<InsurancePolicy>
}