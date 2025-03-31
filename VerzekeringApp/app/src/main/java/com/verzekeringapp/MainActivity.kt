package com.verzekeringapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.verzekeringapp.databinding.ActivityMainBinding
import com.verzekeringapp.utils.MockDataGenerator
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getDatabase(context = applicationContext)

        val customers = MockDataGenerator.generateCustomers()
        val insurers = MockDataGenerator.generateInsurers()
        val policies = MockDataGenerator.generateInsurancePolicies(customers, insurers)
        val claims = MockDataGenerator.generateClaims(policies)

        // Insert mock data into the database
        Thread {
            if (db.customerDao().getAll().size > 0)
                return@Thread

            db.customerDao().insertAll(customers)
            db.insurerDao().insertAll(insurers)
            db.policyDao().insertAll(policies)
            db.claimDao().insertAll(claims)
        }.start()
        Thread {
            db.claimDao().getALl();
            Log.println(Log.DEBUG,"DEBUG","Rando UUID"+UUID.randomUUID())
        }.start()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}