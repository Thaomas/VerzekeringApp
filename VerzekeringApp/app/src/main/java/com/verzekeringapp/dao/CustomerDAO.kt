package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.verzekeringapp.models.User
import java.util.UUID

@Dao
interface CustomerDAO {
    @Query("SELECT * FROM customers")
    fun getAll(): List<User>

    @Query("SELECT * FROM customers where uid in (:customerIds)")
    fun loadAllByIds(customerIds: List<UUID>): List<User>
}