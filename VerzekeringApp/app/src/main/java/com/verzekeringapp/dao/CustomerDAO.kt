package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.verzekeringapp.models.Customer
import java.util.UUID

@Dao
interface CustomerDAO {
    @Query("SELECT * FROM customers")
    fun getAll(): List<Customer>

    @Query("SELECT * FROM customers WHERE uid IN (:customerIds)")
    fun loadAllByIds(customerIds: List<UUID>): List<Customer>

    @Query("SELECT * FROM customers WHERE email IS (:userEmail) LIMIT 1")
    fun getCustomerByEmail(userEmail : String) : Customer

    @Insert
    fun insertCustomer(vararg customer : Customer)

    @Insert
    fun insertAll(customers : List<Customer>)
}