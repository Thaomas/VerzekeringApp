package com.verzekeringapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.verzekeringapp.dao.ClaimDAO
import com.verzekeringapp.dao.CustomerDAO
import com.verzekeringapp.dao.InsurancePolicyDAO
import com.verzekeringapp.dao.InsurerDAO
import com.verzekeringapp.models.Claim
import com.verzekeringapp.models.Customer
import com.verzekeringapp.models.InsurancePolicy
import com.verzekeringapp.models.Insurer
import com.verzekeringapp.utils.Converters
import com.verzekeringapp.views.PolicyDetail

@Database(entities = [Customer::class, Insurer::class, InsurancePolicy::class, Claim::class],
    views = [PolicyDetail::class],
    version = 1)
@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun customerDao(): CustomerDAO
    abstract fun policyDao(): InsurancePolicyDAO
    abstract fun insurerDao(): InsurerDAO
    abstract fun claimDao(): ClaimDAO
}