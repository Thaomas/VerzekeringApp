package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.verzekeringapp.models.Claim

@Dao
interface ClaimDAO {
    @Query("SELECT * FROM Claims")
    fun getALl() : List<Claim>

    @Insert
    fun insertClaim(vararg claim: Claim)

    @Insert
    fun insertAll(claims : List<Claim>)
}