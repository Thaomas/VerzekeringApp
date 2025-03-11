package com.verzekeringapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.verzekeringapp.dao.CustomerDAO
import com.verzekeringapp.dao.InsurancePolicyDAO
import com.verzekeringapp.models.Customer
import com.verzekeringapp.models.InsurancePolicy

@Database(entities = [Customer::class, InsurancePolicy::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDAO
    abstract fun policyDAO(): InsurancePolicyDAO
}