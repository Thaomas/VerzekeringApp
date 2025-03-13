package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.verzekeringapp.models.Customer
import com.verzekeringapp.models.InsurancePolicy
import java.util.UUID

@Dao
interface InsurerDAO {
    @Query("SELECT * FROM insurers")
    fun getAll()

    @Query("SELECT * FROM policies WHERE insurerId IS (:insurerId)")
    fun getAllInsurersPolicies(insurerId: UUID) : List<InsurancePolicy>

    @Query("SELECT DISTINCT c.* FROM Customers c INNER JOIN Policies p ON c.uid IS p.customerId WHERE p.insurerId IS (:insurerId)")
    fun getListOfCustomers(insurerId: UUID) : List<Customer>

    @Insert
    fun insertAll()
}