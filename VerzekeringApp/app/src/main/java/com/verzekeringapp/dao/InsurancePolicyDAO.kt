package com.verzekeringapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.verzekeringapp.models.InsurancePolicy
import com.verzekeringapp.views.PolicyDetail
import java.util.UUID

@Dao
interface InsurancePolicyDAO {
    @Query("SELECT * FROM policies")
    fun getAll(): List<InsurancePolicy>

    @Query("SELECT * FROM policies WHERE customerId IS (:customerId)")
    fun getAllPoliciesFromCustomer(customerId: UUID) : List<InsurancePolicy>

    @Query("SELECT * FROM policies WHERE insurerId is (:insurerId)")
    fun getAllPoliciesFromInsurer(insurerId: UUID) : List<InsurancePolicy>

    @Query("SELECT * FROM PolicyDetail")
    fun getAllDetails(): List<PolicyDetail>

    @Insert
    fun insertAll(policies: List<InsurancePolicy>)
}